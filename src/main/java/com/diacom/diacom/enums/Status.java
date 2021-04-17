package com.diacom.diacom.enums;

public enum Status {
    SUCCESS(0),
    USER_ALREADY_EXISTS(1),
    FAILURE(2);

    int status;

    Status(int status) {
        this.status = status;
    }
}

