import java.util.ArrayList;
/*
 * When we see the a binary tree from a right side only the right most nodes of every level
 * if visible.
 * 
 * So we will perform a level order traversal and add only the right most nodes to out solution
 * set.
 */
import java.util.*;
public class Right_View_Of_A_Tree 
{

	static ArrayList<Integer> arrL;
	public static ArrayList<Integer> right_view(Node root)
	{
		arrL=new ArrayList<Integer>();
		if(root==null)
			return arrL;
		Queue<Node> q=new LinkedList<>();
		q.add(root); q.add(null);
		while(q.isEmpty()==false)
		{
			Node prevNode=null;
			while(true) 
			{
				Node currNode=q.remove();
				if(currNode.left!=null)
					q.add(currNode.left);
				if(currNode.right!=null)
					q.add(currNode.right);
				if(q.peek()==null)
				{
					q.remove();
					arrL.add(currNode.data);
					break;
				}
			}
			if(q.isEmpty()==false)
				q.add(null);
		}
		return arrL;
	}

}
