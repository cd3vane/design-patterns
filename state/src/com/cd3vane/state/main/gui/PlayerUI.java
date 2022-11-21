package com.cd3vane.state.main.gui;

import com.cd3vane.state.main.application.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerUI {
    private final Player player;
    private static final JTextField textField = new JTextField();

    public PlayerUI(Player player) {
        this.player = player;
    }

    public void init() {
        JFrame frame = new JFrame("My player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        context.add(textField);
        context.add(buttons);


        JButton play = new JButton("Play");
        JButton stop = new JButton("Stop");
        JButton prev = new JButton("Prev");
        JButton next = new JButton("Next");


        play.addActionListener(e -> textField.setText(player.getState().onPlay()));
        stop.addActionListener(e -> textField.setText(player.getState().onLock()));
        prev.addActionListener(e -> textField.setText(player.getState().onPrevious()));
        next.addActionListener(e -> textField.setText(player.getState().onNext()));

        buttons.add(play);
        buttons.add(stop);
        buttons.add(prev);
        buttons.add(next);

        frame.setVisible(true);
        frame.setSize(300, 100);

    }
}
