/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalopoly;

import java.util.Random;

/**
 *
 * @author toby8
 */
public class Player {
    private String name;
    private char icon;
    private int location;
    private int money;
    private int active=1;
    private boolean miss=false;
    
    public Player(char icon, String name){
        this.name=name;
        this.icon=icon;
        this.money=1000;
        this.location=0;   
    }
    public void setMiss(){
        this.miss=true;
    }
    public void resetMiss(){
        this.miss=false;
    }
    public boolean getMiss(){
        return this.miss;
    }
    public void decreaseMoney(int value){
        money=money-value;
        if(this.money<=0){
            active--;
        }
    }
    public int getActive(){
        return active;
    }
    public void increaseMoney(int value){
        money=money+value;
    }
    public void move(int value){
        for(int n=0;n<value;n++){
            if(this.location<26){
                this.location++;
            } else {
                this.location=0;
            }
        }
    }
    public int getLocation(){
        return location;
    }
    public void setName(String name, char icon){
        this.name=name;
        this.icon=icon;
    }
    public String getName(){
        return this.name;
    }
    public char getIcon(){
        return this.icon;
    }
    public void getCard(){
        int randomNum;
        Random random = new Random();
        randomNum=random.nextInt(20);
        
        switch (randomNum){
            case 0: 
                System.out.println("You won the lottery. You gain £500");
                increaseMoney(500);
                break;
            case 1:
                System.out.println("You won a baking competition. You gain £100");
                increaseMoney(100);
                break;
            case 2:
                System.out.println("You won a dog race. You gain £150");
                increaseMoney(150);
                break;
            case 3:
                System.out.println("You won a cat grooming competition. You gain £200");
                increaseMoney(200);
                break;
            case 4:
                System.out.println("You rescued a bird. You gain £250");
                increaseMoney(250);
                break;    
            case 5:
                System.out.println("It's your birthday. You gain £150");
                increaseMoney(150);
                break;
            case 6:
                System.out.println("You inhert some money. You gain £200");
                increaseMoney(200);
                break;    
            case 7:
                System.out.println("You bought a dog. You lose £200");
                decreaseMoney(200);
                break;    
            case 8:
                System.out.println("You bought a lizard. You lose £100");
                decreaseMoney(100);
                break; 
            case 9:
                System.out.println("You have to pay pet insurance. You lose £150");
                decreaseMoney(150);
                break; 
            case 10:
                System.out.println("You open up a farm. You lose £500");
                decreaseMoney(500);
                break;    
            case 11:
                System.out.println("You have to pay tax. You lose £150");
                decreaseMoney(150);
                break;
            case 12:
                System.out.println("Your bird flew away. You lose £200");
                decreaseMoney(200);
                break;    
            case 13:
                System.out.println("Someone stole your cat. You lose £250");
                decreaseMoney(250);
                break;
            case 14:
                System.out.println("Move forwards two spaces");
                move(2); 
                break; 
            case 15:
                System.out.println("Move forwards three spaces");
                move(3); 
                break;
            case 16:
                System.out.println("Move forwards four spaces");
                move(4); 
                break;
            case 17:
                System.out.println("Move forwards five spaces");
                move(5); 
                break;
            case 18:
                System.out.println("You are decalared the best owner. Double your money");
                this.money=this.money*2;
                break;
            case 19:
                System.out.println("You are decalared the worst owner. Halve your money");
                this.money=this.money/2;
                break;    
            default:
                getCard();
                }
        }
        public void print(){
            System.out.println("\nName: " +this.name +"\nIcon: "+ this.icon +"\nSpace: "+ this.location +"\nMoney: "+ this.money);
        }
    }
    
    

