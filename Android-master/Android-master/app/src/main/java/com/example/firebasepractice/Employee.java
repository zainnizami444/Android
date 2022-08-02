package com.example.firebasepractice;

public class Employee {

    public String uid;
    public String fname;
    public String lname;
    public String contact;
    public String pass;

    public Employee()
    {

    }
    public Employee(String uid ,String fname, String lname, String contact, String pass) {
       this.uid = uid;
        this.fname = fname;
        this.lname = lname;
        this.contact = contact;
       this.pass = pass;
    }

    public String getId() {
        return uid;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getContact() {
        return contact;
    }

    public String getPass() {
        return pass;
    }
}
