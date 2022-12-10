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
import java.util.Random;
public class Dice {
    
    private int value1;
    private int value2;
    
    public void rollDice(Player player, Board board) {
        Random random = new Random();
        value1=random.nextInt(6)+1;//getting dice rolls
        value2=random.nextInt(6)+1;    
        System.out.println("Dice one: " + value1+"\n Dice two: " + value2); 
        player.move(value1+value2);
        
        if(value1==value2){
            player.getCard();
        }
     
        
    }
}
