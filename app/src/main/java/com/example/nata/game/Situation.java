package com.example.nata.game;

/**
 * Created by Nata on 22.01.2018.
 */

public class Situation {
    String text;
    String tb;
    Situation[] direction;

    public Situation(String text, String tb, int variants){
        this.text=text;
        this.tb=tb;

        direction=new Situation[variants];
    }

}
