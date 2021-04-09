//package com.diacom.diacom.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    DataSource dataSource;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.authorizeRequests()
//                .antMatchers("/diacom/registration").not().fullyAuthenticated()
//                .antMatchers("/diacom/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                //Настройка для входа в систему
//                .formLogin()
//              //  .loginPage("/diacom/login")
//                //Перенарпавление на главную страницу после успешного входа
//                .defaultSuccessUrl("/diacom")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/");
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select login, passwordd " +
//                        "from users where login = ?");
//              //  .authoritiesByUsernameQuery("SELECT login, passwordd FROM users " +
//              //          "INNER JOIN users_roles " +
//                //        "on users_roles.id = users.id where users.login = ?");
//
//    }
//
//}
