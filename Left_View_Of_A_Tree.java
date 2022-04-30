import java.util.ArrayList;
import java.util.LinkedList;
/*
 * When we see the a binary tree from a left side only the left most nodes of every level
 * if visible.
 * 
 * So we will perform a level order traversal and add only the left most nodes to out solution
 * set.
 */
import java.util.Queue;
public class Left_View_Of_A_Tree 
{
	static ArrayList<Integer> arrL;

	public static ArrayList<Integer> left_view(Node root)
	{
		arrL=new ArrayList<Integer>();
		if(root==null)
			   return arrL;
		Queue<Node> q=new LinkedList<>();
		q.add(root); q.add(null);
		while(q.isEmpty()==false) 
		{
			arrL.add(q.peek().data);
			while(q.peek()!=null)
			{
				Node currNode=q.remove();
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
