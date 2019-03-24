import java.lang.IndexOutOfBoundsException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IdiotsDelight {

  public static final Scanner INPUT = new Scanner(System.in);

  private Stack<Card>[] stacks;

  private Deck deck;

  private int score;// c
  private int numberOfSuit;// c
  private int numberOfPair;// c
  private int numberOfDeal = -1;// c
  private int numberOfMove;// c

  public static void main(String[] args) {
    System.out.println("Welcome to Idoit's Delight game!");
    IdiotsDelight game = new IdiotsDelight();
    game.play();
  }

@SuppressWarnings("unchecked")// c
public IdiotsDelight() {
  deck = new Deck();
  deck.shuffle();
  stacks = new Stack[4];//I can't make generic array because java doesn't support it!
  for(int i = 0 ; i < 4 ; i++) {
    stacks[i] = new ArrayStack<Card>();
  }
  try {
    deal();
  } catch (IllegalMoveException e) {
    e.printStackTrace();
    System.exit(1);
  }
}

public void deal() throws IllegalMoveException {
  if(deck.isEmpty()){
    throw new IllegalMoveException();
  }

  for(Stack<Card> s : stacks) {
    s.push(deck.deal());
  }
  numberOfDeal++;// c
}

public void play() {
  while(true) {
    try {
    System.out.println("\n" + this);
    boolean done = true;
    for(Stack<Card> s : stacks) {
      if(!(s.isEmpty())) {
        done = false;
        break;
      }
    }
    if(done && score == 52) {// c
      System.out.println("You win!");
      return;
    }
    System.out.print("Your command (pair, suit, move, deal or quit)?");//c
    String command = INPUT.nextLine();

      if(command.equals("pair")) {
        removePair();
      } else if (command.equals("suit")) {
        removeLowCard();
      } else if (command.equals("move")) {
        moveCard(); // c
      } else if (command.equals("deal")) {
        deal();
      } else if (command.equals("quit")) {// c
        return;// c
      } else {
        throw new InputMismatchException();//c
        //return;//c
      }
   
    } catch (IllegalMoveException e ){
      System.out.println("I'm sorry, that's not a legal move.");
    } catch (InputMismatchException e) {
      System.out.println("\nInput data is not correct\ntry again!!! ");
      //INPUT.nextLine();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Out of bounds");
    } catch (EmptyStructureException e) {
      System.out.println("Stack is empty");
    }
  }
}

public void moveCard() throws IllegalMoveException {// new method for moving card
  System.out.print("Location (1-4) of card which you want to move? ");
  int i = INPUT.nextInt();
  System.out.print("Location (1-4) of empty stack? ");
  int j = INPUT.nextInt();
  INPUT.nextLine();// why do I have to put this line?
  if(stacks[i-1].isEmpty() || !(stacks[j-1].isEmpty()))
    throw new EmptyStructureException();
  stacks[j-1].push(stacks[i-1].peek());
  stacks[i-1].pop();
  numberOfMove++;
}

public void removeLowCard() throws IllegalMoveException, InputMismatchException, ArrayIndexOutOfBoundsException, EmptyStructureException {
  System.out.print("Location (1-4) of low card? ");
  int i = INPUT.nextInt();//c
  System.out.print("Location (1-4) of high card? ");
  int j = INPUT.nextInt();//c
// throw exception when choose same card
  INPUT.nextLine();//c
  if(i == j) throw new IllegalMoveException();
// check for illegal movement of cards
  Card lowCard = stacks[i-1].peek();
  Card highCard = stacks[j-1].peek();
  if((lowCard.getSuit() != highCard.getSuit()) || (lowCard.getRank() > highCard.getRank())) {
    throw new IllegalMoveException();
  }
  stacks[i - 1].pop();
  score++;// c
  numberOfSuit++;// c
}

public void removePair() throws IllegalMoveException {
  System.out.print("Location (1-4) of first card? ");
  int i = INPUT.nextInt();
  System.out.print("Location (1-4) of second card? ");
  int j = INPUT.nextInt();
  INPUT.nextLine();

  Card card1 = stacks[i-1].peek();
  Card card2 = stacks[j-1].peek();
  if (!(card1.equals(card2))) {
    throw new IllegalMoveException();
  }
  stacks[i - 1].pop();
  stacks[j - 1].pop();
  score += 2;// c
  numberOfPair++;// c
}

public String toString() {
  String resultOfCommand = "Suit:  "+numberOfSuit+", Pair:  "+numberOfPair+", Deal:  "+numberOfDeal+", Move:  "+numberOfMove;// added
  String resultOfScore = "Score:  " + score;// added
  String resultStackSize = "Stack Size:   ";// added
  for(int i = 0 ; i < 4 ; i++)
  {
    if(stacks[i].getSize()>9) resultStackSize += stacks[i].getSize() + " ";
    else resultStackSize += stacks[i].getSize() + "  ";
  }

  String resultStackNumber = "Stack Number: ";// added
  resultStackNumber += "1  2  3  4";
  String resultTopOfStack = "Top of Stack: ";
  for (int i = 0;i < 4 ; i++) {
    if (stacks[i].isEmpty()) {
      resultTopOfStack += "-- ";
    } else {
      resultTopOfStack += stacks[i].peek() + " ";
    }
  }
  return resultOfScore + "\n" + resultStackSize +"\n" + resultTopOfStack + "\n" + resultStackNumber + "\n" + resultOfCommand +"\n"+ deck.size() + " cards left in the deck";
}

}
