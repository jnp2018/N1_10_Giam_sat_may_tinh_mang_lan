/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author daova
 */
public class ReadFile {
    public static void main(String[] args) {
    }
    public static ArrayList readFile(){
        ArrayList list = new ArrayList();
        
        BufferedReader br = null;
        try {   
            br = new BufferedReader(new FileReader("C:\\Users\\daova\\Desktop\\Log\\AppBlock\\ListAppBock.txt"));       
            String textInALine;

            while ((textInALine = br.readLine()) != null){
                System.out.println(textInALine);
                list.add(textInALine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
