package com.charcha.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNameGenerator {

    private static final String[] adjectives = {"Brave", "Silly", "Happy", "Quiet", "Witty"};
    private static final String[] animals = {"Fox", "Lion", "Panda", "Eagle", "Wolf"};

    private final Random random = new Random();

    public String generate() {
        String adjective = adjectives[random.nextInt(adjectives.length)];
        String animal = animals[random.nextInt(animals.length)];
        int number = random.nextInt(9000) + 1000; // e.g., 3456

        return adjective + animal + number; // e.g., "WittyFox1234"
    }
}
