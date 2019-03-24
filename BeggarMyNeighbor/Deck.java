import java.util.Scanner;
import java.io.*;

public class Deck {

  private Card[] cards;
  private int size;

  public Deck() {
    cards = new Card[52];
    File infile;
    size = 0;
    Scanner input;


    try {
      infile = new File("cards2");
      input = new Scanner(infile);
    } catch(FileNotFoundException e) {
      System.out.println("cards File not found!");
      return;
      }


    String s;
    char rankchar, suitchar;
    int rank, suit;
    int i;
    String ranks, suits;

    ranks = "--23456789TJQKA";
    suits = "shdc";

    // read from file and assign cards.
    for(i = 51; i>=0; i--){
      size++;
      s = input.nextLine();
      rankchar = s.charAt(0);
      suitchar = s.charAt(1);
      rank = ranks.indexOf(rankchar);
      suit = suits.indexOf(suitchar);
      cards[i] = new Card(rank, suit);
    }

/**    for(int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
      for(int rank = Card.TWO; rank <= Card.ACE; rank++) {
        cards[size] = new Card(rank, suit);
        size += 1;
      }
    }*/
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public Card deal() {
    size--;
    return cards[51 - size];
  }
/**
  public void shuffle() {
    for(int i = size-1 ; i > 0 ; i--){
      swap(i, (int)(Math.random()*(i+1)));
    }
  }
*/

}
