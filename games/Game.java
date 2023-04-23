package games;

import players.*;
import java.util.*;

public interface Game{

    public void execute (int n);
    public Player getCurrentPlayer();
    public Boolean isValid(int n);
    public ArrayList<Integer> validMoves();
    public Player getWinner();
    public Boolean isOver();
    public String situationToString();
    public String moveToString(int n);
    public Game copy();

}