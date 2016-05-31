/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KSnakes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kris
 */
public class Input {
    public static void main(String[] args) throws IOException{
    
    }
    
    public ArrayList <String> Readfile (String filepath) throws IOException{
        String line = null;
        ArrayList <String> inputlist = new ArrayList <>();
        
        try{
            //FileReader - read the location you assigned to the "filepath"
            FileReader fr = new FileReader(filepath);
            //BufferedReader - buffers the file reader
            BufferedReader br = new BufferedReader (fr);
            
            //if the line has a value, it will keep on entering the while-loop
            while((line = br.readLine()) != null){
               //linetoString = Integer.parseInt(line);            
               inputlist.add(line);            
        }
            br.close();
            return inputlist;
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found!");
        } catch (IOException ioex ){
            System.out.println("Error Reading File");
        }
        
        return null;
    }
    
    public ArrayList <String> Writefile(String filepath) throws IOException{
        String line = null;
        ArrayList <String> inputlist = new ArrayList <>();
        String score = "0";
        
            FileReader fr = new FileReader(filepath);
            //BufferedReader - buffers the file reader
            BufferedReader br = new BufferedReader (fr);
        FileWriter fw = new FileWriter(filepath);
        BufferedWriter bw = new BufferedWriter (fw);
        
            while((line = br.readLine()) != null){
                if(line.contains(score)){
                    line.replace(score, line);
                }
                bw.write(line);
            }
            
        return null;
    }
    
}
