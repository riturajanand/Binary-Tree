import java.util.ArrayList;
/*
 * Algorithm for pre-order traversal:
 *   1. Visit the root node
 *   2. Traverse the left substree i.e call pre-order for the left subtree
 *   3. Traverse the right subtree i.e call pre-order for the right subtree
 */
public class Preorder_Traversal_Recurive 
{

	static ArrayList<Integer> arrL;
	public static void preorder_recursive(Node root)
	{
		if(root==null)
			return;
		arrL.add(root.data);
		preorder_recursive(root.left);
		preorder_recursive(root.right);
	}
	public static ArrayList<Integer> preorder_traversal(Node root)
	{
		arrL=new ArrayList<Integer>();
		preorder_recursive(root);
		return arrL;
	}

}
