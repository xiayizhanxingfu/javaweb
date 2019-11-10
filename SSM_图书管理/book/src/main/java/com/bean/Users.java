package com.bean;

public class Users {

    private long id;
    private String pwd;

    public Users() {

    }

    public Users(int id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
