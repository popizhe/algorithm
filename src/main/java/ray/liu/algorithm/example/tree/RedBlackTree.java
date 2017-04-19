package ray.liu.algorithm.example.tree;

public class RedBlackTree<K extends Comparable<K> , V> {

	private RBTNode root;
	
	
	public void put(K k, V v){
		root = put(root, k, v);
		root.color = 1;
	}

	
	public RBTNode<K, V> put(RBTNode<K, V> x, K k, V v){
		System.out.println("---> putting " + k);
		if(x == null){
			return new RBTNode<K, V>(k, 0, null, null, null, v);
		}
		int cmp = k.compareTo(x.k);
		if(cmp < 0) {
			// left
			x.left = put(x.left, k, v);
		}else if(cmp > 0) {
			// right
			x.right = put(x.right, k, v);
		} else {
			//set value
			x.v = v;
		}
		
		// check 1
		if(isRed(x.right) && !isRed(x.left)) {
			// rotate left
			System.out.println(" rotate left --> " + x.k);
			x = rotateLeft(x);
		}
		
		if(isRed(x.left) && isRed(x.left.left)) {
			// rotate right
			System.out.println(" rotate right --> " + x.k);
			x = rotateRight(x);
		}
		
		if(isRed(x.left) && isRed(x.right)) {
			flipColors(x);
		}
		return x;
	}
	
	public RBTNode<K, V> rotateLeft(RBTNode<K, V> x){
		RBTNode<K, V> tmp = x.right;
		x.right = tmp.left;
		tmp.left = x;
		tmp.color = x.color;
		x.color = 0; //red
		return tmp;
	}
	public RBTNode<K, V> rotateRight(RBTNode<K, V> x){
		RBTNode<K, V> tmp = x.left;
		x.left = tmp.right;
		tmp.right = x;
		tmp.color = x.color;
		x.color = 0; //red
		return tmp;
	}
	
	void flipColors(RBTNode<K, V> x){
		x.color = 0; // red
		x.left.color = 1;
		x.right.color =1;
	}
	
	private boolean isRed(RBTNode x){
		return x == null ? false : x.color == 0;
	}
	

	public void rotateLeftv2(RBTNode<K, V> x){
		// 设置x的右孩子为y
	    RBTNode<K, V> y = x.right;
	    // 将 “y的左孩子” 设为 “x的右孩子”；
	    // 如果y的左孩子非空，将 “x” 设为 “y的左孩子的父亲”
	    x.right = y.left;
	    if (y.left != null)
	        y.left.parent = x;
	    // 将 “x的父亲” 设为 “y的父亲”
	    y.parent = x.parent;
	    if (x.parent == null) { // x is root
	        this.root = y;            // 如果 “x的父亲” 是空节点，则将y设为根节点
	    } else {
	        if (x.parent.left == x)
	            x.parent.left = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
	        else
	            x.parent.right = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
	    }
	    
	    // 将 “x” 设为 “y的左孩子”
	    y.left = x;
	    // 将 “x的父节点” 设为 “y”
	    x.parent = y;
	}
	
	
	
	public static void main(String[] args) {
		RedBlackTree<String, String> rbt = new RedBlackTree<>();
		String str = "REDBLACKTREEEXAMPLE";
		for(char c : str.toCharArray()){
			String k = String.valueOf(c); 
//			rbt.put(new RBTNode<String, String>(k, 0, null, null, null, k), k, k);
			rbt.put(k, k);
		}
		System.out.println("======");
		rbt.root.printNode();
		System.out.println("done");
	}
}
class RBTNode<K , V > {
	int color;	//o = red , 1 = black
	K k;
	RBTNode left;
	RBTNode right;
	RBTNode parent;
	V v;
	
	public RBTNode(K k, int color, RBTNode left, RBTNode right, RBTNode parent, V v){
		this.k = k;
		this.color = color;
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.v = v;
	}
	
	public void printNode(){
		if(this.left != null) {
			left.printNode();
		}
		System.out.print(" [" + k + " : " + color + "]");
		if(this.right != null) {
			right.printNode();
		}
	}
	
	public String toString(){
		return String.valueOf(k + "-" + color);
	}
}