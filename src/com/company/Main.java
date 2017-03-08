package com.company;

import com.helper.*;

public class Main {

    public static void main(String[] args) {
        Announcer announcer = new Announcer();
        announcer.welcome();
        Game theGame = new Game();
        while(theGame.inProgress){
            theGame.doRound();
        }
        announcer.finish();
    }
}
