package games;

import players.*;
import plays.*;
import java.util.*;


public class Main{
  public static void main(String []args){

    Scanner scanner1 = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    Random alea1 = new Random();

    Human human1 = new Human("Samuel", scanner1);
    Human human2 = new Human("Thiam", scanner2);
    RandomPlayer randy = new RandomPlayer(alea1);
    NegamaxPlayer nega = new NegamaxPlayer();



    TicTacToe game1 = new TicTacToe(human1, nega);
    Nim game2 = new Nim(20,5,human1,randy);
    
    Orchestrator type1 = new Orchestrator(game1);
    Orchestrator type2 = new Orchestrator(game2);

    type1.play();

  }
}
