/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Taimur,Farzam,Irtiza,Hassan
 */
public class Book {

    public int quantity;
    String route;
    public int totalBill;

    public void CreateBooking(String username, String route, int fare, int quantity) throws Exception {

        File file = new File("Bookings.csv");
        totalBill = fare * quantity;

        FileWriter fw = new FileWriter("Bookings.csv", true);

        fw.append(username);
        fw.append(",");
        fw.append(route);
        fw.append(",");
        fw.append(String.valueOf(fare));
        fw.append(",");
        fw.append(String.valueOf(quantity));
        fw.append(",");
        fw.append(String.valueOf(totalBill));
        fw.append("\n");

        fw.close();
    }
}
