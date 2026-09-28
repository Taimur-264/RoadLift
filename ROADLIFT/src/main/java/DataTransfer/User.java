/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransfer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Taimur,Farzam,Irtiza,Hassan
 */
public abstract class User {

    protected String name;
    protected String contact;
    protected String userName;
    protected String passWord;
    protected String gender;
    protected String email;

    public User(String name, String contact, String userName, String passWord, String gender, String email) {
        this.name = name;
        this.contact = contact;
        this.userName = userName;
        this.passWord = passWord;
        this.gender = gender;
        this.email = email;
    }

    public User() {

    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public abstract User create() throws IOException;

    public boolean signUp(String fname) throws Exception {
        boolean flag = true;

        File myObj = new File(fname);
        try (Scanner myReader = new Scanner(myObj)) {

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                String arr[] = data.split(",");

                for (int i = 0; i < arr.length; i++) {

                    if (arr[i].equals(this.userName)) {
                        flag = false;
                    }
                }
            }
            myReader.close();
        } catch (Exception ex) {
            System.out.println("at SIGNUP():\n" + ex.getMessage());
        }
        return flag;

    }

    public boolean signIn(String fname) throws Exception {

        boolean isUserValid = false;
        File myObj = new File(fname);
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine() || !isUserValid) {

            String data = myReader.nextLine();
            String arr[] = data.split(",");

            if (arr[1].equals(this.userName) && arr[2].equals(this.passWord)) {
                isUserValid = true;

            }
        }
        myReader.close();
        return isUserValid;
    }
}
