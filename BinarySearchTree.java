/**
 * @author oussama EL aallali.
 * 12/27/2016
 *invariant:
 *the binary tree class uses ComputerParts class
 *the binary tree class uses treeNode class
 *the class is based on binary search tree implementation
 *the root is always pointing at the first element in the tree 
 *an element is stored in a tree node 
 *a node has a data filed a left node and right node
 *a  binary search tree is order as follow: 
 *the node that is less then it's parent is stored in the left  a node that is greater then it
 *parent is stored in the right 
 *
 * */

import java.util.*;



public class BinarySearchTree {
	
	private ArrayList<ComputerParts> al;
	private treeNode root;

	/**
	 *  Constructor of the binary y search tree 
	 *  @post root is given the value null
	 */
	
	public BinarySearchTree(){
		root = null;
		
	}
	/**
	 * isEmpty()
	 * method that checks whether a binary tree is empty 
	 * @return true or false
	 * @post returns true if the list is empty or false is not empty 
	 */
	public boolean isEmpty(){
		
		return (root == null);
		
	}
	
	/**
	 * add()
	 * a recursive method that adds an element to the binary search tree 
	 * @param data is ComputerParts object 
	 * @pre the parameter must be a ComputerParts object
	 * @post an element is added in order to the left if it is less then its parent 
	 * or to the right if it is grater then its parent 
	 * 
	 */
	
	public void add (ComputerParts data){
		
		if (root ==null)
			
			root = new treeNode(data,null,null);
		else 
			add(data,root);
		
	}
	
	private void add(ComputerParts data,treeNode cur){
		
		if (data.compareTo(cur.getData())<0){
			
			if (cur.getLeft()==null)
				cur.setLeft(new treeNode(data,null,null));
		
			else
				add(data,cur.getLeft());
		}
		
		else if (data.compareTo(cur.getData())>0){
			
			if (cur.getRight()==null)
				
				cur.setRight(new treeNode(data,null,null));
				
			else 
				
				add(data, cur.getRight());
		}
		else
			
			return;
		
	}
	
	/** 
	 * displayInorder()
	 * a recursive method that displays the elements in order
	 * @pre a tree must have at least one element
	 * @post the list is displayed in order using an ArrayList object  that stored 
	 * the elements in an array of objects
	 * @return ArrayList object 
	 */
	
	public ArrayList displayInorder(){
		
		al = new ArrayList <ComputerParts>();
		
		if (root == null)
			
			System.out.println("tree is empty");
		else
			
			displayInorder(root);
		
		return al;
	}
	
	private void displayInorder(treeNode cur){
		
		if (cur!= null){
			
			displayInorder(cur.getLeft());
			
			al.add(cur.getData());
			
			displayInorder(cur.getRight());
			
		}
		
		
	}
	
	/** 
	 * displayPreOrder()
	 * a recursive method that displays the elements in preorder
	 * @pre a tree must have at least one element
	 * @post the list is displayed in pre order using an ArrayList object  that stored 
	 * the elements in an array of objects
	 * @return ArrayList object 
	 */
	
	public ArrayList displayPreOrder(){
		
		al = new ArrayList <ComputerParts>();
		
		if (root == null)
			
			System.out.println("tree is empty");
		else
			
			displayPreOrder(root);
		return al;
	}	
	
	private void displayPreOrder(treeNode cur){
		
	
		
		if (cur !=null){
		
		al.add(cur.getData());
		
		displayPreOrder(cur.getLeft());
		
		displayPreOrder(cur.getRight());
		}
	}
			
	/** 
	 * displayPostOrder()
	 * a recursive method that displays the elements in postorder 
	 * @pre a tree must have at least one element
	 * @post the list is displayed in order using an ArrayList object  that stored 
	 * the elements in an array of objects
	 * @return ArrayList object 
	 */	
		
public ArrayList displayPostOrder(){
		
		al = new ArrayList <ComputerParts>();
		
		if (root == null)
			
			System.out.println("tree is empty");
		else
			
			displayPostOrder(root);
		return al;
	}	
	
	private void displayPostOrder(treeNode cur){
		
	
		
		if (cur !=null){
		
		
		displayPostOrder(cur.getLeft());
		
		displayPostOrder(cur.getRight());
		
		al.add(cur.getData());
		}
	}
	
	/**
	 * count()
	 * a recursive method that counts the number of members in the binary search tree
	 * 	  @return an integer that present the count of the members of the binary search tree 
	 * or 0 if there are no members in the tree 
	 */
	
	public int count(){
		
		
		return count(root);
	}
	
	private int count (treeNode cur){
		
		if (cur==null)
			return 0;
			
		
		
		
		else
			return 1+ count(cur.getLeft())+ count(cur.getRight());
		
	}
	
	
	/**
	 * searchForIt(ComputerParts part)
	 * a recursive method that search the binary search tree and return a ComputerParts object 
	 * or null if the item is not found
	 * 
	 * 
	 * @param p ComputerParts object
	 * @param cur a treeNode object that points a the root
	 * @return the ComputerParts object or null in not found
	 * @pre  the argument must be of a ComputerParts object
	 * @post a ComputerParts object is returned if found or null if not 
	 *
	 */
	public  ComputerParts searchForIt(ComputerParts part){
		
		
		if(root == null){
			
			return null;
		}
		else 
			return searchForIt(part,root);
		
		
	}
	
	
	
	public ComputerParts searchForIt(ComputerParts p,treeNode cur){
		
		ComputerParts part = null;
		try{
		if (p.Eequals(cur.getData())){
			
			part = cur.getData();
			
			return part ;
		}
		
		
		else if (p.compareTo(cur.getData())<0)
				
			
			return searchForIt(p,cur.getLeft());
		
		else
			return searchForIt(p,cur.getRight());
			
				}
		
		catch (NullPointerException e0){
			
		
			return null;
			}
	}
		/**
		 * depth ()
		 * a recursive method that calculates the depth of a binary search tree 
		 * 
		 * @return a number that present the depth of the tree 
		 * @post return the depth of the tree or -1 if the tree is empty
		 *
		 */
	 public int depth (){
		 
		 int dp=0;
		 
		 if (root == null)
			 
			 return -1;
		 
		 else 
			 
			 return depth(root, dp);
		 
	 }
	 
	 
	 
	 private int depth(treeNode cur, int depth){
		 
		 int leftDepth = depth, rightDepth = depth;
		 
		 if(cur.getLeft() != null)
			 leftDepth = depth(cur.getLeft(), depth+1);
		 
		  if (cur.getRight() != null){
			 
			 rightDepth = depth(cur.getRight(), depth+1);
		 }
			 
		
					 
			 if (leftDepth > rightDepth)
				 
				 return leftDepth;
			 
			 else 
				 return rightDepth;
		 
		 
	 }
		
	
	
	
	
	
	public static void main(String[] args) {
	
		BinarySearchTree myTree = new BinarySearchTree();
		
		ComputerParts l1 = new ComputerParts("A", "INTEL", "I7 2600K", 199.99, 1);
		ComputerParts l2 = new ComputerParts("B", "ASUS", "GTX1080", 500.99, 1);
		ComputerParts l3 = new ComputerParts("C", "CORSAIR", "2X4GB", 69.99, 1);
		ComputerParts l4 = new ComputerParts("D", "INTEL", "500GB", 149.99, 1);
		ComputerParts l7 = new ComputerParts("k", "gg", "500GB", 149.99, 1);
		ComputerParts l8 = new ComputerParts("T", "gg", "500GB", 149.99, 1);
		ComputerParts l9 = new ComputerParts("E", "gg", "500GB", 149.99, 1);
		ComputerParts l0 = new ComputerParts("F", "gg", "500GB", 149.99, 1);
		
		myTree.add(l1);
		
		
		myTree.add(l4);
		
		myTree.add(l7);
		
		myTree.add(l2);
		
		//myTree.add(l9);
		
		//myTree.add(l0);
		
		
		
		
		
		
		ArrayList listToDis = myTree.displayInorder();
		
		ArrayList listToDis2=myTree.displayPreOrder();
		
		ArrayList listToDis3=myTree.displayPostOrder();
		
		/*for (int i=0; i< listToDis3.size();i++)
			
			System.out.println(listToDis3.get(i));*/
		
		System.out.println(myTree.searchForIt(l2));
		
		
		

	}

}
