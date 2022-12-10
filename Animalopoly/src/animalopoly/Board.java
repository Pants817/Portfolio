/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalopoly;

/**
 *
 * @author james
 */
public class Board {

 

      String[] arr; 
      int player1_square;
      String temp;
      String player1;
      
    public Board(){
      
      arr = new String[27];
                
      // initialize the first elements of the array 
      arr[0] = "Start"; 
      arr[1] = "1";  
      arr[2] = "2"; 
      arr[3] = "3"; 
      arr[4] = "4"; 
      arr[5] = "5"; 
      arr[6] = "6";  
      arr[7] = "7"; 
      arr[8] = "8"; 
      arr[9] = "9";
      arr[10] = "10"; 
      arr[11] = "11";  
      arr[12] = "12"; 
      arr[13] = "Miss a turn"; 
      arr[14] = "14";
      arr[15] = "15"; 
      arr[16] = "16";  
      arr[17] = "17"; 
      arr[18] = "18"; 
      arr[19] = "19";
      arr[20] = "20"; 
      arr[21] = "21";  
      arr[22] = "22"; 
      arr[23] = "23"; 
      arr[24] = "24";
      arr[25] = "25";
      arr[26] = "26";   
      
      
    }     

 

    
    public void printBoard(){
        System.out.println(arr[0]+"\t\t"+arr[1]+"\t\t"+arr[2]+"\t\t"+arr[3]+"\t\t"+arr[4]+"\t\t"+arr[5]+"\t\t"+arr[6]+"\t\t"+arr[7]);
        System.out.println("\n"+arr[25]+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+arr[8]);
        System.out.println("\n"+arr[24]+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+arr[9]);
        System.out.println("\n"+arr[23]+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+arr[10]);
        System.out.println("\n"+arr[22]+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+arr[11]);
        System.out.println("\n"+arr[21]+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+arr[12]);
        System.out.println("\n"+arr[20]+"\t\t"+arr[19]+"\t\t"+arr[18]+"\t\t"+arr[17]+"\t\t"+arr[16]+"\t\t"+arr[15]+"\t\t"+arr[14]+"\t\t"+arr[13]);
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
    public void setSpace(char player1 , int square , Board board, Player player){
        player1_square = square;
        temp = arr[player1_square];
        arr[player1_square] = temp + player1;
        
        board.printBoard();
        
           
    }
    public void findAnimal(Animals animal, Player player){
        if (player1_square == 0){
            player.increaseMoney(500);
        
        }
        
        else if (player1_square == 13){
            System.out.println("You miss a go - unlucky");
            player.setMiss();
        }
        
        else{
          animal.setAnimal(player);
        } 
    }
}