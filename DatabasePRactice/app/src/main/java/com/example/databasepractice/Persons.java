package com.example.databasepractice;

public class Persons {
    public  String id ;
    public String  fname;
    public String lname;
    public String contact;

    public Persons()
    {}



    public Persons(String id , String  fname, String  lname, String  contact)
    {        this.id = id;
        this.fname =fname;
        this.lname = lname;
        this.contact = contact;

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
}
