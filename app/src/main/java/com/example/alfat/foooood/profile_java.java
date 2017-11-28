package com.example.alfat.foooood;

/**
 * Created by Alfat on 20-Jan-17.
 */
public class profile_java {
    private int number;
    private String resudent_name;
    private String phone_number;
    private String password;

    public profile_java() {
    }
    public profile_java(String resudent_name,String phone_number,String password) {
        this.resudent_name = resudent_name;
        this.phone_number=phone_number;
        this.password=password;
    }
    public profile_java(int number,String resudent_name,String phone_number,String password) {
        this.number =number;
        this.resudent_name = resudent_name;
        this.phone_number=phone_number;
        this.password=password;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String getresudent_name() {
        return resudent_name;
    }
    public void setresudent_name(String resudent_name) {
        this.resudent_name = resudent_name;
    }
    public String getphone_number()
    {
        return phone_number;
    }
    public void setphone_number(String phone_number)
    {
        this.phone_number=phone_number;
    }
    public String getpassword()
    {
        return password;
    }
    public void setpassword(String password)
    {
        this.password=password;
    }
    @Override
    public String toString() {
        return "resduent["+"Number=" + number + ",resduent_resudent_name="
                + resudent_name+ "phone_number="+phone_number+"password"+password+"]";
    }
}
