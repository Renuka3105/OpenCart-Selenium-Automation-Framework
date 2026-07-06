package com.opencart.utilities;

import java.util.Random;

public class RandomDataGenerator {

    public static String generateRandomEmail() {

        Random random = new Random();

        int number = random.nextInt(100000);

        return "testuser" + number + "@gmail.com";

    }

}