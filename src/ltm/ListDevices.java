/*
 * Copyright (C) 2014 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */
package ltm;

import http.HttpURLCrawData;
import org.usb4java.Context;
import org.usb4java.Device;
import org.usb4java.DeviceDescriptor;
import org.usb4java.DeviceList;
import org.usb4java.LibUsb;
import org.usb4java.LibUsbException;

/**
 * Simply lists all available USB devices.
 *
 * @author Klaus Reimer <k@ailis.de>
 */
public class ListDevices {

    /**
     * Main method.
     *
     * @param args Command-line arguments (Ignored)
     */
    public static void excute() throws InterruptedException {
        while (true) {
            Context context = new Context();

            // Initialize the libusb context
            int result = LibUsb.init(context);
            if (result < 0) {
                throw new LibUsbException("Unable to initialize libusb", result);
            }

            // Read the USB device list
            DeviceList list = new DeviceList();
            result = LibUsb.getDeviceList(context, list);
            if (result < 0) {
                throw new LibUsbException("Unable to get device list", result);
            }
            try {
                // Iterate over all devices and list them
                for (Device device : list) {
                    int address = LibUsb.getDeviceAddress(device);
                    int busNumber = LibUsb.getBusNumber(device);
                    DeviceDescriptor descriptor = new DeviceDescriptor();
                    result = LibUsb.getDeviceDescriptor(device, descriptor);
                    if (result < 0) {
                        throw new LibUsbException(
                                "Unable to read device descriptor", result);
                    }
                System.out.format(
                    "Bus %03d, Device %03d: Vendor %04x, Product %04x, Manufacturer %04x, bcdUSB %04x%n",
                        
                    busNumber, address, descriptor.idVendor(),
                    descriptor.idProduct(),descriptor.iManufacturer(),descriptor.bcdUSB());

                    short vId = descriptor.idVendor();
                    short pId = descriptor.idProduct();
                    

                    String hexVId = Integer.toHexString(vId & 0xffff);
                    String hexPId = Integer.toHexString(pId & 0xffff);
                    System.out.println(add(hexVId));
                    System.out.println(add(hexPId));

                    HttpURLCrawData http = new HttpURLCrawData(add(hexVId), add(hexPId));
                    hexVId = "";
                    hexPId = "";
                    Thread.sleep(2000);

//                short s =5 ;
//                System.out.println(""+ descriptor.idVendor());
//                System.out.println(descriptor.toString());
                }
            } finally {
                // Ensure the allocated device list is freed
                LibUsb.freeDeviceList(list, true);
            }

            // Deinitialize the libusb context
            LibUsb.exit(context);
            Thread.sleep(180000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create the libusb context
        excute();

    }

    private static String add(String str) {
        switch (str.length()) {
            case 4:
                str = "0x" + str;
                break;
            case 3:
                str = "0x0" + str;
                break;
            case 2:
                str = "0x00" + str;
                break;
            default:
                str = "0x000" + str;
                break;
        }
        return str;

    }
}
