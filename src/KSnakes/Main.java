/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KSnakes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kris
 */
public class Main {
   
    public static GameWindow g;
    public static void main(String[] args){
        g = new GameWindow();

        //PlayerActions u = new Player();
        /*
        System.out.println("WELCOME TO SNAKES!");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("------ MENU ------");
        System.out.println("1 | LOAD GAME");
        System.out.println("2 | NEW GAME");
        System.out.println("3 | EXIT");
        System.out.print("Choice: ");
        int c = sc.nextInt();
        
        ArrayList <Player> playerList = new ArrayList <Player>();
        playerList.add(new Player("Sam", 15));
        playerList.add(new Player("Nike", 12));
        playerList.add(new Player("Ligaya", 20));
        
        switch(c){
            case 1: 
                //get Player name
                //get score of Player
                //set score
                //play
                System.out.print("Username: ");
                String pName = sc.next();

            boolean checkName = false;    
            for(int i = 0; i < playerList.size(); i++){
               if(pName.equals(playerList.get(i).getName()) && playerList.get(i) instanceof Player){
               checkName = true;
               System.out.println(playerList.get(i).getName());
               Player p = (Player)playerList.get(i); //cast
                   System.out.println(p.getScore());                   
                } 
            }
            
            if(checkName == false){
            System.out.println("No User Found.");            
            }
            
            break;
                
            case 2:
            try {
            g.start();                
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
                
                
        } //END SWITCH
        */
            try {
            g.start();                
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    } //END MAIN
    
}
