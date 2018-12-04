package com.chua.aloysius;

public class Inputs {
    String Fullname, Gender;
    int Age;

    public Inputs(String Fullname, int Age, String Gender){
        this.Fullname = Fullname;
        this.Age = Age;
        this.Gender = Gender;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }


    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }


    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
