package plays;

import games.*;
import players.*;


public class Orchestrator{
    Game game2;

   
    public Orchestrator(Game game2){
        this.game2 = game2;

    }

    public String toString(){
        return "Game";
    }

    public void play(){
        Player current;
        while(!this.game2.isOver()){
            System.out.println(this.game2.situationToString());
            current = this.game2.getCurrentPlayer();
            this.game2.execute(current.chooseMove(this.game2));
        }

        if(this.game2.isOver()){
            System.out.println(this.game2.getWinner()+" a gagné\n"+this.game2.situationToString());
        }
        else{
            
        }

        
        


    }
}