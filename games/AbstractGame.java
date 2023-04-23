package games;

import players.*;
import java.util.*;


public abstract class AbstractGame implements Game{
    protected Player player1;
    protected Player player2;
    public Player liveplayer;


    public AbstractGame(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.liveplayer = player1;
    }

    public String toString(){
        return "Player1:"+this.player1+"\nPlayer2:"+this.player2;

    }

    protected abstract void doExecute(int n);

    public void execute (int n){
        if(this.liveplayer == this.player1){
            doExecute(n);
            this.liveplayer = this.player2;
            }
            else{
                doExecute(n);
                this.liveplayer = this.player1;
                
                }
        
    }

    public Player getCurrentPlayer(){
        return this.liveplayer;
    }

 

}