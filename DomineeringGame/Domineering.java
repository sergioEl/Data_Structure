//Seokho Han
//700657609
//DomineerinGame
//a3

import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;

//C = changed codes;


public class Domineering {

  public static final java.util.Scanner INPUT = new java.util.Scanner(System.in);

  public static final boolean HORIZONTAL = false;

  public static final boolean VERTICAL = true;

  private int nr,nc;

  private boolean [][] squares;

  public Domineering(int nr, int nc){

    this.nr = nr; this.nc = nc;
    squares = new boolean[nr][nc];

  }

  public void play(){
    int row = 0;
    int column = 0;
    boolean player = HORIZONTAL;
    boolean badData;
    while(true){
      System.out.println("\n" + this);
      if(player == HORIZONTAL){
        System.out.println("Horizontal (player)  to play");
      }else{
         System.out.println("Vertical (computer) to play");
       }
      if(!(hasLegalMoveFor(player))){
        System.out.println("No legal moves -- you lose!");
        return;
      }
      if(player == HORIZONTAL){
//                     HORIZONTAL(player)
        do {
          badData = true;
          try {
              System.out.print("Input Row Column: ");
              row = INPUT.nextInt();
              column = INPUT.nextInt();
              if (row < 0 || row >(nr-1) || column < 0 || column > (nc-1)|| (player==VERTICAL && row ==(nr-1))|| (player==HORIZONTAL && column == (nc-1))) throw new ArrayIndexOutOfBoundsException();
              if(player == HORIZONTAL){
                if(squares[row][column]==true || squares[row][column+1]==true) throw new DominosAreStackedException();
              } //C
              else{
                 if(squares[row][column]){
                   INPUT.nextLine();
                   badData = false;
                 }
             }
           badData = false; //C
          } catch(InputMismatchException e){
              System.out.println("Input not an integer try again: ");
              INPUT.nextLine();
          } catch (ArrayIndexOutOfBoundsException e ){
              System.out.println("Input is out of bound try again: ");
              INPUT.nextLine();
          } catch(DominosAreStackedException e){
              System.out.println("Dominos are stacked try again: ");
              INPUT.nextLine();
            }
        }while(badData);
      }else {
        //VERTICAL (computer) to move
        badData = true;
        do{
          row = (int)((nr-1) * (Math.random()));
          column = (int)(nc*(Math.random()));
          if(!squares[row][column] && !squares[row+1][column])
            badData = false;
        }while(badData);
         System.out.println("Vertical (computer) move" + row + " and "+ column);
       }
      playAt(row, column, player);
      player = !player;
    }
  }

  public void playAt(int row, int column, boolean player){
    squares[row][column] = true;
    if(player == HORIZONTAL){
      squares[row][column + 1] = true;
    }else{
       squares[row + 1][column] = true;
     }
  }

  public boolean hasLegalMoveFor(boolean player){
    int rowOffset = 0;
    int columnOffset = 0;
    if(player == HORIZONTAL){
      columnOffset = 1;
    }else{
       rowOffset = 1;
     }
    for(int row = 0; row < (nr - rowOffset); row++){  //C
      for(int column = 0; column < (nc - columnOffset); column++){ //C
        if(!(squares[row][column] || squares[row + rowOffset][column + columnOffset])){
          return true;
        }
      }
    }
    return false;
  }

  public void pHD(String s, int r, int c) {
    squares[r][c] = true;
    if(s.equals("h")) squares[r][c+1] = true;
    else squares[r+1][c] = true;
  }

  public static void main(String[] args){
    System.out.println("Welcome to Domineering.");
//set rows and cols then check them with try-catch
    boolean badData;
    int nr,nc;
    int rowhandicap = 0;
    int columnhandicap = 0;
    String handicapstring = "";
    nr = 8; nc = 8;
    do {
      badData = true;
      try{
        System.out.print("Input rows cols on board: ");
        nr = INPUT.nextInt();
        nc = INPUT.nextInt();
          if(nr < 1 || nr > 10 || nc < 1 || nc > 10){
              throw new DataNotInRangeException();
          }
        badData = false;
      } catch(InputMismatchException e){
          System.out.println("Data is not Integer try agaim: ");
          INPUT.nextLine();
      } catch(DataNotInRangeException e ){
          System.out.println("Integer data is not in range try again: ");
          INPUT.nextLine();
      }
    } while(badData);
    Domineering game = new Domineering(nr, nc);
    INPUT.nextLine(); //C
    do{
      badData = true;
      try{
        System.out.print("Enter h or v for handicap domino: ");
        handicapstring = INPUT.nextLine();
        if(!handicapstring.equals("h") && !handicapstring.equals("v"))
          throw new WrongDirectionException();
        System.out.print("Enter row and column: ");
        rowhandicap = INPUT.nextInt();
        columnhandicap = INPUT.nextInt();
          if(rowhandicap<0 || rowhandicap>(nr-1) || columnhandicap<0 ||columnhandicap > (nc-1) || (handicapstring.equals("h") && columnhandicap==(nc-1))|| (handicapstring.equals("v") && rowhandicap==(nr-1))) throw new ArrayIndexOutOfBoundsException();
        INPUT.nextLine();
        badData = false;
      }catch(InputMismatchException e){
         System.out.println("Bad Data - Try it again: ");
         INPUT.nextLine();
      }catch(WrongDirectionException e){
         System.out.println("Wrong Direction - Try it again: ");
         INPUT.nextLine();
      }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Index out of bounds - Try it again: ");
        INPUT.nextLine();
      }
    }while(badData);
    game.pHD(handicapstring,rowhandicap,columnhandicap);
    game.play();
  }

  public String toString(){
    String result = "  ";
    for(int column = 0 ; column < nc ; column++)
      result += column + " ";
    for(int row = 0;row < nr;row++){
      result += "\n" + row;
      for(int column = 0;column < nc;column++){
        if(squares[row][column]){
          result += " #";
        }else{
           result += " .";
         }
      }
    }
    return result;
  }
}
