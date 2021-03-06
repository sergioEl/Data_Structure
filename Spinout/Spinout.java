import java.util.InputMismatchException;

import java.util.Scanner;




//Seokho Han

//700657609

//SXH76090

//Prof.Curtis Cooper

//Data Structure

//Get a solution for spinout game using unLock and lock algorithm 




public class Spinout {

	


	private static int number;

	private static int[] spinner;

	private static int count;

	private boolean badData;

	


	public Spinout(){

		System.out.println("Input number of spinners < 20: ");

		Scanner scan = new Scanner(System.in);

		do{

			badData = true;

			try{

				number = scan.nextInt();

				if(number < 0 || number > 19) throw new OutOfRangeException();

				badData = false;

				spinner = new int[number];

				for (int i = 0; i < spinner.length; i++) {

					spinner[i] = 1;

				}

			}catch(InputMismatchException ex){

				System.out.print("Bad data - try again: ");

				scan.nextLine();

			}catch(OutOfRangeException ex){

				System.out.print("Integer Out Of Range - try again: ");

				scan.nextLine();	

			}

		}while(badData);

	}




	public void play(){

		unLock(number);

		if(isWin()){

			System.out.println("Win!");

		}

	}




	public static boolean isWin(){

		boolean x = true;

		for (int i = 0; i < spinner.length; i++) {

			if(spinner[i] == 1){

				x = false;

			}

		}

		return x;

	}

	


	public static void unLock(int n){

			if(n == 0) return;//Added
/**
			if(n==1){
				System.out.print("1 ");
			}//Added

*/
			if(n > 0){

				unLock(n-2);

				//print();

				spinner[n-1] = 0;

				System.out.printf("%d-->",n);

				count++;

				lock(n-2);

				unLock(n-1);

			}

	}

	


	public static void lock(int n){

		if(n > 0){

			lock(n-1);

			unLock(n-2);

			spinner[n-1] = 1;

			//print();

			System.out.printf("%d-->",n);

			count++;

			lock(n-2);

		}

	}

	


	public static void print(){

		for (int i = spinner.length-1; i >= 0; i--) {

			System.out.print(spinner[i]+"  ");

		}

		System.out.println();

		


		//System.out.println(Arrays.toString(spinner));

	}

	


	public static void main(String[] args) {

		Spinout s = new Spinout();

		print();

		System.out.println("Here is a solution to Spinout");

		s.play();

		print();

		System.out.printf("Number of moves: %d\n", count);

	}

}
