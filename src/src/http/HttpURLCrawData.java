/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import db.UsbInfo;
import db.UsbInfoDAO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class HttpURLCrawData {

    private final String USER_AGENT = "Mozilla/5.0";
    static String strRespond, nameType, strHandle;
    static String[] arrData;
    public String vId;
    public String pId;
    UsbInfoDAO usbDAO;

    public HttpURLCrawData(String vId, String pId) {
        this.vId = vId;
        this.pId = pId;
        try {
            addInfoUsbDB(this.vId, this.pId);
        } catch (Exception e) {
        }
        
    }

    
    public static void main(String[] args) throws Exception {
        
    }
    private String sendGetUsb(String vID, String pID) throws Exception {

        // 0x2109 0x3431
        String url = "https://www.the-sz.com/products/usbid/index.php?v=" + vID
                + "&p=" + pID + "&n=";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print resultSt
//	System.out.println(response.toString());
        return response.toString();

    }

    private String nameTypeUsbReuslt(String vID, String pID) {
        nameType = "";
        try {
            strRespond = sendGetUsb(vID, pID);
        } catch (Exception ex) {
            Logger.getLogger(HttpURLCrawData.class.getName()).log(Level.SEVERE, null, ex);
        }
        strRespond = strRespond.substring(0, strRespond.indexOf("Some company logos are loaded from"));
//                System.out.println(strRespond);
        strHandle = strRespond.substring(strRespond.lastIndexOf("<table class=\"usbid_result\">"),
                strRespond.lastIndexOf("</table>"));
//                System.out.println(strHandle);
        strHandle = strHandle.substring(strHandle.lastIndexOf("<tr>"), strHandle.length());
//        System.out.println(strHandle);
        arrData = strHandle.split("</td>");
        for (String i : arrData) {
//            System.out.println(i);
        }
        String temp = arrData[3];
        nameType = temp.substring(temp.indexOf("<td><div class=\"usbid_result_name\">"), temp.indexOf("</div>"));
        nameType = nameType.substring(nameType.lastIndexOf(">") + 1);
        System.out.println("Lamma" + nameType);
        if (nameType == null) {
            return "";
        }
        return nameType;
    }

    private boolean addInfoUsbDB(String vID, String pID) {
        usbDAO = new UsbInfoDAO();
        String nameType = nameTypeUsbReuslt(vID, pID);
        if (!usbDAO.checkDB(vID, pID) && nameType != "") {
            usbDAO.inSertUsbInfo(new UsbInfo(vID, pID, nameType));
            return true;
        } else {
            return false;
        }

    }

}
