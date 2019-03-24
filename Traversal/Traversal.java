import java.util.*;
import java.io.*;

public class Traversal{

	public static void main(String[] args) throws IOException {

        File infile = new File("Binarytree");
        Scanner input = new Scanner(infile);
        String s = input.next();
        System.out.println(s);
        String t;
        BinaryNode[] array = new BinaryNode[100];

        for (int i=1; i<=99; i++)
                array[i] = new BinaryNode("",null,null);

        for (int i=1; i<=s.length(); i++)
                array[i].setItem(s.substring(i-1,i));

        for (int i=1; i<=(s.length()-1)/2; i++) {
                t = s.substring(2*i-1,2*i);
                if (!(t.equals("-")))
                        array[i].setLeft(array[2*i]);
                t = s.substring(2*i,2*i+1);
                if (!(t.equals("-")))
                        array[i].setRight(array[2*i+1]);
       	 }


	 System.out.print("Pre: ");
 	 System.out.println(array[1].toStringPreorder());
	 System.out.print("In: ");
       	 System.out.println(array[1].toStringInorder());
	 System.out.print("Post: ");
       	 System.out.println(array[1].toStringPostorder());
	}
}
