package ray.liu.algorithm.example.patricia;

import java.util.ArrayList;
import java.util.List;

import ray.liu.algorithm.common.annotation.Uncompleted;

@Uncompleted
public class TrieTree<K extends Comparable<K>> {

	TrieNode<K> root;
	
	public TrieNode<K> put(K k){
		root = put(root, k);
		return root;
	}
	
	private TrieNode<K> put(TrieNode<K> x, K k){
		if(x == null) {
			return new TrieNode(k); 
		}
		
		if(x.children == null) {
			x.children = new ArrayList<>();
			x.children.add(new TrieNode(k));
			return x;
		}
		boolean childrenCheck = false;
		for(TrieNode<K> n : x.children){
			int cmp = k.compareTo(n.k);
			if(cmp == 0){
				childrenCheck = true;
				break;
			}
		}
		
		if(!childrenCheck){
			//add
			x.children.add(new TrieNode(k));
		}
		return x;
	}
	
	public K get(K k){
		if(root == null) {
			return null;
		}
		if(root.k.compareTo(k) ==0) {
			return get(root, k);
		}
		return null;
	}
	
	public K get(TrieNode<K> x, K k){
		if(x == null) {
			return null;
		}
		int cmp = k.compareTo(x.k);
		if(cmp == 0) {
			return k;
		}

		if(x.children == null || x.children.isEmpty()) {
			return null;
		}
		
		for(TrieNode<K> n : x.children){
			K tmp = get(n, k);
			if(tmp != null) {
				return tmp;
			}
		}
		return null;
	}
}
class TrieNode<K extends Comparable<K>> {
	K k;
	List<TrieNode<K>> children; 
	
	public TrieNode(K k) {
		this.k= k;
	}
}