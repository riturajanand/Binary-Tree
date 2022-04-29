import java.util.ArrayList;
import java.util.*;
/*
 * Level order traversal is also known as breadth first traversal.
 * 
 * In order to print the level order traversal of a tree we will use the queue data structure
 * 
 * We will start by pushing the root node and we also will push null.
 * 
 * If the tree looks like 
 *                    1
 *                   / \
 *                  /   \
 *                 2     3
 *                / \   / \
 *               4   5 6  7
 *               
 *      Queue will be {1, null}
 *      Here 'null' is used to mark the end of a level.
 *      Now in the insser while loop we pop the elements from the queue one by one and 
 *      inserts it value to arrL and we will insert its left and right child (if exists)
 *      
 *      When the front of the queue is null, this means we have traversed this level and 
 *      pushed their left and right childs (if exists) i.e we have inserted the next level in 
 *      the queue. 
 *      Now we will pop the null at the front of the queue out, in order to start traversing the 
 *      level and push a null to mark the end of the level while traversing.
 */
public class Level_Order_Traversal 
{
	public static ArrayList<Integer> level_order_traversal(Node root)
	{
		ArrayList<Integer> arrL=new ArrayList<Integer>();
		if(root==null)
			return arrL;
		Queue<Node> q=new LinkedList<Node>();
		
		q.add(root); q.add(null);
		
		while(q.isEmpty()==false)
		{
			while(q.peek()!=null)
			{
				Node currNode=q.remove();
				arrL.add(currNode.data);
				if(currNode.left!=null)
					q.add(currNode.left);
				if(currNode.right!=null)
					q.add(currNode.right);
			}
			q.remove();
			if(q.isEmpty()==false)
				q.add(null);
		}
		return arrL;
	}

}
