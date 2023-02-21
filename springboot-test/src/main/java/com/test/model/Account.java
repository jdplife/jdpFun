package com.test.model;

/**
 * @ClassName Account
 * @Description TODO
 * @Author jdp
 * @Date 15:04 2022/5/5
 * @Version 1.0
 **/
public class Account {

    private int id;
    private String name;

    public Account(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
