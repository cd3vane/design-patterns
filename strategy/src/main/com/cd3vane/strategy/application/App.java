package main.com.cd3vane.strategy.application;

public class App {
    public static void main(String[] args) {
        var encryptor = new Encryptor();
        encryptor.sendMessage("Hello world", new AES());

        encryptor.sendMessage("Testing 123", new DES());
    }
}
