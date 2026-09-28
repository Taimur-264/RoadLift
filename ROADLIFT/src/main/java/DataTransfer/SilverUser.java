/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransfer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Taimur,Farzam,Irtiza,Hassan
 */
public class SilverUser extends User {

   public SilverUser(String name, String contact, String userName, String passWord, String gender, String email) {
        this.name = name;
        this.contact = contact;
        this.userName = userName;
        super.passWord = passWord;
        this.gender = gender;
        this.email=email;
    }

    public SilverUser(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    
    @Override
     public SilverUser create() throws IOException {
        FileWriter fileWriter;
        File file;

        file = new File("SilverUsers.csv");

        if (file.createNewFile()) {
            fileWriter = new FileWriter("SilverUsers.csv");

            fileWriter.write("NAME");
            fileWriter.write(',');
            fileWriter.write("USER_NAME");
            fileWriter.write(',');
            fileWriter.write("PASSWORD");
            fileWriter.write('\n');

            fileWriter.write(this.name);
            fileWriter.write(',');
            fileWriter.write(this.userName);
            fileWriter.write(',');
            fileWriter.write(this.passWord);

            fileWriter.flush();
            fileWriter.close();

        } else {
            fileWriter = new FileWriter("SilverUsers.csv", true);

            fileWriter.append(this.name);
            fileWriter.append(',');
            fileWriter.append(this.userName);
            fileWriter.append(',');
            fileWriter.append(this.passWord);
            fileWriter.append('\n');

            fileWriter.flush();
            fileWriter.close();
        }

        return this;
    }
}
