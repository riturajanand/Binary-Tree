import java.util.*;

public class Zig_Zag_Traversal 
{
    static ArrayList<Integer> arrL;
    /*
     * Here we will have to traverse level by level such that for one level from left right 
     * and for another right to left. 
     * So we will use a toggle true and false variable for judging whether we need to traverse
     * L to R or R to L.
     * 
     * Let us take an example of the follwing binary tree:
     *    9 7 9 4 5 10 6 9 7
     *      
     *                      9
     *                    /   \
     *                   /     \
     *                  /       \
     *                 /         \
     *                7           9
     *               / \         / \
     *              /   \       /   \
     *             /     \     /     \
     *             4     5    10      6
     *            / \
     *           /   \
     *           9   7  
     *           
     *           
     *    We will use the deque data structure to build the logic.
     *    
     *    Initially DQ will have the root node and traverse will be set to false
     *    
     *    It means that picking elements from the front of the DQ will lead us to the 
     *    required order we need.
     *    
     *    If the current level need traversal from L to R, we will have to traverse R to L
     *    for the next level.
     *    So we need to pop() element and insert the left child first and right child later.
     *    This will help us maintain the level L to R in the DQ.
     *    
     *     If we want to traverse R to L pick elements from the end in the DQ. And insert 
     *     the right child first then the left child at the begining of the dequeue to 
     *     maintian the incoming order of the next level in the deque.
     *    
     */
    public static ArrayList<Integer> zig_zag_traversal(Node root)
    {
    	arrL=new ArrayList<Integer>();
    	if(root==null)
    		return arrL;
    	Deque<Node> dq=new LinkedList<>();
    	dq.add(root);
    	boolean traverse=true;
    	while(dq.isEmpty()==false)
    	{
    		Deque<Node> temp=new LinkedList<>();
    		while(dq.isEmpty()==false)
    		{
    			if(traverse)
    			{
    				Node currNode=dq.removeFirst();
    				if(currNode.left!=null)
    					temp.add(currNode.left);
    				if(currNode.right!=null)
    					temp.add(currNode.right);
    			}
    			else
    			{
    				Node currNode=dq.removeLast();
    				if(currNode.right!=null)
    					temp.addFirst(currNode.right);
    				if(currNode.left!=null)
    					temp.addFirst(currNode.left);
    			}
    		}
    		dq=temp;
    	}
    	return arrL;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
