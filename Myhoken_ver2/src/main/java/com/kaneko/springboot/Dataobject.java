package com.kaneko.springboot;

/**
 * @author Takuya Kaneko
 * *データを管理するクラス。getter setter
 *各Controllerで扱うデータを記述しておく。
 */
public class Dataobject {
    private  int id;
    private String name;


    public Dataobject(int id, String name) {
        this.id = id;
        this.name = name;

    }
    public int getId(){
        return id;

    }

    public void setId(int id){
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
