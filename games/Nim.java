package games;

import players.*;
import java.util.*;

public class Nim extends AbstractGame{
  protected int startSize;
  protected int maxNum;
  protected int liveNum;
  protected Player liveplayer;
  protected Scanner scanner = new Scanner(System.in);


  public Nim(int startSize, int maxNum, Player player1, Player player2){
    super(player1, player2);
    this.startSize = startSize;
    this.maxNum = maxNum;
    this.liveNum = startSize;
    this.liveplayer = player1;
  }

  public String toString(){
    String res=  "taille initiale du tas: "+this.startSize+ "\nnombre maximal d'allumettes: "+this.maxNum+ "\njoueur 1: "+this.player1+ "\njoueur 2: "+this.player2;
    res +=  "\nnombre courant d'allumettes: "+this.liveNum+ "\nle joueur courant: "+this.liveplayer;
    return res+"\n";

  }

  public  int getInitailNbMatches(){
    return this.startSize;
  }

  public  int getCurrentNbMatches(){
    return this.liveNum;
  }


  public String situationToString(){
    return "il reste "+this.liveNum+" allumettes";
  }

  public void doExecute(int n){
    if(n <= this.maxNum){
      this.liveNum = this.liveNum - n;
    }
  }

  public Boolean isValid(int n){
    return (n <= this.maxNum && n <= this.liveNum);
  }
  
  public ArrayList<Integer> validMoves(){
    ArrayList<Integer> list2 = new ArrayList<Integer>();
    for(int num = 1; num <= this.maxNum;num++ ){
      if(this.isValid(num)){
        list2.add(num);
      }

    }
    return list2;
  }

  @Override
  public Boolean isOver(){
    return(this.liveNum == 0);
  }


  @Override
  public Player getWinner(){ 
    if(this.isOver() && super.liveplayer == this.player1){
      return this.player1;
    }
    else if(this.isOver() && super.liveplayer == this.player2){
      return this.player2;
    }
    else{
      return null;
    }

 
  }


public int saisirCoup(){
  System.out.println("saisir un coup:");
  int coup = Integer.parseInt(scanner.next());
  while(!this.isValid(coup)){
    System.out.println("le coup est invalide, saisir un autre coup:");
    coup = Integer.parseInt(scanner.next());
  }
  return coup;
}

  public void jouer(){
    System.out.println(this);
    while(!this.isOver()){
      int num = saisirCoup();
      this.execute(num);
      System.out.println(this.getCurrentPlayer()+"\n");
    }
    System.out.println(this.getWinner());
    System.out.println(this.situationToString());
  }


  public String moveToString(int n){
    return null;
  }

  public Game copy(){
    Nim res;
    res = new Nim(this.startSize, this.maxNum, super.player1, super.player2);
    res.player1 = super.player1;
    res.player2 = super.player2;
    res.startSize = this.startSize;
    res.maxNum = this.maxNum;
    res.liveNum = this.liveNum;
    res.liveplayer = this.liveplayer;

    return res;

  }


}
