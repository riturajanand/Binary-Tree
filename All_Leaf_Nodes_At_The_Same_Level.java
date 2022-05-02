/*
 * We need to check whteher all the leaf nodes of a binary tree are at the same level or not.
 */
import java.util.*;
public class All_Leaf_Nodes_At_The_Same_Level 
{
	/*
	 * METHOD 1: 
	 * Here we need to perform a level order traversal.
	 * And if we encounter a leaf node but the queue is not empty i.e we have nodes
	 * at the further level then it is obvious that we dont have all the leaf nodes at the same
	 * level.  
	 * 
	 * Time complexity O(n)
	 * Space complexity O(n)
	 */
    
	public static boolean check(Node root)
	{
		if(root==null)
			return true;
		Queue<Node> q=new LinkedList<>();
		q.add(root); q.add(null);
		boolean found_a_leaf_node=false;
		while(q.isEmpty()==false)
		{
			while(q.peek()!=null)
			{
				Node currNode=q.remove();
				if(currNode.left==null&&currNode.right==null)
				  found_a_leaf_node=true;
				else
				{
					if(currNode.left!=null)
						q.add(currNode.left);
					if(currNode.right!=null)
						q.add(currNode.right);
				}
			}
			q.remove();
			if(found_a_leaf_node&&q.isEmpty()==false)
				return false;
			if(q.isEmpty()==false)
				q.add(null);
		}
		return true;
		
		//using method 2
		/*
		 * return find_height(root)!=-1;
		 */
	}
	/*
	 * The function below, find_height() will return -1 if all the leaf nodes are not
	 * at the same level.
	 * Let us look upon how it does that.
	 * 
	 * For all the root nodes to be at the same level, the height of the left subtree 
	 * should be equal to the height of the right subtree for every node. 
	 * 
	 * And at any node if its doesnt satifies the recursion stack starts returning -1 from there
	 *
	 *But there is still a corner case 
	 *
	 *Let us consider a case where a node doesnt have a left child but has a right subtree 
	 *
	 *so left_height for that node will be 0 but right height will be suppose 1 For node 2 below
	 *
	 *               1
	 *              / \
	 *             /   \
	 *            2     3
	 *             \   / \
	 *             4   5  6 
	 *             
	 *     But node 2 is not a leaf node so for any node if we get left height or right height 
	 *     0 then return the height which is non zero +1.
	 *     
	 *     And if the left heights and the right heights are equal the return any height +1
	 *     
	 *     if the heights are unequal and non of themis zero then return -1
	 *     
	 *     And once at level we return height as -1, it will return -1 till the base case.
	 *             
	 */
	public static int find_height(Node root)
	{
		if(root==null)
		   return 0;
		int left_height=find_height(root.left);
		int right_height=find_height(root.right);
		
		if(left_height==-1 || right_height==-1)
			return -1;
		if(left_height==0||right_height==0)
			return Math.max(left_height, right_height)+1;
		
		if(left_height!=right_height)
			return -1;
		return left_height+1;
		
	}

}
