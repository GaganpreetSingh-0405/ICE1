/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Sivagama
 * @modifier Gaganpreet Singh
 * @student_number 991629835
 */
import java.util.Scanner;
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Card luckyCard = new Card();
        luckyCard.setValue(9);
        luckyCard.setSuit(Card.SUITS[2]);
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            int val = (int)Math.floor((Math.random()*13) + 1);
            c.setValue(val);                                      //c.setValue(insert call to random number generator here)
            int s =(int)Math.floor((Math.random()*3) + 1);
            c.setSuit(Card.SUITS[s]);                             //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            magicHand[i]=c;
        }
        System.out.println("magicHand array has been created.");
        for(int i=0;i<magicHand.length;i++)
        {
         System.out.println(magicHand[i].getSuit() + " " +magicHand[i].getValue());
        }
        System.out.println("Please choose your card now.");
        
        //insert code to ask the user for Card value and suit, create their card
        Scanner in = new Scanner(System.in);
        Card user_card = new Card();
        System.out.println("Please enter a card value(1-13) to search in the arrray:");
        int uvalue= in.nextInt();
        user_card.setValue(uvalue);
        System.out.println("Please enter a suit you want to search for :");
        System.out.println("1 for Hearts ,2 for Diamonds , 3 for Spades , 4 for Clubs");
        int usuit = in.nextInt();
        user_card.setSuit(Card.SUITS[usuit-1]);
        
        
        // and search magicHand here
        boolean match=false;
        for(int i = 0;i < magicHand.length; i++)
        {
            match = (magicHand[i].getSuit().equals(user_card.getSuit())) && (magicHand[i].getValue() == user_card.getValue());
           if(match == true)
               break;
        }
        
        //Then report the result here
        if(match){
            System.out.println("Your choosen card is in the magicHand array. Congratulations!");
        }
        else
        {
            System.out.println("Your choosen card is not in the array.Try again next time!");
        }
    }
}
