import java.io.*;
import java.util.*;

//SeokhoHan
//700657609
//SXH76090
//a6
//QuickSort
//Data structure
//Dr.Cooper

public class QuickSort {

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

		System.out.print("count is: " + count);//for checking the count

		System.out.println("Array befoer sort");
		for (int i=0; i<count; i++)
			System.out.printf("%d\n", data[i]);
		System.out.println();

		quickSort(data, count);//Edited

		System.out.println("Array after quickSort");
		for (int i=0; i<count; i++)
			System.out.printf("%d\n", data[i]);
		System.out.println();

	}

	public static void quickSort(int[] data, int count) {// Edited
		quickSortHelper(data, 0, count-1);
	}

	public static void quickSortHelper(int[] data, int i, int j) {
		if (i < j) {
			int pos = partition(data, i, j);
			quickSortHelper(data, i, pos-1);
			quickSortHelper(data, pos+1, j);
		}
	}

	public static int partition(int[] data, int i, int j) {
		int pivot = data[j];
		int small = i - 1;

		for (int k = i; k < j; k++) {
			if (data[k] <= pivot) {
				small++;
				swap(data, k, small);
			}
		}

		swap(data, j, small + 1);
		//System.out.println("pivot: " + data[small + 1]);
		System.out.println();
		return small + 1;
	}

	public static void swap(int[] data, int k, int small) {
		int temp;
		temp = data[k];
		data[k] = data[small];
		data[small] = temp;
	}
}
