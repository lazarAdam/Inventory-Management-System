

public class treeNode {

	private ComputerParts data;
	private treeNode left;
	private treeNode right;
	
	
	public treeNode (ComputerParts d, treeNode l,treeNode r){
		
		this.data=d;
		this.left = l;
		this.right = r;
		
	}


	public ComputerParts getData() {
		return data;
	}


	public void setData(ComputerParts data) {
		this.data = data;
	}


	public treeNode getLeft() {
		return left;
	}


	public void setLeft(treeNode left) {
		this.left = left;
	}
	



	public treeNode getRight() {
		return right;
	}


	public void setRight(treeNode right) {
		this.right = right;
	}

	public boolean isLeaf(){
		
		
	if((left== null) &&(right==null))
		
		return true;
	
	else return false;
		
		
		
	}
}

