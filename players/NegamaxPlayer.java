package players;
import plays.*;
import games.*;

public class NegamaxPlayer implements Player{
    public NegamaxPlayer(){

    }

    public int evaluate(Game situation){
        int res;
        Player currentplayer = situation.getCurrentPlayer();
        Game nextSituation = situation.copy();
        nextSituation.execute(nextSituation.validMoves().get(0));
        if(nextSituation.getWinner() == currentplayer){
            return +1;
        }
        else if(nextSituation.getWinner() != currentplayer){
            return -1;
        }
        else if(nextSituation.getWinner() == null){
            return 0;
        }    
        else{
            res = -5;
            for(int i = 0;i < situation.validMoves().size(); i++){
                Game situationPrime = situation.copy(); 
                situationPrime.execute(situation.validMoves().get(i));
                int v = - evaluate(situationPrime);
                if( res == -5 || v>res){
                    res = v;
                }          
            }            
            return res;
        }  
    }

    public int chooseMove(Game game1){
        int bestValue = -5;
        int bestMove = -1;
        for(int i = 0;i < game1.validMoves().size(); i++){
            Game situationPrime = game1.copy(); 
            situationPrime.execute(game1.validMoves().get(i));
            int v = - evaluate(situationPrime);
            if( bestValue == -5 || v>bestValue){
                bestValue = v;
                bestMove = i;
                }          
            }
            
            return bestMove;        
    }
    
}