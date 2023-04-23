package plays;

import java.util.*;
import players.*;


public class Main{
    public static void main(String []args){

        Random rand = new Random();
        RandomPlayer random1 = new RandomPlayer(rand);



        System.out.println(random1);
    }
}