package com.railwayticketbooking;

public class Passenger {
    int id=1;
    private  int passengerId;
    private String name;
    private int age;
    private String gender;
    private String berthPreference;
    private int number;
    private String alloted="";

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId() {
        this.passengerId = id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public void setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAlloted() {
        return alloted;
    }

    public void setAlloted(String alloted) {
        this.alloted = alloted;
    }
    public String toString(){
        return "Passenger ID " + passengerId+"\n"+"Name "+name+"\n"+"Age "+age+"\n"+"Gender "+gender+"\n"+"Status "+alloted;
    }
}
