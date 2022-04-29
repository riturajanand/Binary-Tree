import java.util.*;
public class Reverse_Level_Order_Traversal 
{
	/*
	 * Here we just need to make some slight changes in the level order traversal code
	 * Rest the core logic is exaclty same as the level order traversal.
	 * 
	 * Here we will push the right child of a node first then the left child. 
	 * And when we will process a particular node after removing from the queue
	 * we will push it to the stack.
	 * Following illustration will make it more clear:
	 * 
	 *                    1
	 *                   / \
	 *                  /   \
	 *                 /     \
	 *                /       \
	 *               2         3
	 *              / \       / \
	 *             /   \     /   \
	 *            /     \   /     \
	 *            4      5 6       7
	 *            
	 *           We start with pushing 1 to the queue then we push null. 
	 *           Queue ={1, null}
	 *           
	 *           Now we will pop one from the queue 
	 *           Insert the right child of the queue and then the left child 
	 *           
	 *           So after processing the node 1 queue becomes {3,2,null}
	 *           And we will push 1 onto the stack Stack ={1}
	 *           
	 *           Then we will pop 3 from the queue and will add its right child then its left child 
	 *           Queue becomes {2, null, 7 ,6}
	 *           We will add 3 to the stack Stack={3,1}
	 *           
	 *           Then we will pop 2 from the queue and will add its right child then its left child 
	 *           Queue becomes {7, 6,5,4} 
	 *           We will add 2 to the stack Stack={2,3,1}
	 *           
	 *           After processing all the elements the Stack becomes {4,5,6,7,2,3,1}
	 *           
	 *           We will pop() elements from the stack one by one until it becomes empty.
	 *           
	 *           We will get the required reversed level order traversal.
	 */
    public static ArrayList<Integer> reversed_level_order_traversal(Node root)
    {
    	ArrayList<Integer> arrL=new ArrayList<Integer>();
    	if(root==null)
    		return arrL;
    	Queue<Node> q=new LinkedList<Node>();
    	Stack<Integer> st=new Stack<Integer>();
    	
    	q.add(root); q.add(null);
    	while(q.isEmpty()==false)
    	{
    		while(q.peek()!=null)
    		{
    			Node currNode=q.remove();
    			if(currNode.right!=null)
    				q.add(currNode.right);
    			if(currNode.left!=null)
    				q.add(currNode.right);
    			st.add(currNode.data);
    		}
    		q.remove();
    		if(q.isEmpty()==false)
    			q.add(null);
    	}
    	return arrL;
    	
    }

}
