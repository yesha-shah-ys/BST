import java.util.Stack;
import java.lang.*;

//import java.util.*;

//left, right child along with key value
class Node{
	
	int data;
	Node left, right;
	
	public Node(int item) { 
        data = item; 
        left = right = null; 
    }

}

//BST class
public class BinarySearchTree {
		Node root;
		Node Current = root;
		Stack<Node> S = new Stack<Node>();
		
	public Node create_empty_tree(int d)
	{
		Node obj= new Node(d);
		obj.data = d;
		obj.left = null;
		obj.right = null;
		return obj;
	}

		public Node ConstructBST(Node root,int a)
		{	
			
			if(root == null)				//checks if the node is null
			{
				return create_empty_tree(a);		//if the node is null creates a node by calling this method
			}
			
			if(a < root.data)
			{
				root.left = ConstructBST(root.left,a);
			}
			else if(a > root.data)
			{
				root.right = ConstructBST(root.right,a);
			}
			return root;
			}
		
	//traverses tree
	void inorder(Node root)
		{
		
		Stack<Node> S = new Stack<Node>();
		Node Current = root;
			
			if(Current==null) return;
			
			//check for left most node 
			while(Current != null || S.size() > 0)
			{
				while(Current !=null)   //pushes the node into the stack until the left sub tree is null
				{
				S.push(Current);			
				Current = Current.left;  
				}
			Current = S.pop();			
			System.out.println(Current.data);   //Prints the sorted elements
			Current = Current.right;
			}	
	}
	
	//Returns the key at the root
	public int getRoot(Node key)
	{
		return key.data;
	}

	//If tree is empty
	public boolean Empty(Node n)
	{
		if(n==null)
			return true;
		return false;
		
	}
	
	//Returns the left subtree of the root
	void LeftSubTree(Node root)
	{
		if(root==null) //base case
			return;
		
		while(root.left!=null || root.right!=null)
		{
			while(root.left!=null)
			{
				root = root.left;
				System.out.println(root.data + "");
			}
			root = root.right;
			System.out.println(root.data + "");
		}
	}
	
	//Returns the right subtree of the root
		void RightSubTree(Node root)
		{
			if(root==null) //base case
				return;
			
			while(root.left!=null || root.right!=null)
			{
				while(root.right!=null)
				{
					root = root.right;
					System.out.println(root.data + "");
				}
				root = root.left;
				System.out.println(root.data + "");
			}
		}

		//Test if the tree contains a given value
		public boolean Contains(Node n, int target) {
			if (n == null) { // base case 
				return false;
			} else if (n.data == target) {
				return true;
			} else if (target < n.data) {
				return Contains(n.left, target);
			} else { // if (target > root.data)
				return Contains(n.right, target);
			}
		}	
		
		public Node Insert(Node n,int input)
		{
			if(n==null)
			{
				n = new Node(input);
				return n;
			}
			/*if(input==n.data)
			{
				n.right=input;
			}*/
			if(input > n.data)
			{
				n.right=Insert(n.right,input);
			}
			else if(input < n.data)
			{
				//System.out.print(n.data);
				n.left = Insert(n.left,input);
			}
			return n;
		}
		
		
		
		public static void main(String args[])
		{
			int a[]=new int[]{9,12,7,1,11,6,10};
			SortIntegers SI= new SortIntegers();
			SI.sortIntegerArray(a);
			
		/*	//call a method to test if a value is in the tree or not
			BST.LeftSubtTree(root);
			BST.Contains(root, value);*/
		}
		}
 class SortIntegers 
{
	public void sortIntegerArray(int[] a)
	{
		Node n=null;
		BinarySearchTree BST = new BinarySearchTree();
		for(int i=0; i< a.length; i++){
			n=BST.ConstructBST(n,a[i]);
		}
			System.out.println("Sorted Array:");  //function called to traverse BST and sort it
			BST.inorder(n);		
			System.out.println("--------------");
			System.out.println("Key at root:");
			System.out.print(BST.getRoot(n)+"\n");
			System.out.println("--------------");
			System.out.println("Left subtree of the root:");
			BST.LeftSubTree(n);
			System.out.println("--------------");
			System.out.println("Right subtree of the root:");
			BST.RightSubTree(n);
			System.out.println("--------------");
			System.out.println("If tree is empty:");
			System.out.print(BST.Empty(n)+"\n");
			System.out.println("--------------");
			System.out.println("Check if a number is on tree:");
			System.out.print(BST.Contains(n,1)+"\n");
			System.out.print(BST.Contains(n,22)+"\n");
			BST.Insert(n, 2); 							//insert number BST
			System.out.println("--------------");
			System.out.println("Sorted array after insertion:");
			BST.inorder(n); 
		
	}
}
