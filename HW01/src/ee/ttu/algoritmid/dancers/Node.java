package ee.ttu.algoritmid.dancers;

public class Node 
{
    private Dancer dancer;
	private int value;
    private Node left;
    private Node right;

    public Node(Dancer d) {
    	this.dancer = d;
    	this.value = d.getHeight();
        this.left = null;
        this.right = null;
    }
    
    public void setDancer(Dancer d) {
    	this.dancer = d;
    	this.value = d.getHeight();
    }
    
    public Dancer getDancer() {
    	return dancer;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int _value)
    {
    	if (_value < 0 ) {
    		this.value = -1;
    	} else {
    		this.value = _value;
    	}
    }

    public Node getLeft()
    {
        return left;
    }

    public void setLeft(Node _left)
    {
        this.left = _left;
    }

    public Node getRight()
    {
        return right;
    }

    public void setRight(Node _right)
    {
        this.right = _right;
    }  
}
