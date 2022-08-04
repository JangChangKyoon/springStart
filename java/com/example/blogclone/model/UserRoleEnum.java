package com.example.blogclone.model;


public enum UserRoleEnum {
    USERS(Authority.USERS),  // 사용자 권한
    ADMIN(Authority.ADMIN);  // 관리자 권한

    private final String authority;

    UserRoleEnum(String authority) {
        this.authority = authority;
    }
    public String getAuthority() {
        return this.authority;
    }

//    private static final String PREFIX_ROLE = "ROLE_";
//
//    public String getAuthority() {
//        return PREFIX_ROLE + USERS;
//    }

    public static class Authority {
        public static final String USERS = "ROLE_USER";
        public static final String ADMIN = "ROLE_ADMIN";
    }
}