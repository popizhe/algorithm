package ray.liu.algorithm.lee.algorithm.medium;

public class LongestPalindrome {


	public String longestPalindrome(String s) {
		int maxL = 0, lo = 0, hi=0;
		int len = s.length();
		if(s == null || s.isEmpty()){
			return null;
		}
		if(len < 2) { //s.length == 1
			return s;
		}

		for(int i = 0 ; i < len && len-i > maxL; i++) {
			int head = i;
			int tail = i;
			while(head >=0 &&tail < len && s.charAt(head) == s.charAt(tail)){
				head--;tail++;
			}
			if(maxL < tail - head -1 ){
				lo = head + 1;
				hi = tail;
				maxL = tail - head -1;
			}
			head = i;
			tail = i+1;
			while(head >=0 && tail < len && s.charAt(head) == s.charAt(tail)){
				head--;tail++;
			}
			if(maxL < tail - head -1 ){
				lo = head + 1;
				hi = tail;
				maxL = tail - head -1;
			}

		}

		return s.substring(lo, hi);
	}


	public static void main(String[] args) {
		LongestPalindrome l = new LongestPalindrome();
		String s = "asldijfibablksjgklaj";
		String result = l.longestPalindrome(s);
		System.out.println(result);
	}
}
