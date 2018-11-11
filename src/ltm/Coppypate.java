/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltm;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Thanh D.Hoang
 */
class Coppypate extends Thread implements ClipboardOwner {

    private static final DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private static final DateFormat sdf2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

    private static final String COPIED_FILES_PATH = "C:\\Users\\daova\\Desktop\\Log\\Clipboard\\Files\\";
    private static final String COPIED_STRING_PATH = "C:\\Users\\daova\\Desktop\\Log\\LogText\\";

    Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
    boolean bEnough = false;

    public void run() {
        Transferable trans = sysClip.getContents(this);
        regainOwnership(trans);

        while (true) {
            if (isitEnough()) {
                break;
            }
        }
    }
    
    public static String newName(String s) {
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                s1 = s1 + s.charAt(i);
            }
        }
        return s1;
    }

    public void itisEnough() {
        bEnough = true;
    }

    public void itisNotEnough() {
        bEnough = false;
    }

    boolean isitEnough() {
        return bEnough;
    }

    public void lostOwnership(Clipboard c, Transferable t) {
        try {
            sleep(200);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        try {
            Transferable contents = c.getContents(this); //EXCEPTION
            regainOwnership(contents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void processContents(Transferable content) {
        if (isitEnough()) {
            return;
        }
        try {
            if (content == null) {
                return;
            } else {
                System.out.println("flavor changed");
            }
            if (content.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String newtxt = (String) sysClip.getData(DataFlavor.stringFlavor);
                System.out.println("String copied = " + newtxt);
                FileWriter fw = null;
                try {

                    fw = new FileWriter(new File(COPIED_STRING_PATH + "String.txt"), true);
                    try (BufferedWriter bw = new BufferedWriter(fw)) {
                        Date date = new Date();
                        bw.write("\n----------" + sdf.format(date) + "----------");
                        bw.newLine();
                        bw.write("\"" + newtxt + "\"");
                        bw.newLine();
                    }
                } catch (Exception ex) {

                } finally {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                    }
                }
            } else if (content.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                try {
                    BufferedImage image = (BufferedImage) sysClip.getData(DataFlavor.imageFlavor);
                    Date date = new Date();
                    File outfile = new File("C:\\Users\\daova\\Desktop\\Log\\Clipboard\\Web\\" + sdf2.format(date) + ".png");
                    ImageIO.write(image, "png",outfile );
                    System.out.println("Image copied = " + sdf2.format(date) + ".png");
                } catch (IOException iOException) {
                    System.out.println(iOException);
                }
                

            } else if (content.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {

                File[] files = new File[]{};
                try {
                    List list = (List) sysClip.getData(DataFlavor.javaFileListFlavor);
                    files = (File[]) list.toArray().clone();
                    System.out.println(files.toString());
                    getFiles(files);
                } catch (Exception e) {
                    e.getStackTrace();
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Processing: ");
    }

    void regainOwnership(Transferable t) {
        sysClip.setContents(t, this);
        processContents(t);
    }

    void getFiles(File[] files) throws IOException {
        FileWriter fw = null;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                File dest = new File(COPIED_FILES_PATH + files[i].getName());
                if (dest.exists()) {
                    dest.delete();
                }
                Files.copy(files[i].toPath(), dest.toPath());
                try {
                    fw = new FileWriter(new File("C:\\Users\\daova\\Desktop\\Log\\LogText\\" + "String.txt"), true);
                    try (BufferedWriter bw = new BufferedWriter(fw)) {
                        Date date = new Date();
                        bw.write("\n----------" + sdf.format(date) + "-- " + files[i].getPath());
                        bw.newLine();
                    }
                } catch (Exception e) {
                } finally {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                    }
                }
            } else if (files[i].isDirectory()) {
                File[] subFiles = files[i].listFiles().clone();
                getFiles(subFiles);
            }
        }
    }

    public Coppypate() {
       itisNotEnough();
        start();
    }

    public static void main(String[] args) {
        Coppypate b = new Coppypate();
        b.itisNotEnough();
        b.start();
    }
}
