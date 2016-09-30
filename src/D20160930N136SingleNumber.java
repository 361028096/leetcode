/*

*1.for的遍历
*2.注意数组长度for(int i=0;i<nums.length;i++)
*
*/

public class D20160930N136SingleNumber {
	public static void main(String args[]) {
		int[] nums = { 1, 1, 2, 2, 3 };
		System.err.println(nums.length);
		D20160930N136SingleNumber a = new D20160930N136SingleNumber();
		System.out.println(a.singleNumber(nums));
	}

	int singleNumber(int[] nums) {
		int result = 0;
		for (int i : nums)
			result ^= i;
		/*
		 * for(int i=0;i<nums.length;i++) result ^=nums[i];
		 */
		return result;
	}
}
