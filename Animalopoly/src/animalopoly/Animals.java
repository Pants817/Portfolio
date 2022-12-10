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
public class Animals {
    private String type;
    private int level =0;
    private boolean owned = false;
    private String ownedBy;
    private int cost = 100;
    private int animal_number;
    public static String animalList[];
    
   
    
    public Animals(String type ,int index){
        animalList = new String[27];
        this.type = type;
        this.animal_number = index;
        animalList[index] = type;
       // System.out.println("Animal "+index+"is "+animalList[index]);
    }
    
    public void setAnimal(Player player){
        Scanner reader = new Scanner(System.in);
        if(this.owned==true){
            System.out.println("You landed on "+this.type+". You owe the owner "+this.cost);
            player.decreaseMoney(this.cost);
        } else {
            System.out.println("Would you like to buy the "+this.type+" for "+this.cost+"\n 1:yes 2:no");
            int buffer=Integer.parseInt(reader.nextLine());
            if(buffer==1){
                this.owned=true;
                player.decreaseMoney(this.cost);
                this.ownedBy=player.getName();
            }//the player buys the animal so it sets the owner to the name of the player
        }
    }
    
    public static void printAnimal(int chosen_square){
        System.out.println("Animal"+chosen_square+" is "+animalList[5]);
    }
    
}