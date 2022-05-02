
/*
 * We know that images in a plane mirror are laterally inverted i.e left side
 * of the object appears right side in the image and vice versa. 
 * 
 * So in order to create a mirror image of a tree we need to make the left node of the original
 * tree the right child of the new node i.e the mirrot image node and vice versa.
 * 
 * 
 * In the recursive function below we are creating the mirror tree 
 * By first creating a node with the same value as the root. 
 * Then left subtree of this node will the right subtree of the original tree after
 * inverting the left and right child of every node in the left subtree of the original tree.
 * 
 *  Also the right subtree of this node will be the left subtree of the original tree after 
 *  inverting all the left anf right child of every node in the right subtree of the original 
 *  tree.
 */
public class Mirror_Of_A_Binary_Tree 
{
      public static Node create_mirror_image(Node root)
      {
    	  if(root==null)
    		  return null;
    	  Node newRoot=new Node(root.data);
    	  newRoot.left=create_mirror_image(root.right);
    	  newRoot.right=create_mirror_image(root.left);
    	  return newRoot;
      }
	
}
