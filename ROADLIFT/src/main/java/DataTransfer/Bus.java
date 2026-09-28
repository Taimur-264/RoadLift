/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransfer;

import java.io.FileWriter;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Taimur,Farzam,Irtiza,Hassan
 */
public class Bus {

    private String route;
    private int fare;
    private int totalCapacity;
    private int availCapacity;

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getAvailCapacity() {
        return availCapacity;
    }

    public void setAvailCapacity(int availCapacity) {
        this.availCapacity = availCapacity;
    }
//overloading

    public Bus getData() throws Exception {

        File myObj = new File("Bus.csv");
        Scanner myReader = new Scanner(myObj);
        String arr[] = null;
        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();
            arr = data.split(",");

            this.route = arr[0];
            this.fare = parseInt(arr[1]);
            this.totalCapacity = parseInt(arr[2]);
            this.availCapacity = parseInt(arr[3]);

        }
        myReader.close();
        return this;
    }

    public Bus getData(String route) throws Exception {

        boolean isRouteFound = false;
        File myObj = new File("Bus.csv");
        Scanner myReader = new Scanner(myObj);
        String arr[] = null;
        while (myReader.hasNextLine() || !isRouteFound) {

            String data = myReader.nextLine();
            arr = data.split(",");

            if (arr[0].equals(route)) {
                this.route = arr[0];
                this.fare = parseInt(arr[1]);
                this.totalCapacity = parseInt(arr[2]);
                this.availCapacity = parseInt(arr[3]);
                isRouteFound = true;

            }
        }
        myReader.close();
        return this;
    }

    public void updateData(String route, int availCapacity) throws IOException, Exception {

        boolean isFileUpdated = false;
        String arr[] = null;

        File myObj = new File("Bus.csv");
        Scanner myReader = new Scanner(myObj);

        File file = new File("Temp.csv");

        if (file.createNewFile()) {
            FileWriter Tmpfile = new FileWriter("Temp.csv");

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                arr = data.split(",");

                if (arr[0].equals(route)) {
                    int i = parseInt(arr[3]);
                    i -= availCapacity;

                    Tmpfile.write(arr[0]);
                    Tmpfile.write(',');
                    Tmpfile.write(arr[1]);
                    Tmpfile.write(',');
                    Tmpfile.write(arr[2]);
                    Tmpfile.write(',');
                    Tmpfile.write(String.valueOf(i));
                    Tmpfile.write('\n');
                } else {

                    Tmpfile.write(arr[0]);
                    Tmpfile.write(',');
                    Tmpfile.write(arr[1]);
                    Tmpfile.write(',');
                    Tmpfile.write(arr[2]);
                    Tmpfile.write(',');
                    Tmpfile.write(arr[3]);
                    Tmpfile.write('\n');
                }

            }
            Tmpfile.close();
            myReader.close();
            arr = null;
            if (myObj.delete()) {
                //System.out.println("BUS FILE DELETED");
            } else {
                System.out.println("BUS FILE NOT DELETED");
            }

            File myObj2 = new File("Bus.csv");

            if (myObj2.createNewFile()) {
                File file2 = new File("Temp.csv");
                Scanner myR = new Scanner(file2);
                FileWriter fw = new FileWriter("Bus.csv");

                while (myR.hasNextLine() || !isFileUpdated) {

                    String data2 = myR.nextLine();
                    arr = data2.split(",");

                    fw.write(arr[0]);
                    fw.write(',');
                    fw.write(arr[1]);
                    fw.write(',');
                    fw.write(arr[2]);
                    fw.write(',');
                    fw.write(arr[3]);
                    fw.write('\n');
                    if (!myR.hasNextLine()) {
                        isFileUpdated = true;
                    }
                }
                myR.close();
                fw.close();

                if (file2.delete()) {
                 //  System.out.println("Temp File Deleted ");
                } else {
                    System.out.println("TEMP FILE NOT deleted");
                }
            }

        }

    }
}
