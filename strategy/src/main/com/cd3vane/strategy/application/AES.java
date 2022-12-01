package main.com.cd3vane.strategy.application;

public class AES implements Algorithm {
    @Override
    public void encrypt(String message) {
        System.out.println("Encypting " + message + " with AES");
    }
}
