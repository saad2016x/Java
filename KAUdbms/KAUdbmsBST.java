

package kb_1408300_p5;

import java.io.PrintWriter;


public class KAUdbmsBST
 {
    
    private KAUstudent root;

      // CONSTRUCTORS
    public KAUdbmsBST() {
        root = null;
    }
   
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return root == null;
	}
	
	//
	// boolean | search(int)
	//
	public boolean search(int data) {
		return search(root, data);
	}
	//
	// boolean | search(BSTnode, int)
	//
	private boolean search(KAUstudent p, int id) {
		if (p == null)
			return false;
		else {
			// if the data we are searching for is found at p (at the current root)
			if ((id == p.getID()))
				return true;
			else if (id < p.getID())
				return search(p.getLeft(), id);
			else
				return search(p.getRight(), id);
		}
	}
        //
	// BSTnode | findNode(int)
	//
	public KAUstudent findNode(int id) {
		return findNode(root, id);
	}
	//
	// BSTnode | findNode( int)
	//
	private KAUstudent findNode(KAUstudent p, int id) {
		if (p == null)
			return null;
		else {
			// if the data we are searching for is found at p (at the current root)
			if ((id == p.getID()))
				return p;
			else if ((id < p.getID()))
				return findNode(p.getLeft(), id);
			else
				return findNode(p.getRight(), id);
		}
	}
        //
	// BSTnode | findNodename
	//
	public KAUstudent findNodeName(String name) {
		return findNodeName(root, name);
	}
	//
	// BSTnode | findNodename
	//
	private KAUstudent findNodeName(KAUstudent p, String name) {
		if (p == null)
			return null;
		else {
			// if the data we are searching for is found at p (at the current root)
			if (name == p.getFirstName()+" "+p.getLastName())
				return p;
			else if (name.compareTo(p.getFirstName()+" "+p.getLastName()) < 0)
				return findNodeName(p.getLeft(),name);
			else
				return findNodeName(p.getRight(), name);
		}
	}
	 public void printRecords(PrintWriter outpuut){
                        
                    printRecords(root,outpuut);
             
         }
            private void printRecords(KAUstudent p, PrintWriter outpuut) {
        
        if (p != null) { 
            
            
            printRecords(p.getLeft(), outpuut);
            
            
            outpuut.printf("	%d        %-25s%d      %s       ", p.getID(), p.getFirstName(),p.getLastName(), p.getAge(), p.getLevel());
            if (p.getGpa() >= 0) { 
                outpuut.printf("%.2f\r\n", p.getGpa());
            } else {
                outpuut.println(" N/A");
            }
            
            
            printRecords(p.getRight(), outpuut);
        }
    } 
	//
	// void | insert
	//
	public void insert(PrintWriter out,int id,String name,String Email,int AGE,int  phone) {
		KAUstudent newNode;
        newNode = new KAUstudent(id,name,Email,AGE,phone);
		root = insert(root, newNode);
                 out.println("	" + name + " (ID " + id + ") has been inserted as a new student in KAUdbms.");
	}
	//
	// BSTnode | insert(BSTnode, BSTnode)
	//
	private KAUstudent insert(KAUstudent p, KAUstudent newNode) {
		// IF there is no tree, newNode will be the root, so just return it
		if (p == null)
			return newNode;
		
		// ELSE, we have a tree. Insert to the right or the left
		else {
			// Insert to the RIGHT of root
			if (newNode.getID() > p.getID()) {				
				// Recursively insert into the right subtree
				// The result of insertion is an updated root of the right subtree
				KAUstudent temp = insert(p.getRight(), newNode);
				// Save this newly updated root of right subtree into p.right
				p.setRight(temp);
			}
			// Insert to the LEFT of root
			else {				
				// Recursively insert into the left subtree
				// The result of insertion is an updated root of the left subtree
				KAUstudent temp = insert(p.getLeft(), newNode);
				// Save this newly updated root of left subtree into p.left
				p.setLeft(temp);
			}
		}
		// Return root of updated tree
		return p;
	}     
                    
                    
                    
                    //
	// void | delete(int)
	//
	public void delete(String name) {
		root = delete(root, name);
	}
	//
	// BSTnode | delete(BSTnode, int)
	//
	private KAUstudent delete(KAUstudent p,String name) {
		KAUstudent node2delete, newnode2delete, node2save, parent;
		int saveValue;
		
		// Step 1: Find the node we want to delete
		node2delete = findNodeName(p, name);
		// If node is not found (does not exist in tree), we clearly cannot delete it.
		if (node2delete == null)
			return root;
		
		// Step 2: Find the parent of the node we want to delete
		parent = parent(p, node2delete);
		
		// Step 3: Perform Deletion based on three possibilities
		
		// **1** :  node2delete is a leaf node
		if (isLeaf(node2delete)) {
			// if parent is null, this means that node2delete is the ONLY node in the tree
			if (parent == null)
				return null; // we return null as the updated root of the tree
			
			// Delete node if it is a left child
			if (node2delete.getID() < parent.getID())
				parent.setLeft(null);
			// Delete node if it is a right child
			else
				parent.setRight(null);
			
			// Finally, return the root of the tree (in case the root got updated)
			return p;
		}
		
		// **2** : node2delete has only a left child
		if (hasOnlyLeftChild(node2delete)) {
			// if node2delete is the root
			if (parent == null)
				return node2delete.getLeft();
			
			// If node2delete is not the root,
			// it must the left OR the right child of some node
			
			// IF it is the left child of some node
			if (node2delete.getID() < parent.getID())
				parent.setLeft(parent.getLeft().getLeft());
			// ELSE it is the right child of some node
			else
				parent.setRight(parent.getRight().getLeft());
			
			// Finally, return the root of the tree (in case the root got updated)
			return p;
		}
		
		// **3** :  node2delete has only a right child
		if (hasOnlyRightChild(node2delete)) {
			// if node2delete is the root
			if (parent == null)
				return node2delete.getRight();
			
			// If node2delete is not the root,
			// it must the left OR the right child of some node
			
			// IF it is the left child of some node
			if (node2delete.getID() < parent.getID())
				parent.setLeft(parent.getLeft().getRight());
			// ELSE it is the right child of some node
			else
				parent.setRight(parent.getRight().getRight());
			
			// Finally, return the root of the tree (in case the root got updated)
			return p;
		}
		
		// **4** :  node2delete has TWO children.
		// Remember, we have two choices: the minVal from the right subtree (of the deleted node)
		// or the maxVal from the left subtree (of the deleted node)
		// We choose to find the minVal from the right subtree.
		newnode2delete = minNode(node2delete.getRight());
		// Now we need to temporarily save the data value(s) from this node
		node2save = newnode2delete ;
		
		// Now, we recursively call our delete method to actually delete this node that we just copied the data from
		p = delete(p,newnode2delete.name);
		
		// Now, put the saved data (in saveValue) into the correct place (the original node we wanted to delete)
		node2delete.setalldata(node2save);
		
		// Finally, return the root of the tree (in case the root got updated)
		return p;
	}
    
 //
    // BSTnode | minNode(BSTnode)
    //
    public KAUstudent minNode(KAUstudent root) {
        if (root == null) {
            return null;
        }
        else {
            if (root.getLeft() == null) {
                return root;
            }
            else {
                return minNode(root.getLeft());
            }
        }
    }

        //
	// BSTnode | parent(BSTnode)
	//
	public KAUstudent parent(KAUstudent p) {
		return parent(root, p);
	}
	//
	// BSTnode | parent(BSTnode, BSTnode)
	//
	private KAUstudent parent(KAUstudent root, KAUstudent p) {
		// Take care of NULL cases
		if (root == null || root == p)
			return null; // because there is on parent
		
		// If root is the actual parent of node p
		if (root.getLeft()==p || root.getRight()==p)
			return root; // because root is the parent of p
		
		// Look for p's parent in the left side of root
		if (p.getID() < root.getID())
			return parent(root.getLeft(), p);
		
		// Look for p's parent in the right side of root
		else if (p.getID()> root.getID())
			return parent(root.getRight(), p);
		
		// Take care of any other cases
		else
			return null;
	}         
                    //
	// boolean | isLeaf(BSTnode)
	//
	public boolean isLeaf(KAUstudent p) {
		return (p.getLeft()==null && p.getRight()==null);
	}
	
	
	//
	// boolean | hasOnlyLeftChild(BSTnode)
	//
	public boolean hasOnlyLeftChild(KAUstudent p) {
		return (p.getLeft()!=null && p.getRight()==null);
	}
	
	
	//
	// boolean | hasOnlyRightChild(BSTnode)
	//
	public boolean hasOnlyRightChild(KAUstudent p) {
		return (p.getLeft()==null && p.getRight()!=null);
	}

  
   

}
