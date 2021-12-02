package com.asquare.shared;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utils {

    private final static String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static Random random = new Random();

    public String generateId(int length){
        return generateRandomString(length);
    }

    private String generateRandomString(int length){
        StringBuilder salt = new StringBuilder();
        for (int i =0; i < length; i++)
            salt.append(SALTCHARS.charAt(random.nextInt(SALTCHARS.length())));
        return salt.toString();
    }
}
