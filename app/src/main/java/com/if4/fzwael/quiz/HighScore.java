package com.if4.fzwael.quiz;

/**
 * Created by Fzwael on 4/1/2016.
 */
public class HighScore {
    private int ID;
    private String name;
    private int hs;

    public HighScore(){
        ID =0 ;
        name = "wael";
        hs = 0;
    }

    public HighScore(int ID , String name , int hs){
        this.ID = ID;
        this.name = name;
        this.hs = hs;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHs() {
        return hs;
    }

    public void setHs(int hs) {
        this.hs = hs;
    }
}
