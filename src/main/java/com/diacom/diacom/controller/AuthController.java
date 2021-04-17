package com.diacom.diacom.controller;

import com.diacom.diacom.SecurityService.UserDetailsImpl;
import com.diacom.diacom.SecurityService.jwt.JwtUtils;
import com.diacom.diacom.SecurityService.payloads.request.LoginRequest;
import com.diacom.diacom.SecurityService.payloads.request.SignupRequest;
import com.diacom.diacom.SecurityService.payloads.response.JwtResponse;
import com.diacom.diacom.SecurityService.payloads.response.MessageResponse;
import com.diacom.diacom.entity.Role;
import com.diacom.diacom.entity.User;
import com.diacom.diacom.repository.RoleRepository;
import com.diacom.diacom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/diacom")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getPhoneNumber(),
                userDetails.getAge(),
                userDetails.getGender(),
                userDetails.getSugarType(),
                userDetails.getHeight(),
                userDetails.getWeight(),
                userDetails.getNameOfDoctor(),
                roles));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        if (userRepository.existsByLogin(signupRequest.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByPhoneNumber(signupRequest.getPhoneNumber())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signupRequest.getName(),
                signupRequest.getLogin(),
                encoder.encode(signupRequest.getPassword()),
                signupRequest.getPhoneNumber(),
                signupRequest.getAge(),
                signupRequest.getGender(),
                signupRequest.getSugarType(),
                signupRequest.getHeight(),
                signupRequest.getWeight(),
                signupRequest.getNameOfDoctor());

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
