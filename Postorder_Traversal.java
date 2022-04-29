/*
 * Algorithm for post order traversal:
 *   1. Traverse the left subtree i.e call postorder for left subtree
 *   2. Traverse the right subtree i.e call postorder for the right subtree
 *   3. Vist the root node.
 */
import java.util.ArrayList;
public class Postorder_Traversal 
{
    static ArrayList<Integer> arrL;
    public static void postorder_recursive(Node root)
    {
    	if(root==null)
    		return;
    	postorder_recursive(root.left);
    	postorder_recursive(root.right);
    	arrL.add(root.data);
    }
	public static ArrayList<Integer> postorder(Node root)
	{
		arrL=new ArrayList<Integer>();
		postorder_recursive(root);
		return arrL;
	}

}
