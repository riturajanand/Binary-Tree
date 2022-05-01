/*
 * the height of a binary tree is equal to the largest number of edges from the 
 * root to the most distant leaf node.
 * 
 * i.e in simpler terms number of levels is also the height of a binary tree. 
 */
public class Height_Of_A_Binary_Tree 
{
	//Classical solution
	static int height;
     public static int find_height(Node root)
     {
    	 if(root==null)
    		 return 0;
    	 
    	 int left_height=find_height(root.left);
    	 int right_height=find_height(root.right);
    	 
    	 return Math.max(left_height, right_height)+1;

     }
     //Static optimisation
     public static int find_ht(Node root)
     {
    	 height=0;
    	 helper(root,0);
    	 return height;
     }
     public static void helper(Node root,int val)
     {
    	 if(root==null)
    	 {
    		 height=Math.max(height, val);
    		 return;
    	 }
    	 
    	 helper(root.left,val+1);
    	 helper(root.right,val+1);
     }
}
