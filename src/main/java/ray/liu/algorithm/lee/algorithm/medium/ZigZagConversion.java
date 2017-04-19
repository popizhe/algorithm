package ray.liu.algorithm.lee.algorithm.medium;

public class ZigZagConversion {


	public String convert(String s, int n) {
		if(n < 2) {
			return s;
		}
		if(s == null || s.isEmpty()){
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		int loop = n * 2 -2;
		int loop2 = n-1;
		for(int i = 0 ; i < n; i++){
			if(i == 0 || i == n -1){
				for(int j = i ; j < len; j+=loop){
					sb.append(s.charAt(j));
				}
			}else {
				for(int j = i ; j < len; j+=loop2){
					sb.append(s.charAt(j));
				}
			}
		}
		return sb.toString();
	}

	// x = 0 , m = 0 , y = n
	// x = 1 , m = 1 , y = n - m*2



	private int rowRoll(int row, int numRows){
		if(row >= numRows) {
			return 0;
		}
		int tmp = row;
		if(tmp +1 >= numRows) {
			return 0;
		}
		row++;
		return row;
	}

	private boolean contains(String[] strs , String x,int start, int mass) {
		for(int i = 1+ start ; i < strs.length ; i+= mass) {
			if(strs[i].equals(x)){
				return true;
			}
		}
		return false;
	}

	public String print(String[] strs) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(String s : strs) {
			if(s != null) {
				sb.append(s);
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion z= new ZigZagConversion();
		String s = z.convert("PAYPALISHIRING", 3);
		System.out.println(s);
		s = z.convert("A", 1);
		System.out.println(s);
		s = z.convert("ABC", 2);
		System.out.println(s);
		s = z.convert("AB", 4);
		System.out.println(s);
		s = z.convert("ABCDE", 4);
		System.out.println(s);
	}
}
