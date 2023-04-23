package players;
import games.*;
import java.util.*;

public class Human implements Player{
    String name;
    Scanner scanner;


    public Human(String name,Scanner scanner){
        this.name = name;
        this.scanner = scanner;
    }

    public String toString(){
        return name;
    }

    public int chooseMove(Game game1){
        System.out.println(game1.validMoves());

        System.out.println("saisir un coup:");

        int coup = Integer.parseInt(scanner.next());

        while(!game1.isValid(coup)){
            System.out.println("le coup est invalide, saisir un autre coup:");
            coup = Integer.parseInt(scanner.next());
            }
            return coup;

    }


    

}