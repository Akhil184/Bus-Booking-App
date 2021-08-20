package com.example.myapplication;

public class ak {
    String Email, name, Adhara, phonon, Address, Dob,Gender;

    public ak(String name) {
        this.name = name;
    }
    public ak(String Email, String name, String Adhara, String phonon, String Address, String Dob,String Gender) {
        this.Email = Email;
        this.name = name;
        this.Adhara = Adhara;
        this.phonon = phonon;
        this.Address = Address;
        this.Dob = Dob;
        this.Gender=Gender;


    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }



    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhonon() {
        return phonon;
    }

    public void setPhonon(String phonon) {
        this.phonon = phonon;
    }

    public String getName() {
        return name;
    }

    public String getAdhara() {
        return Adhara;
    }

    public void setAdhara(String adhara) {
        Adhara = adhara;
    }

    public void setName(String name) {
        this.name = name;
    }


}

