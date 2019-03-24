import java.io.File;
import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) throws Exception {

		File infile = new File("input");
		Scanner input = new Scanner(infile);

		int[] data = new int[100];
		int x, count;

		count = 0;
		while (input.hasNext()) {
			x = input.nextInt();
			data[count++] = x;
		}

		System.out.println("Array before sort");
		for (int i=0; i<count; i++)
			System.out.printf("%d\n", data[i]);
		System.out.println();

		insertionSort(data, count);

		System.out.println("\n\nArray after InsertionSort");
		for (int i=0; i<count; i++)
			System.out.printf("%d\n", data[i]);
		System.out.println();
	}

	public static void insertionSort(int[] data, int count) {
		for (int i=0; i<count; i++) {
			int j = i;
			int temp;
			while (j>0 && data[j-1] > data[j]) {
				temp = data[j];
				data[j] = data[j-1];
				data[j-1] = temp;
				j--;
			}
		}
	}
}
