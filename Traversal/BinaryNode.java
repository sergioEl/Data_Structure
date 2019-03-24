//Seokho Han
//700657609
//SXH76090

import java.util.*;

public class BinaryNode {

	private String item;

	private BinaryNode left;

	private BinaryNode right;

	public BinaryNode(String item) {
		this.item = item;
	}

	public BinaryNode(String item, BinaryNode left, BinaryNode right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}

	public String getItem() {
		return item;
	}

	public BinaryNode getLeft(){
		return left;
	}

	public BinaryNode getRight(){
		return right;
	}

	public boolean isLeaf(){
		return (left == null) && (right == null);
	}

	public void setItem(String item){
		this.item = item;
	}

	public void setLeft(BinaryNode left){
		this.left = left;
	}

	public void setRight(BinaryNode right){
		this.right = right;
	}

	public String toStringPreorder(){
		String result = "";
		result += item;
		if(left != null) {
			result += left.toStringPreorder();
		}
		if(right != null){
			result += right.toStringPreorder();
		}
		return result;
	}

	public String toStringInorder(){
		String result = "";
		if(left != null){
			result += left.toStringInorder();
		}
		result += item;
		if(right != null){
			result += right.toStringInorder();
		}
		return result;
	}

	public String toStringPostorder(){
		String result = "";
		if(left != null){
			result += left.toStringPostorder();
		}
		if(right != null){
			result += right.toStringPostorder();
		}
		result += item;
		return result;
	}

}
