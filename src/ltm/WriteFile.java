/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daova
 */
public class WriteFile {
    public static void main(String[] args) {
        
    }
    public static void writeFile(String s) {

        FileWriter fw = null;
        try {

            fw = new FileWriter(new File("C:\\Users\\daova\\Desktop\\Log\\LogText\\RecordUSB.txt"), true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(s);
                bw.newLine();
                s = "";
            }
        } catch (IOException ex) {
            Logger.getLogger(AutoDetect.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(AutoDetect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
