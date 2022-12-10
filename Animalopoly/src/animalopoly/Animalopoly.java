/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalopoly;

/**
 *
 * @author toby8
 */

import java.util.Scanner;
public class Animalopoly {
    
    /**
     * @param args the command line arguments
     */
    private static int isActive;
    public static void main(String[] args) {
        Dice dice = new Dice();
        Scanner reader = new Scanner(System.in);
        
        Animals [] animals = new Animals[26];//creates an array of animals
        
        
        animals [1] = new Animals("tiger" ,1);
        animals [2] = new Animals("zebra" , 2);
        animals [3] = new Animals("cat" , 3);
        animals [4] = new Animals("dog" , 4);
        animals [5] = new Animals("elephant" , 5);
        animals [6] = new Animals("frog" , 6);
        animals [7] = new Animals("gator" , 7);
        animals [8] = new Animals("hyena" , 8);
        animals [9] = new Animals("jellyfish" ,9 );
        animals [10] = new Animals("kangaroo" , 10);
        animals [11] = new Animals("lion" ,11 );
        animals [12] = new Animals("mongoose" ,12 );
        animals [13] = new Animals("newt" ,1 );
        animals [14] = new Animals("octopus" ,14 );
        animals [15] = new Animals("parrot" , 15);
        animals [16] = new Animals("raccoon" , 16);
        animals [17] = new Animals("scorpion" , 17);
        animals [18] = new Animals("tiger" , 18);
        animals [19] = new Animals("platypus" ,19 );
        animals [20] = new Animals("sealion" , 20);
        animals [21] = new Animals("hippo" ,21 );
        animals [22] = new Animals("gazelle" , 22);
        animals [23] = new Animals("bear" , 23);
        animals [24] = new Animals("mouse" ,24 );
        animals [25] = new Animals("slug" , 25);

        Animals.printAnimal(5);
        
        Board board = new Board();
        
        System.out.println("How many players do you want:");
        isActive = Integer.parseInt(reader.nextLine());
        
        
        Player [] players = new Player[isActive];//creates an array of players
        
        for(int n=0;n<isActive;n++){//getting names and icons for each players
            System.out.println("Please enter a name:");
            String name = reader.next();
            System.out.println("Please enter a icon:");
            char icon = reader.next().charAt(0);
            players[n] = new Player(icon,name);   
        }
        board.printBoard();
        
        while(isActive>1){
            for(int i=0;i<isActive;i++){
                if(players[i].getMiss()==false){//check to see if they miss a turn
                players[i].print();
                dice.rollDice(players[i],board);
                board.setSpace(players[i].getIcon(), players[i].getLocation() , board, players[i]);//this sets the location and then prints the board
                board.findAnimal(animals[players[i].getLocation()], players[i]);//this checks if they want to buy the animal
                Thread.sleep(5000);
                if(players[i].getActive()==0){
                    System.out.println("You have gone bankrupt. You are out!");
                    isActive--;
                }
                }else{
                    players[i].resetMiss();
                }
            } 
        }
    }
    
    
}
