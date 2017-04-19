package ray.liu.algorithm.lee.algorithm.hard;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int m = nums1.length;
    	int n = nums2.length;
    	double pos1 = ((m+n-1) >>1) +1;
    	double pos2 = (m+n-1)%2 ==0 ? pos1 : pos1 +1 ;
    	int tag1 = 0;
    	int tag2 = 0;
    	int target1 = 0;
    	int target2 = 0;
    	while(true){   
    		if(tag1 > m -1){
    			target1 = nums2[tag2]; 
    			tag2++;
    		} else if (tag2 > n-1) {
    			target1 = nums1[tag1]; 
    			tag1++;
    		}else if(nums1[tag1] < nums2[tag2]) {
    			target1 = nums1[tag1]; 
    			tag1++;
    		}else {
    			target1 = nums2[tag2]; 
    			tag2++;
    		}
    		if(tag1 + tag2 == pos1){
    			target2 = target1;
    			if(pos1 == pos2) {
    				break;
    			}
    		} else if (tag1 + tag2 == pos2){
    			break;
    		}
    	}
    	return ((double)target1 + (double)target2) / 2;
    }
    
    public static void main(String[] args) {
		MedianofTwoSortedArrays ex = new MedianofTwoSortedArrays();
		int[] ns1 = new int[]{1,3};
		int[] ns2 = new int[]{2};
		int[] ns3 = new int[]{1,2};
		int[] ns4 = new int[]{3,4};
		int[] ns5 = new int[]{1,3};
		int[] ns6 = new int[]{};
		System.out.println("====");
		ex.findMedianSortedArrays(ns1, ns2);
		System.out.println("====");
		
		long start = System.currentTimeMillis();
		int i = 10000;
		while(i-- > 0){
			ex.findMedianSortedArrays(ns3, ns4);
		}
		System.out.println(start - System.currentTimeMillis());
		
		System.out.println("====");
		ex.findMedianSortedArrays(ns5, ns6);
		
		
	}
}