package org.example;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        int x = random.nextInt(50);
        System.out.println(x);
    }
}
