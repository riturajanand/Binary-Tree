import java.util.*;
/*
 * When we see from the top for a particular level only those nodes will visible which lie
 * outside the left and right ranges of nodes traversed so far. 
 * For example: Look at the follwing tree
	             0 1
			    /     \
		   -1  2       3    1
			  /  \    /  \
		 	 4    5   6  7
		     
		     -2   0   0   2
			 
		Level 1: 1 
		Level 2: 2    3
		Level 3: 4 5 6 7
		
		If we draw a vertical line along the root of the tree. Then the line is at the distance 
		0 units from the root, left node is at -1 units distance and right at 1 unit distance
		
		If d is the distance of a node from the root then its
	    left child is d-1 units away from the root and right child d+1 units away.
	    
	    We will maintain a deque as our solution set.
	    
	    We also maintain variables min and max to maintain the min and max range of d values
	    And if we get a d value less than the min then we update the min value and append it
	    at the begining of the list and if we get a d value greater than max then we 
	    we update the max and push it at the end of the deque.
	    
	    We push elements that way because the output order is like that.


 * 
 */
class Pair
{
	Node n;
	int dis;
	Pair(Node n,int dis)
	{
		this.n=n;
		this.dis=dis;
	}
}
public class Top_View 
{
	static ArrayList<Integer> arrL;
    public static ArrayList<Integer> top_view(Node root)
    {
    	arrL=new ArrayList<Integer>();
    	if(root==null)
    		return arrL;
    	Queue<Pair> q=new LinkedList<>();
    	Deque<Integer> dq=new LinkedList<>();
    	q.add(new Pair(root,0));  q.add(null);
    	int min=1, max=0;
    	while(q.isEmpty()==false)
    	{
    		while(q.peek()!=null) 
    		{
    			Pair currPair=q.remove();
    			Node currNode=currPair.n;
    			int d=currPair.dis;
    			if(d<min)
    			{
    				min=d;
    				dq.addFirst(currNode.data);
    			}
    			else if(d>max)
    			{
    				max=d;
    				dq.addLast(currNode.data);
    			}
    			
    			if(currNode.left!=null)
    				q.add(new Pair(currNode.left,d-1));
    			if(currNode.right!=null)
    				q.add(new Pair(currNode.right,d+1));
    		}
    		q.remove();
    		if(q.isEmpty()==false) 
    	            q.add(null);
    	}
    	while(dq.isEmpty()==false)
    		arrL.add(dq.removeFirst());
    	return arrL;
    	
    }
}
