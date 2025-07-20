package com.charcha.util;

public class AnonymousNameGenerator {

    public static String generateAnonymousId() {
        return "User" + (int)(Math.random() * 10000);
    }
}
