package com.example.myapplication;

public class ak1 {
    String Employeeid, name,phoneno,doj;

    public ak1(String name) {
        this.name = name;
    }
    public ak1(String Employeeid,String name,String phoneno,String doj) {
        this.Employeeid = Employeeid;
        this.name = name;
        this.phoneno=phoneno;
        this.doj=doj;



    }



    public String getEmployeeid() {
        return Employeeid;
    }

    public void setEmployeeid(String employeeid) {
        Employeeid = employeeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }
}
