package ray.liu.algorithm.example.patricia;

import java.util.HashMap;
import java.util.Map;

import ray.liu.algorithm.common.annotation.Uncompleted;
@Uncompleted
public class T9 {
	public final static Map<Integer, String[]> map = new HashMap();
	static {
		map.put(2, new String[]{"a" , "b", "c"});
		map.put(3, new String[]{"d" , "e", "f"});
		map.put(4, new String[]{"g" , "h", "i"});
		map.put(5, new String[]{"j" , "k", "l"});
		map.put(6, new String[]{"m" , "n", "o"});
		map.put(7, new String[]{"p" , "q", "r", "s"});
		map.put(8, new String[]{"t" , "u", "v"});
		map.put(9, new String[]{"w" , "x", "y", "z"});
	}
	
	
	

	
	
	public static void main(String[] args) {
		T9 t9 = new T9();
		TrieTree<String> th = new TrieTree<>();
		TrieTree<String> ta = new TrieTree<>();
		String word1 = "home";
		String word2 = "amazon";
		for(char c : word1.toCharArray()) {
			String s = String.valueOf(c);
			th.put(s);
		}
		for(char c : word2.toCharArray()) {
			String s = String.valueOf(c);
			ta.put(s);
		}
		
		int[] inputting = {4,6,6,3};
		StringBuilder sb = new StringBuilder();
		for(int i : inputting){
			String[] strs = map.get(i);
			for(String s : strs) {
				String r = th.get(s);
					System.out.println("---> " + s + " tested!");
				if(r == null) {
//					break;
					continue;
				}
				sb.append(r);
			}
		}
		System.out.println(sb.toString());
		System.out.println("done");
	}
}
