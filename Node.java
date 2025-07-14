
public class Node {
	
	private int data;
	private Node left;
	private Node right;
	
	//Default Constructor 
	public Node (int num) {
		data = -1;
		left = null;
		right = null;
	}
	
	//Loaded constructor
	public Node(int val,Node leftSide,Node rightSide) {
		data = val;
		left = leftSide;
		right = rightSide;
	}
	// Getter methods
	public int getData() {
		return data;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	// Setter methods
	public void setData(int data) {
		if (data < 0 ) {
			System.err.println("Error: can not store (-)values");
		}
		else {
			this.data = data;
		}
	}
	public void setLeft(Node left) {
		
		if (left == null) {
			System.out.println("Node can not be null");
		} else if (left.getData() < 0 ) {
			System.out.println("Left node can not contain negative(-) data");
		} else {
			this.left = left;
		}
	}
	
	public void setRight(Node right) {
		if (right == null) {
			System.out.println("Node can not be null");
		} else if (right.getData() < 0 ) {
			System.out.println("Left node can not contain negative(-) data");
		} else {
			this.right = right;
		}
	}
	
	
}
