/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KSnakes;

import java.util.ArrayDeque;
import KSnakes.Point;
import KSnakes.SnakeBody;
import KSnakes.Food;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author kris
 */
public class GameWindow extends javax.swing.JFrame {

    /**
     * Creates new form GameWindow
     */
    
    private int rows = 42;
    private int cols = 170;
    private int direction = 39;
    private String choice = "";
    private int c = 0;
    private int score = 0;
    private boolean grew = false; 
    private SnakeBody snake = new SnakeBody(0,0);
    private Double food = new Double(0,0);
    private Poison food2 = new Poison(0,0);
    private Faster food3 = new Faster(0,0);
    private Slower food4 = new Slower(0,0);    
    private ArrayDeque <Point> body = new ArrayDeque <Point>();
    private boolean play = true;

    public GameWindow() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        
        displaySnake();
    }

    public void displayBorder(){
        StringBuilder display = new StringBuilder();
        
        for(int i = 0; i <= getRows(); i++){
            for(int j = 0; j <= getCols(); j++){
                if(i > 1 && i < getRows()){
                    if(j > 1 && j <= getCols()){
                        display.append(" ");
                    } else display.append("*");
                } else display.append("*");
            } display.append("*");
            
        } jTextArea1.setText(display.toString());
    }
    
    public void displayMessage(boolean hit){
        StringBuilder display = new StringBuilder();        
            if(hit == true){
                display.append("You ate the FOOD!");
            }else display.append("WELCOME TO SNAKES!!" + "\t" + "MENU:" + "\t" + "[1] LOAD GAME" + "\t" + "[2] NEW GAME" + "\t" + "[3] EXIT" + "\t" + "Choice: ");

        jTextArea4.setText(display.toString());
    }
    
    public void displayScore(int score){
        StringBuilder display = new StringBuilder();        
            display.append("SCORE: " + score);
        jTextArea2.setText(display.toString());
    }
    
    public void displaySnake(){
        StringBuilder display = new StringBuilder();
        char s = 219;
        char f1 = 153;
        char f2 = 232;
        char f3 = 254;
        
        for(int i = 0; i < getRows(); i++){
            for(int j = 0; j < getCols(); j++){                
                if(containsBody(j,i)){
                    display.append(s);
                } else if(containsFood(j,i)){
                    display.append(f1);
                } else if(containsFood2(j,i)){
                    display.append(f2);
                } else if(containsFood3(j,i)){
                    display.append(f3);
                } else if(containsFood4(j,i)){
                    display.append("H");
                } /*else if(i == 1 && j == 75){
                    display.append(scoreLabel + score);                
                }*/ else{
                    display.append(" ");
                } 
            } display.append("\n");
        }

        jTextArea1.setText(display.toString());
    }
    
    public boolean containsBody(int x, int y){
        ArrayDeque <Point> body = snake.getBody();

        for(Point p : body){
            if(p.getX() == x && p.getY() == y){
                return true;
            }
        } return false;        
    }

    public boolean containsBorder(int x, int y){
        boolean star = false;
        
                if(x > 1 && x < getRows()){
                    if(y > 1 && y <= getCols()){
                        star = false;
                    } else star = true;
                } else star = true;
        
        return star;
    }
    
    
    public boolean containsFood(int x, int y){
        Point pp = food.getFood();
                
        //checks if food location is equal to x and y in game simulation [start()]
        if(pp.getX() == x && pp.getY() == y){
            return true;
        } 
    return false;        
    }
    
    public boolean containsFood2(int x, int y){
        Point pp = food2.getFood();
                
        //checks if food location is equal to x and y in game simulation [start()]
        if(pp.getX() == x && pp.getY() == y){
            return true;
        } 
    return false;        
    }

    public boolean containsFood3(int x, int y){
        Point pp = food3.getFood();
                
        //checks if food location is equal to x and y in game simulation [start()]
        if(pp.getX() == x && pp.getY() == y){
            return true;
        } 
    return false;        
    }

    public boolean containsFood4(int x, int y){
        Point pp = food4.getFood();
                
        //checks if food location is equal to x and y in game simulation [start()]
        if(pp.getX() == x && pp.getY() == y){
            return true;
        } 
    return false;        
    }

    public int move(int direction){
        switch(direction){
            case 80: direction = 80; break;
            case 37: snake.moveLeft();break;
            case 38: snake.moveUp();break;
            case 39: snake.moveRight();break;
            case 40: snake.moveDown();break;
        }
        return direction;
    }    

    public boolean onPause(){
        boolean pause = false;
        
        if(direction == 80){
            pause = true;
        }
    
        return pause;
    }
    
    public boolean hitBody(){
    boolean checker = false;
    boolean isHead = true;
    Point head = snake.getBody().getFirst();
    ArrayDeque <Point> body = snake.getBody();

    //print point of SnakeBody
    for(Point pp : body){
        System.out.println("PP: " + pp.getX() + ", " + pp.getY());
    }
    
    for(Point pp : body){                
        if(isHead == true){
            isHead = false;
        } else if(pp.getX() == head.getX() && pp.getY() == head.getY()){
            System.out.println("HIT BODY!");                
            System.out.println("HEAD NOW:" + head.getX() + "," + head.getY());
            checker = true;
        } 
    }    

    return checker;
    }
    
    public void start() throws IOException{
        Scanner sc = new Scanner(System.in);
        int i = 0; //iteration
        
        //choice = jTextArea5.getText();
        //c = Integer.parseInt(choice);
        
        /*START OF MENU */
        System.out.println("WELCOME TO SNAKES!");        
        System.out.println("------ MENU ------");
        System.out.println("1 | LOAD GAME");
        System.out.println("2 | NEW GAME");
        System.out.println("3 | EXIT");
        System.out.println("4 | HIGHSCORE");
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
            score = 0;
            
            //Player p = playerList.get(0);
            for(int j = 0; j < playerList.size(); j++){
                if(pName.equals(playerList.get(j).getName()) && playerList.get(j) instanceof Player){
                checkName = true;
                System.out.println(playerList.get(j).getName());
                Player p;
                p = (Player)playerList.get(j); //cast
                   System.out.println(p.getScore());                  
                   score = p.getScore();
                   //p.setScore(score);                
                } 
            }
            if(checkName == false){
            System.out.println("No User Found.");            
            } else{
            
                
                    System.out.println("Load this game? 0 - Yes | 1 - No");
                    int h = sc.nextInt();
                    if(h == 0){

            int n = 100; //default speed
            Point head;
            //food initialization
            food.randomizeFood();
            food2.randomizeFood();
            food3.randomizeFood();
            food4.randomizeFood();

            boolean pause = false;

            while(play){
                try {
                    Thread.sleep(n);
                    
                    pause = onPause();
                    
                    if(pause == false){
                        move(direction); //get user input (arrow keys)
                    } else System.out.println("YOU ARE PAUSED.");
                    
                    head = snake.getHead(snake.getBody());
                    System.out.println(head.getX() + "," + head.getY());
                    displaySnake();
                    displayScore(score);
                    System.out.println("dir: " + direction);

                    String display = "";
                    int load = 0;
                    
                    if((head.getX() == (food.getFood().getX()) && head.getY() == food.getFood().getY())){
                        System.out.println("YOU GREW DOUBLE!");                                            
                            snake.doubleAdd(snake.getBody(), direction);
                            food.randomizeFood();
                            display = "YOU GREW DOUBLE!";
                            score = score + (snake.getBody().size()-9);
                            //p.setScore(score);
                            
                    String filepath = "C:\\Users\\kris\\Desktop\\Kris.txt";

                    /*
                    Input input = new Input();
                    ArrayList <String> inputlist = input.Readfile(filepath);                    
                    load = Integer.parseInt(inputlist.get(0));
                    input.Writefile(filepath);
                    */
                    } else if(head.getX() == (food2.getFood().getX()) && head.getY() == food2.getFood().getY()){ //SNAKEBODY DECREASE BY 1
                        System.out.println("YOU SHRINKED!");
                            snake.shrink(snake.getBody());
                            food2.randomizeFood();       
                            display = "YOU SHRINKED!";
                            score = score - 1;
                    } else if(head.getX() == (food3.getFood().getX()) && head.getY() == food3.getFood().getY()){
                        System.out.println("FASTER!");                    
                            n = snake.faster(snake.getBody(), n);                        
                            food3.randomizeFood();                                 
                            display = "FASTER!";
                    } else if(head.getX() == (food4.getFood().getX()) && head.getY() == food4.getFood().getY()){ 
                        System.out.println("SLOWER!");                    
                            n = snake.slower(snake.getBody(), n);                        
                            food4.randomizeFood();                                                 
                            display = "SLOWER!";
                    }else if(hitBody() == true){
                        play = false;
                    } else {
                        display = "=====SNAKES SPEED===== " + n;
                    }
                    //score = score + (snake.getBody().size() - 9);
                    i++;
                    System.out.println("iteration: " + i); //an iteration is every one move of Snake
                    jTextArea4.setText(display.toString());

                } catch (InterruptedException ex) {
                    Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                }                    
            }//END WHILE
                    }
                    /*
                    } else {
                        System.out.println("Bye.");
                    }
                    */
            } //end for

            /*
            if(checkName == false){
            System.out.println("No User Found.");            
            }
            */
            break;
                
            case 2:
            int n = 100; //default speed
            Point head;
            //food initialization
            food.randomizeFood();
            food2.randomizeFood();
            food3.randomizeFood();
            food4.randomizeFood();

            boolean pause = false;

            while(play){
                try {
                    Thread.sleep(n);
                    
                    pause = onPause();
                    
                    if(pause == false){
                        move(direction); //get user input (arrow keys)
                    } else System.out.println("YOU ARE PAUSED.");
                    
                    head = snake.getHead(snake.getBody());
                    System.out.println(head.getX() + "," + head.getY());
                    displaySnake();
                    displayScore(score);
                    System.out.println("dir: " + direction);

                    String display = "";
                    
                    if((head.getX() == (food.getFood().getX()) && head.getY() == food.getFood().getY())){
                        System.out.println("YOU GREW DOUBLE!");                                            
                            snake.doubleAdd(snake.getBody(), direction);
                            food.randomizeFood();
                            display = "YOU GREW DOUBLE!";
                    } else if(head.getX() == (food2.getFood().getX()) && head.getY() == food2.getFood().getY()){ //SNAKEBODY DECREASE BY 1
                        System.out.println("YOU SHRINKED!");
                            snake.shrink(snake.getBody());
                            food2.randomizeFood();       
                            display = "YOU SHRINKED!";
                    } else if(head.getX() == (food3.getFood().getX()) && head.getY() == food3.getFood().getY()){
                        System.out.println("FASTER!");                    
                            n = snake.faster(snake.getBody(), n);                        
                            food3.randomizeFood();                                 
                            display = "FASTER!";
                    } else if(head.getX() == (food4.getFood().getX()) && head.getY() == food4.getFood().getY()){ 
                        System.out.println("SLOWER!");                    
                            n = snake.slower(snake.getBody(), n);                        
                            food4.randomizeFood();                                                 
                            display = "SLOWER!";
                    }else if(hitBody() == true){
                        play = false;
                    } else {
                        display = "=====SNAKES SPEED===== " + n;
                    }
                    score = snake.getBody().size();
                    i++;
                    System.out.println("iteration: " + i); //an iteration is every one move of Snake
                    jTextArea4.setText(display.toString());

                } catch (InterruptedException ex) {
                    Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                }                    
            }//END WHILE
        
                break;

            case 3: 
                jTextArea4.setText("Good bye.");
                System.out.println("Good bye.");
                break;
                
            case 4: 
                ArrayList <Integer> scoreList = new ArrayList <Integer> ();
                //add scores
                for(int l = 0; l < playerList.size(); l++){
                    scoreList.add(playerList.get(l).getScore());
                }
                
                int smallest = scoreList.get(0);
                int highest = 0;
            
                for(int u = 0; u < scoreList.size(); u++){
                    if(scoreList.get(u) < smallest){
                        smallest = scoreList.get(u);
                    } 
                    
                    if(scoreList.get(u) > highest){
                        highest = scoreList.get(u);
                    }                    
                }
                                
                int index  = scoreList.indexOf(highest);
                System.out.println("Player " + index + " [" + playerList.get(index).getName() + "]");
                System.out.println("HIGHEST: " + highest);
                                                
            break;
        } //END SWITCH        

    }
    
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
        
    public int setPlayerScore(int score ){
        this.score = score;
        return score;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button3 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button4 = new java.awt.Button();
        button6 = new java.awt.Button();

        button3.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("");
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(255, 255, 245));
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea2);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setToolTipText("");
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(153, 153, 255));
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setAutoscrolls(false);
        jScrollPane4.setViewportView(jTextArea4);

        button1.setBackground(new java.awt.Color(255, 0, 0));
        button1.setForeground(new java.awt.Color(204, 204, 204));
        button1.setLabel("Exit");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setActionCommand("New Game");
        button2.setLabel("New Game");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        button2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button2KeyPressed(evt);
            }
        });

        button4.setLabel("Load Game");

        button6.setActionCommand("Pause");
        button6.setLabel("Pause");
        button6.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        // TODO add your handling code here:

        if(this.direction == 38 && evt.getKeyCode() == 40){
            return;
        } else if(this.direction == 37 && evt.getKeyCode() == 39){
            return;
        } else if(this.direction == 40 && evt.getKeyCode() == 38){
            return;
        } else if(this.direction == 39 && evt.getKeyCode() == 37){
            return;
        } 
        
        this.direction = evt.getKeyCode();
        //System.out.println(direction);
        
        /*
        direction = evt.getKeyCode();
        System.out.println(direction);
        */
    }//GEN-LAST:event_jTextArea1KeyPressed

    
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        //choice = "2";
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button2KeyPressed
        // TODO add your handling code here:
        this.c = 2;
    }//GEN-LAST:event_button2KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameWindow().setVisible(true);
            }
        });        
        
        //JScrollPane2 sp2 = new JScrollPane2(new JTextArea)
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea4;
    // End of variables declaration//GEN-END:variables
}
