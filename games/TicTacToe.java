package games;

import players.*;
import java.util.*;

public class TicTacToe extends AbstractGame{
  protected int player1moves;
  protected int player2moves;
  protected Player tab[][];
  protected Player liveplayer;

  public TicTacToe(Player player1, Player player2){
    super(player1,player2);
    this.liveplayer = super.liveplayer;
    tab = new Player[3][3];

  }

  public String toString(){
    String res = "";
    for(int lig = 0; lig < 3; lig++){
      for(int col = 0; col < 3; col++){
        res+=" "+tab[lig][col];

      }
        res = res + "\n";
    }
    return res;
  }

  public void doExecute(int n){
    int ligne = n/3;
    int col = n-(ligne*3);
    tab[ligne][col] = super.liveplayer;
  }

  public Boolean isValid(int n){
    int ligne = n/3;
    int col = n-(ligne*3);
    return (tab[ligne][col] == null);

  }

  public Integer returnCoup(int lig, int col){
    if(lig == 0 && col == 0){
      return 0;
    }
    else if(lig == 0 && col == 1){
      return 1;
    }
    else if(lig == 0 && col == 2){
      return 2;
    }
    else if(lig == 1 && col == 0){
      return 3;
    }
    else if(lig == 1 && col == 1){
      return 4;
    }
    else if(lig == 1 && col == 2){
      return 5;
    }
    else if(lig == 2 && col == 0){
      return 6;
    }
    else if(lig == 2 && col == 1){
      return 7;
    }
    else if(lig == 2 && col == 2){
      return 8;
    }else{
      return null;
    }
  }


  public ArrayList<Integer> validMoves(){
    ArrayList<Integer> list1 = new ArrayList<Integer>();

    for(int lig = 0 ;lig < 3;lig++){
      for(int col = 0;col < 3;col++){
        if(this.isValid(this.returnCoup(lig,col))){
          list1.add(this.returnCoup(lig,col));
        }
      }
    }
    return list1;
  }

  public Boolean wins(Player player, int row, int column, int deltaRow, int deltaColumn){
    return (this.tab[row][column] == player) && (this.tab[row+deltaRow][column+deltaColumn] == player) && (this.tab[row+(2*deltaRow)][column+(2*deltaColumn)] == player);
  }

  public Player getWinner(){
    Player winner;

    // diagonal

    if(this.wins(this.player1,0,0,1,1)){
      winner = this.player1;
    }
    else if(this.wins(this.player2,0,0,1,1)){
      winner = this.player2;
    }
    else if(this.wins(this.player1,0,2,1,-1)){
      winner = this.player1;
    }
    else if(this.wins(this.player2,0,2,1,-1)){
      winner = this.player2;
    }

    // row

    else if(this.wins(this.player1,0,0,1,0)){
      winner = this.player1;
    }
    else if(this.wins(this.player2,0,0,1,0)){
      winner = this.player2;
    }
    else if(this.wins(this.player1,0,1,1,0)){
      winner = this.player1;
    }
    else if(this.wins(this.player2,0,1,1,0)){
      winner = this.player2;
    }
    else if(this.wins(this.player1,0,2,1,0)){
      winner = this.player1;
    }
    else if(this.wins(this.player2,0,2,1,0)){
      winner = this.player2;
    }

    // column

    else if(this.wins(this.player1,0,0,0,1)){
      winner = this.player1;
    }
    else if(this.wins(this.player2,0,0,0,1)){
      winner = this.player2;
    }
    else if(this.wins(this.player1,1,0,0,1)){
      winner = this.player1;
    }
    else if(this.wins(this.player2,1,0,0,1)){
      winner = this.player2;
    }
    else if(this.wins(this.player1,2,0,0,1)){
      winner = this.player1;
    }
    else if(this.wins(this.player2,2,0,0,1)){
      winner = this.player2;
    }

    // unfinished game

    else{
      winner = null;
    }


  return winner;

  }

  public Boolean isOver(){
    return this.getWinner() != null || (this.getWinner() == null && this.validMoves().isEmpty());
  }

    public String moveToString(int n){
    if(n == 0 ){
      return "(0,0)";
    }
    else if(n == 1){
      return "(0,1)";
    }
    else if(n == 2){
      return "(0,2)";
    }
    else if(n == 3){
      return "(1,0)";
    }
    else if(n == 4){
      return "(1,1)";
    }
    else if(n == 5){
      return "(1,2)";
    }
    else if(n == 6){
      return "(2,0)";
    }
    else if(n == 7 ){
      return "(2,1)";
    }
    else if(n == 8){
      return "(2,2)";
    }
    else{
      return "c'est n'est pas un coup valide";
    }

  }

  public String situationToString(){
    String board = "";
    for(int lig = 0; lig < 3; lig++){
      for(int col = 0; col < 3; col++){
        if(this.tab[lig][col] == player1){
          board += " "+"X";
        }
        else if(this.tab[lig][col] == player2){
          board += " "+"O";
        }
        else{
          board += " "+".";
        }
        }
        board = board + "\n";
        }
    return board ;
  }

  public Game copy(){
    Player tab[][];
    TicTacToe res;
    res = new TicTacToe(super.player1, super.player2);
    res.player1 = super.player1;
    res.player2 = super.player2;
    res.liveplayer = this.liveplayer;
    res.tab = new Player[3][3];

    for(int lig = 0; lig < 3; lig++){
      for(int col = 0; col < 3; col++){
        res.tab[lig][col] = this.tab[lig][col];
      }
    }
    

    return res;
  }
   

   
}
