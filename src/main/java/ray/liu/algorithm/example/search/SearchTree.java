package ray.liu.algorithm.example.search;

public interface SearchTree <K,V> {
	void put(K k , V v);
	
	V get(K k);
	
	void delete(K k);
	
	boolean contains(K k);
	
	boolean isEmpty();
	
	int size();
	
	Iterable<K> keys();
}
