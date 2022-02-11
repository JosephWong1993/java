package com.wong.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
    public static void main(String[] args) {
        //$2a$10$MqsPJmDKf9UY6IXBt1pLceWXMRkqE8K4zE//74M/0CivdidyqYbCe
        //$2a$10$DVeX4uaGHevQtrBPtkJpy.qQnL0fgNvG2KFluU8FNst8lMFJLiv2W
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("1234");
        System.out.println(password);

        boolean matches = encoder.matches("1234",
                "$2a$10$DVeX4uaGHevQtrBPtkJpy.qQnL0fgNvG2KFluU8FNst8lMFJLiv2W");
        System.out.println(matches);
    }
}
