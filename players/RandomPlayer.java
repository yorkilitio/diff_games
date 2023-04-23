package players;
import java.util.*;
import players.*;
import games.*;

public class RandomPlayer implements Player{
    Random random1;

    public RandomPlayer(Random random1){
        this.random1 = random1;
    }

    public String toString(){
        return  "Joueur aléatoire n° " + this.hashCode();
    }

    
    public int chooseMove(Game game1){
        int alea = this.random1.nextInt(game1.validMoves().size());
        return game1.validMoves().get(alea);
    }



}