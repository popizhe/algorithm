package ray.liu.algorithm.lee.algorithm.medium;

public class SingleNonDuplicate {
	public int singleNonDuplicate(int[] nums) {
		int length = nums.length % 2 == 0 ? nums.length : nums.length -1;
		for(int i = 0; i < length; i+=2){
			if(nums[i] != nums[i+1]){
				return nums[i];
			}
		}
		return nums[nums.length-1];
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,1,2,3,3,4,4,8,8};
		int[] nums2 = {3,3,7,7,10,11,11};
		int[] nums3 = {1};
		SingleNonDuplicate s = new SingleNonDuplicate();
		System.out.println(s.singleNonDuplicate(nums1));
		System.out.println(s.singleNonDuplicate(nums2));
		System.out.println(s.singleNonDuplicate(nums3));
		
	}
}
