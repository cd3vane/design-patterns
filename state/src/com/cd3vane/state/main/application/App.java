package com.cd3vane.state.main.application;


import com.cd3vane.state.main.gui.PlayerUI;

public class App {
    public static void main(String[] args) {
        Player player = new Player();
        PlayerUI ui = new PlayerUI(player);
        ui.init();
    }
}

