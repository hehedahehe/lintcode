package arraysplit;

import java.util.Arrays;

public class Solution {

    /**
     * @param nums: an array
     * @return: the sum of min(ai, bi) for all i from 1 to n
     * 基本思想 让数值小的聚集到一起，从而让小数值尽量发生在小的范围内。
     * 这里可以尝试给出严格的数学证明。
     */
    public int arrayPairSum(int[] nums) {
        // Write your code here
        Arrays.sort(nums);
        int l = nums.length - 1;
        int sum = 0;
        for (int i = 0; i < l; ) {
            int p1 = nums[i];
            int p2 = nums[i + 1];
            System.out.printf("p1 %d - p2 %d", p1, p2);
            System.out.println();
            sum += Math.min(p1, p2);
            i += 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(new Solution().arrayPairSum(nums));
    }

}
