//NAME:SEOKHO HAN
//Username:SXH76090
//700No:700657609
//AssignmentNumber:a2
//FolderName:Beetle

import java.util.*;

public class BeetleGame{

public static final java.util.Scanner INPUT = new java.util.Scanner(System.in);

  private Beetle bug1;
  private Beetle bug2;
  private Beetle bug3;
  private Beetle bug4;
  private Die die;

  public BeetleGame(){
    bug1 = new Beetle();
    bug2 = new Beetle();
    bug3 = new Beetle();
    bug4 = new Beetle();
    die = new Die();
  }

  public void play(int noOfPlayers){
    int player = 1;
    Beetle bug = bug1;
    while(!(bug.isComplete())){
      if(!(takeTurn(player, bug))){
        if(noOfPlayers == 1){
          player = 1;
          bug = bug1;
        }
        if(noOfPlayers == 2){
          if(player == 1){
             player = 2;
             bug = bug2;
          }else{
             player=1;
             bug = bug1;
          }
        }
        if (noOfPlayers==3){
          if(player == 1){
            player = 2;
            bug = bug2;
          }else if(player == 2){
             player = 3;
             bug = bug3;
          }else{
             player = 1;
             bug = bug1;
          }
        }
        if (noOfPlayers==4){ 
          if(player == 1){
            player = 2;
            bug = bug2;
          }else if(player == 2){
             player = 3;
             bug = bug3;
          }else if(player == 3){
             player = 4;
             bug = bug4;
          }else{
             player = 1;
             bug = bug1;
          }
        }
}
  }
  System.out.println("\nPlayer " + player + " wins!");
  System.out.println(bug);
  }

//add regame puntion
  public static void main(String[] args){
    String playAgain;
    int noOfPlayers;
    boolean badData;
    do{
    System.out.println("Welcome to Beetle.");
    BeetleGame game = new BeetleGame();
    badData = true;
    do {
      try{
        System.out.print("enter No. of player(1-4)");
        noOfPlayers = INPUT.nextInt();
        INPUT.nextLine();
        if (noOfPlayers < 1 || noOfPlayers > 4) throw new WrongNumberOfPlayersException();
        game.play(noOfPlayers);
        badData = false;
      } catch(InputMismatchException e){
          System.out.println("Input was not an integert - try again ");
          INPUT.nextLine();
      } catch (WrongNumberOfPlayersException e){
          System.out.println("Wrong NumberOfPlayers!");
          INPUT.nextLine();
      }

    } while (badData);

    System.out.print("Do you want to play again? (y/n)");
    playAgain = INPUT.nextLine();
    }while (playAgain.equals("y"));
  }

  public boolean takeTurn(int player, Beetle bug){
    System.out.println("-------------------------------------");
    System.out.println("\nPlayer " + player + ", your beetle:");
    System.out.println(bug);
    System.out.print("Hit return to roll: ");
    INPUT.nextLine();
    die.roll();
    //bug.count++;
    bug.incrementNoOfRolls();
    System.out.print("You rolled a " + die.getTopFace());
    //add roll history
    bug.addHistory(die.getTopFace());
    switch(die.getTopFace()){
      case 1:
        System.out.println(" (body)");
	System.out.println("Roll Number: "+bug.getNoOfRolls());
        //Print roll history
        bug.getHistory();
        //Print 1s:, 2s:.....
        bug.getNoOfDie();
        return bug.addBody();
      case 2:
        System.out.println(" (head)");
        System.out.println("Roll Number: "+bug.getNoOfRolls());
        bug.getHistory();
        bug.getNoOfDie();
        return bug.addHead();
      case 3:
        System.out.println(" (leg)");
        System.out.println("Roll Number: "+bug.getNoOfRolls());
        bug.getHistory();
        bug.getNoOfDie();
        return bug.addLeg();
      case 4:
        System.out.println(" (eye)");
        System.out.println("Roll Number: "+bug.getNoOfRolls());
        bug.getHistory();
        bug.getNoOfDie();
        return bug.addEye();
      case 5:
        System.out.println(" (feeler)");
        System.out.println("Roll Number: "+bug.getNoOfRolls());
        bug.getHistory();
        bug.getNoOfDie();
        return bug.addFeeler();
      default:
        System.out.println(" (tail)");
        System.out.println("Roll Number: "+bug.getNoOfRolls());
        bug.getHistory();
        bug.getNoOfDie();
        return bug.addTail();
    }
  }
}
