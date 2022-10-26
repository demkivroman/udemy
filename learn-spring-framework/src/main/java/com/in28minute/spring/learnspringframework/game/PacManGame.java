package com.in28minute.spring.learnspringframework.game;

import org.springframework.stereotype.Component;

public class PacManGame implements GamingConsole {
    public void up() {
        System.out.println("PacManGame up");
    }

    public void down() {
        System.out.println("PacManGame down");
    }

    public void left() {
        System.out.println("PacManGame left");
    }

    public void right() {
        System.out.println("PacManGame right");
    }
}
