/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].*/

package my.ds.letcode.essay.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j =i+1; j<nums.length;j++ ){
                if((nums[i]+nums[j]) == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int nums[] = {2,7,11,15};
        int target = 9;

        int result[] = twoSum(nums, target);
        System.out.print("[ ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.print("]");
    }
}
