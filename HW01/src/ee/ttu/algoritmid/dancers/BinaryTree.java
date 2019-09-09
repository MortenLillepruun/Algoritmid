package ee.ttu.algoritmid.dancers;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	private Node root = null;
	private List<Dancer> nodes = new ArrayList<Dancer>();
	
	public List<Dancer> getAllDancers() {
		return getAllDancers(root);
	}
	
	private List<Dancer> getAllDancers(Node root){
		if(root!=null){
			getAllDancers(root.getLeft());
			nodes.add(root.getDancer());
			getAllDancers(root.getRight());
			return nodes;
		}
		return null;
	}
	
	public void insertToTree(Node newNode) {
		root = insert(root, newNode);
	}
	
	private Node insert(Node root, Node newNode) {
		if (root == null) {
			return newNode;
		}
		else if (root.getValue() < newNode.getValue()) {
			root.setRight(insert(root.getRight(), newNode));
		}
		else if (root.getValue() > newNode.getValue()) {
			root.setLeft(insert(root.getLeft(), newNode));
		}
		return root;
	}
	
	public Node getFemalePartner(int height) {
		return getFemalePartner(height, root, null);
	}
	
	private Node getFemalePartner(int height, Node root, Node parent) {
		Node partner;
		if (root == null) return null;
		if (root.getValue() == height) {
			partner = root;
			deleteNode(root, parent);
			return partner;
		}
		if (root.getValue() < height && root.getRight() == null) {
			partner = root;
			deleteNode(root, parent);
			return partner;
		}
		
		if (root.getValue() < height && root.getRight() != null) {
			if (root.getRight().getValue() > height && root.getRight().getLeft() == null) {
				partner = root;
				deleteNode(root, parent);
				return partner;
			} else {
				return getFemalePartner(height, root.getRight(), root);
			}
		}
		if (root.getValue() > height && root.getLeft() != null) {
			return getFemalePartner(height, root.getLeft(), root);
		}
		return null;
	}
	
	public Node getMalePartner(int height) {
		return getMalePartner(height, root, null);
	}
	
	private Node getMalePartner(int height, Node root, Node parent) {
		if (root == null) return null;
		Node partner;
		if (root.getValue() == height) {
			partner = root;
			deleteNode(root, parent);
			return partner;
		}
		if (root.getValue() > height && root.getLeft() == null) {
			partner = root;
			deleteNode(root, parent);
			return partner;
		}
		
		if (root.getValue() > height && root.getLeft() != null) {
			if (root.getLeft().getValue() < height && root.getLeft().getRight() == null) {
				partner = root;
				deleteNode(root, parent);
				return partner;
			} else {
				return getMalePartner(height, root.getLeft(), root);
			}
		}
		if (root.getValue() < height && root.getRight() != null) {
			return getMalePartner(height, root.getRight(), root);
		}
		return null;
	}
	
	public void deleteNode(Node node, Node parent) {
		
		if (node == null) { 
			System.err.println("Illegal argument!");
		}
		
		else if (node.getLeft() == null && node.getRight() == null) {
			if (parent == null) {
				root = null;
			}
			
			else if(parent.getLeft() == node) {
	             parent.setLeft(null);               
			} else {
	             parent.setRight(null);
			}
		}
		
		else if (node.getLeft() != null && node.getRight() == null) {
			if (parent == null) {
				root = node.getLeft();
			}
			
			else if(parent.getLeft() == node) {
				parent.setLeft(node.getLeft());
			} else {
				parent.setRight(node.getLeft());
			}
        }

		else if (node.getRight() != null && node.getLeft() == null) {
			if (parent == null) {
				root = node.getRight();
			}
			
			else if(parent.getLeft() == node) {
				parent.setLeft(node.getRight());
			} else {
				parent.setRight(node.getRight());
			}
        }
		
		else if (node.getLeft() != null && node.getRight() != null) {
			Node successor = getSuccessor(node);
			if (parent == null) {
				root = successor;
			}
			
			else if(parent.getLeft() == node) {
				parent.setLeft(successor);
			} else {
				parent.setRight(successor);
			}
			
			successor.setLeft(node.getLeft());
		}
		
		
	}
	
	public Node getSuccessor(Node deleteNode){
		Node successor = null;
		Node successorParent = null;
		Node current = deleteNode.getRight();
		while(current!=null){
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}
		
		if(successor!=deleteNode.getRight()){
			successorParent.setLeft(successor.getRight());
			successor.setRight(deleteNode.getRight());
		}
		return successor;
	}
	
	
}
