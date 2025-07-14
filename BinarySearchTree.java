
public class BinarySearchTree {
	
	private Node root;
	private int size;
	
	//Default constructor
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	
	//Loaded constructor
	public BinarySearchTree(Node root, int size) {
		this.root = root;
		this.size = size;
	}
	// Getter Methods
	public Node getRoot() {
		return root;
	}
	
	public int getSize() {
		return size;
	}
	// Setter methods
	public void setRoot(Node root) {
		this.root = root; }
	
	public void setSize(int size) {
		this.size = size;
	}
	
	//Method to search 
	public boolean search(Node id) {
		return searchByroot(root,id);
	}
	public boolean searchByroot(Node root,Node id) {
		if (root == null)
			return false;
		else if (root.getData() == id.getData())
			return true;
		
		//
		boolean decision = searchByroot(root.getLeft(),id) ||
			searchByroot(root.getRight(),id);
			return decision;
	}
	// Method to insert a Node
	public void insert(Node n) {
		if (root == null) {
			root = n;
			size++;}
		else {
			insertAssist(root,n);
		}
	}

	private void insertAssist(Node root, Node n) {
		// TODO Auto-generated method stub
		if (n.getData() < root.getData()) {
			//Go far left
			if (root.getLeft() == null) {
				root.setLeft(n);
				size++;	
			}else {
				insertAssist(root.getLeft(),n);
			}
		}else if(n.getData() > root.getData()) {
			//go far right
			if (root.getRight()== null) {
				root.setRight(n);
				size++;
			}
			else {
				insertAssist(root.getRight(),n);
			}
		}else {
			System.out.println("Duplicate is found");
		}
	}
	
	public Node delete(int id) {
		return deleteAssist(root,id);
	}
	
	private Node deleteAssist(Node root,int id) {
		if (root == null ) 
			return root;
		
		
		
		if(id < root.getData()) {
			root = deleteAssist(root.getLeft(),id);} //keep searching
		
		 	      
		 if(id > root.getData()) {
			root = deleteAssist(root.getRight(),id);}
		 
		else {
			//Node to delete if found
			size--;
			//Case 1
			if (root.getLeft()==null && root.getRight()==null)
				return null;
			
			//Case 2
			else if(root.getLeft() == null) {
				return(root.getRight());
			}
			else if(root.getRight()== null)
				return(root.getLeft());
			
			//Case 3 and 4
			else {
				//go look fo a predecessor on the left side of the root
				Node predec = root.getLeft();
				while (predec.getRight() != null){
					//Now keep going right until you find the highest value 
					predec = predec.getRight();
				}
				//once found set it to be a predec
				root.setData(predec.getData()); 
				//now delete the predecessor
				root.setLeft(deleteAssist(root.getLeft(),predec.getData()));
			}
			
		}
		
			return root;
			
	}
	
	private int counter = 0;
	private int result = -1; 
	public int find_kth_smallest(int k) {
		counter = 0; //tracks how many node it has seen
		result = -1;
		
		find_kth_smallest_Assist(root, k);
		
		if (result == -1) {
			System.out.println("INVALID");
		}
		return result;
	}
	
	private void find_kth_smallest_Assist(Node node, int k) {
		if(node == null) 
			return;
		// now look around the left subtree
		find_kth_smallest_Assist(node.getLeft(),k);
		
		//after checking this node the increment
		counter ++;
		
		if (counter ==k ) { //when counter ==k grab the node's data
			result = node.getData();
			return;
			
			
		}
		//check on the right subtree
		find_kth_smallest_Assist(node.getRight(),k);
	
	}
	
}
