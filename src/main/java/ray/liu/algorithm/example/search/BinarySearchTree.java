package ray.liu.algorithm.example.search;

public class BinarySearchTree<K extends Comparable<K>,V> {
	
	private Node root;
	
	private class Node {
		private K k;
		private V v;
		private Node left, right;
		private int n;
		
		public Node(K k, V v, int n){
			this.k = k;
			this.v = v;
			this.n = n;
		}
		
		public void printNode(){
			if(this.left != null) {
				left.printNode();
			}
			System.out.print(v + " ");
			if(this.right != null) {
				right.printNode();
			}
		}
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(Node x){
		return x != null ? x.n : 0;
	}
	
	public V get(K k){
		return get(root, k);
	}
	public V getNoRec(K k){
		return getNoRec(root, k);
	}
	
	private V get(Node x, K k){
		if(x == null){
			return null;
		}
		int cmp = k.compareTo(x.k);
		if(cmp < 0 ) {
			return get(x.left, k);
		} else if (cmp > 0) {
			return get(x.right, k);
		} else {
			return x.v;
		}
	}
	
	private V getNoRec(Node x, K k){
		while(x !=null){
			int cmp = k.compareTo(x.k);
			if(cmp < 0 ) {
				x = x.left;
			} else if (cmp > 0) {
				x = x.right;
			} else {
				return x.v;
			}
		}
		return null;
	}
	
	public void put(K k, V v){
		root = put(root, k , v);
	}
	
	public Node put(Node x, K k ,V v){
		if(x == null){
			return new Node(k, v, 1);
		}
		int cmp = k.compareTo(x.k);
		if(cmp < 0) {
			x.left = put(x.left,k, v);
		}else if(cmp > 0){
			x.right = put(x.right, k, v);
		} else {
			x.v = v;
		}
		x.n = size(x.left) + size(x.right);
		return x;
	}
	
	
	public String printMidFirst(){
		Node x = this.root;
		if(x == null){
			return "null";
		}
		StringBuilder sb = new StringBuilder();
		while(x != null) {
			if(x.left != null){
				x = x.left;
			} else if(x.right != null) {
				x = x.right;
			} else {
				sb.append(x.v + " ");
			}
			System.out.println("--> " + x.v + " <--- " + sb.toString());
		}
		return sb.toString();
	}
	
	public void print(){
		Node x = this.root;
		if(x == null){
			System.out.println("null");
		}
		
		x.printNode();
	}
	
	public static void main(String[] args) {
		String str = "RENRENDAI";
		char[] cs = str.toCharArray();
		BinarySearchTree<String, String> bst = new BinarySearchTree<>();
		for(char c : cs){
			bst.put(String.valueOf(c), String.valueOf(c));
		}
//		bst.printMidFirst();
		bst.print();
		System.out.println("done");
	}
}
