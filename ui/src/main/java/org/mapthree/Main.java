package org.mapthree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TaskUI cli = new TaskUI();
        try {
            cli.start();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}