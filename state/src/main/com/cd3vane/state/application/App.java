package main.com.cd3vane.state.application;


import main.com.cd3vane.state.gui.PlayerUI;

public class App {
    public static void main(String[] args) {
        Player player = new Player();
        PlayerUI ui = new PlayerUI(player);
        ui.init();
    }
}

