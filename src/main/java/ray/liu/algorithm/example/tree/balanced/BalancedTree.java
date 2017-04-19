package ray.liu.algorithm.example.tree.balanced;

import java.util.ArrayList;
import java.util.List;

public class BalancedTree<T extends Comparable<T>> {
	BTNode root;
	
	public void put(BTNode<T> x, T k){
//		if(root == null) {
//			root = new BTNode<T>(t);
//			return;
//		}
		// 1 empty check
		if(x.children == null || x.children.isEmpty()){
			//TODO
		}
		// 2 find
		T tmp;
		for(BTNode n : x.children){
			int cmp = k.compareTo((T) n.t);
			if(cmp == 0){ //exsit
				return ; 
			} else if(cmp < 0) {
				
			}
		}
		
		
	}
}

class BTNode<T extends Comparable<T>>{
	private final static int MAX_CAPACITY = 5;
//	boolean isRoot = false;
	List<BTNode> children = new ArrayList<>(MAX_CAPACITY);
	T t;

	public BTNode(T t){
		this.t= t;
	}
}