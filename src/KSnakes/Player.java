/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KSnakes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kris
 */
public class Player implements PlayerActions{
    private String name;
    private int score;
       
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void play() {   
        System.out.println("Playing. . . ");
    }

    @Override
    public void pause() {
    }

    @Override
    public void save() {
    }

    @Override
    public void exit() {
    }
    
    
}
