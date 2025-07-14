	import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

// Helper class to store each tree and its k value
class TreeAndK {
    BinarySearchTree tree;
    int k;

    TreeAndK(BinarySearchTree tree, int k) {
        this.tree = tree;
        this.k = k;
    }
}

public class Main {

    public static void main(String[] args) {
        
        //Lit to store each tree line
        List<TreeAndK> trees = new ArrayList<>();
        
        
        
        
        //Read from a file
        try {
            BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\sbong\\eclipse-workspace\\BinaryTrees\\src\\nat_nums.txt"));
            String line;
            
            //reading from a file
            while((line = read.readLine()) != null) {
                // New binary for each line
                BinarySearchTree BsT =  new BinarySearchTree();
                
                
                String[] kval = line.split("#"); //splits the line in and puts k val aside
                // These are the numbers before the #
                String numKval = kval[0].trim();
                int k = -1;
                
                
                if (kval.length > 1 && !kval[1].trim().isEmpty()) { //checks if there is # after k value without any spaces
                    k = Integer.parseInt(kval[1].trim());// converts that string to an integer
                }
                String[] data = numKval.split(",");//you take the other part of k values before #
                                                      //AND splt them into array numbers;
                
                for(String val: data ) {
                    //this convert each num to a interger 
                    int num = Integer.parseInt(val.trim()); //removes any spaces in between
                    //
                    Node newNode = new Node(num);
                    
                    //inserting the new node in the tree
                    BsT.insert(newNode);
                    }
                
                trees.add(new TreeAndK(BsT, k)); // store the tree and k together
            }
            read.close();
            
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Error reading file, please check the file path.");
            e.printStackTrace();
        }
        
        
        // After reading all trees now test find_kth_smallest
        int bstNumber = 1;//start counting from 1
        for (TreeAndK tk : trees) { // for each tree and k val
            System.out.print("BST " + bstNumber + ": "); // print which bst num we are on
            if (tk.k == -1) { /// if no k value was provided(k was missing in a file)
                System.out.println("No k value provided.");
                
            } else {
            	
                int result = tk.tree.find_kth_smallest(tk.k); // therefore call the method to find the smallest kth value
                if (result != -1) {//if result are valid
                    System.out.println("k = " + tk.k + "and " + tk.k + "th smallest node = " + result);
                } else { // fi k too  large ( not on the list)
                    System.out.println("k = " + tk.k + " and Input not valid");
                }
            }
          //move on to the next tree
            bstNumber++;
            
        }

    }

}

