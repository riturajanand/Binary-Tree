/*
 * Algorithm for in order traversal:
 *    1. Traverse the left subtee i.e call inorder for the left subtree
 *    2. Visit the root
 *    3. Traverse the right subtree i.e call inorder for the root
 */
import java.util.ArrayList;
public class Inorder_Traversal_Recursive 
{
	static ArrayList<Integer> arrL;
     public static void inorder_recursive(Node root)
     {
    	 if(root==null)
    		 return;
    	 inorder_recursive(root.left);
    	 arrL.add(root.data);
    	 inorder_recursive(root.right); 
     }
     
     public static ArrayList<Integer> inorder_traversal(Node root)
     {
    	 arrL=new ArrayList<Integer>();
    	 inorder_recursive(root);
    	 return arrL;
     }
}
