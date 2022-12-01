package main.com.cd3vane.strategy.application;

public class Encryptor {
    public void sendMessage(String message, Algorithm algorithm){
        algorithm.encrypt(message);
    }
}
