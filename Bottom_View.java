import java.util.*;

/*
 * The core logic is same the top view i.e drawing a line at the root of the binary tree.
 * 
 * The main point here is we will be able see a node from the bottom if it is not
 * blocked by the some other node at the lower level 
 * For exmaple:
 *                    20    0
                    /    \
             -1    8       22    1
                /   \        \
           -2  5   0 3       25  2
                   /   \      
                  10    14
                  -1    1
                  
     Let see the scenario of root 20 is at distance 0 then at the third level 3 is at distance
     0 so that will be visible from the bottom. 
     8 is at distance -1 later 10 comes at it, so 8 will be visible from the bottom.
     
     So we maintain variables min and max to maintain the range of d values.
     We use a hashmap to store key value pairs of d as key and data of that node as its value
     and if get a new node at the further level we update entry in the hash map.
 */ 
public class Bottom_View 
{
    static ArrayList<Integer> arrL;
    public static ArrayList<Integer> bottom_view(Node root)
    {
    	arrL=new ArrayList<Integer>();
    	if(root==null)
    		return arrL;
    	Queue<Pair> q=new LinkedList<>();
    	HashMap<Integer,Integer> hm=new HashMap<>();
    	q.add(new Pair(root,0));   q.add(null);
    	int min=0,max=0;
    	while(q.isEmpty()==false)
    	{
    		while(q.peek()!=null)
    		{
    			Pair currPair=q.remove();
    			Node currNode=currPair.n;
    			int d=currPair.dis;
    			if(d<min)
    				min=d;
    			else if(d>max)
    				max=d;
    			hm.put(d,currNode.data);
    		    if(currNode.left!=null)
    		    	q.add(new Pair(currNode.left,d-1));
    		    if(currNode.right!=null)
    		    	q.add(new Pair(currNode.right,d+1));
    		}
    		q.remove();
    		if(q.isEmpty()==false)
    			q.add(null);
    	}
    	//Retriving the data from the hash map from min to max d values (desired order) for
    	//the solution set.
    	for(int i=min;i<=max;i++)
			arrL.add(hm.get(i));
    	
    	return arrL;
    }

}
