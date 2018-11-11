/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author daova
 */
// Java implementation for a client 
// Save file as Client.java 
import java.io.*;
import java.net.*;

// Client class 
public class Client {

    public static void main(String[] args) throws IOException {
        try {

            InetAddress ip = InetAddress.getByName("192.168.43.237");

            // establish the connection with server port 5056 
            Socket s = new Socket(ip, 5056);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream os = new DataOutputStream(s.getOutputStream());

            while (true) {

                appendFile();
                sendLog(s);
                clearFile();
                Thread.sleep(100000);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void appendFile() throws FileNotFoundException, IOException {
        File dir = new File("C:\\Users\\daova\\Desktop\\Log\\LogText");
        String[] paths = dir.list();
        for (String path : paths) {
            String input = "C:\\Users\\daova\\Desktop\\Log\\LogText\\" + path;
            FileInputStream fis = new FileInputStream(new File(input));
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line != null && !line.isEmpty()) {
                    FileWriter fw = new FileWriter(new File("C:\\Users\\daova\\Desktop\\Log\\LogText\\AppendFile.txt"), true);
                    try (BufferedWriter bw = new BufferedWriter(fw)) {

                        bw.write(line);
                        bw.newLine();
                        line = "";
                    }

                }
            }
        }
    }

    public static void clearFile() throws FileNotFoundException {
        File dir = new File("C:\\Users\\daova\\Desktop\\Log\\LogText");
        String[] paths = dir.list();
        for (String path : paths) {
            String input = "C:\\Users\\daova\\Desktop\\Log\\LogText\\" + path;
            PrintWriter writer = new PrintWriter(new File(input));
            writer.print("");
            writer.close();

        }
    }

    public static void sendLog(Socket s) throws FileNotFoundException, IOException {
        File file = new File("C:\\Users\\daova\\Desktop\\Log\\LogText\\AppendFile.txt");
        // Get the size of the file
        long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = s.getOutputStream();
        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
    }
}
