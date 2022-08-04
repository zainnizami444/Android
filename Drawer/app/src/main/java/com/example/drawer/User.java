package com.example.drawer;

public class User {

    public  String uid ;
    public  String fname ;
    public  String lname ;
    public  String contact ;
    public  String email ;

    public User() {

    }

    public User(String Uid, String Fname, String Lname, String contact, String Email) {
        this.uid = Uid;
        this.fname = Fname;
        this.lname = Lname;
        this.contact = contact;
        this.email = Email;
    }

    public String getUid() {
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

    public String getEmail() {
        return email;
    }
}
