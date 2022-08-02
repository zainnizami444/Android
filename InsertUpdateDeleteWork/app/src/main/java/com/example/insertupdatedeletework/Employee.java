package com.example.insertupdatedeletework;

public class Employee {

    public String id;
    public String fname;
    public String lname;
    public String contact;
    public String pass;
    public Employee()
    {

    }
    public Employee(String id ,String fname, String lname, String contact, String pass) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.contact = contact;
        this.pass = pass;

    }

    public String getId() {
        return id;
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
