/*
 * Diameter of a binary tree is the number of nodes between the longest paths between two
 * nodes. 
 */

/*
 * Since we have to find the number of nodes in the longest path between two nodes, 
 * It is very obvious that the path will be longest if the two nodes between which path will be
 * considered are leaf nodes. 
 * 
 * So there are three possibilities for a diameter:
 * 1. Path from the leaf node of a left subtree to the leaf node of a right subtree
 *    
 *    And number of nodes in such a path will be
 *    height of left subtree + height of right subtree +1 (root node)
 * 2. Path from a leaf node in the left subtree to another leaf node in the left subtree
 *    
 * 3. Path from a leaf node in the right subtree to another leaf node in the right subtree.
 * 
 * And diameter for a tree will be the max of left diameter, right diameter and (left height+
 * right height +1).
 * 
 */
public class Diameter_Of_A_Binary_Tree 
{
    public static int find_height(Node root)
    {
    	if(root==null)
    		return 0;
    	return 1+Math.max(find_height(root.left),find_height(root.right));
    }
    public static int find_diametre(Node root)
    {
    	if(root==null)
    		return 0;
    	int left_height=find_height(root.left);
    	int right_height=find_height(root.right);
    	
    	int left_diametre=find_diametre(root.left);
    	int right_diametre=find_diametre(root.right);
    	
    	return Math.max(left_diametre, Math.max(right_diametre,left_height+right_height+1));
    }
	
}
