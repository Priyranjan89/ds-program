/*We are given a list nums of integers representing a list compressed with run-length encoding.

Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.

Return the decompressed list.



Example 1:

Input: nums = [1,2,3,4]
Output: [2,4,4,4]
Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
Example 2:

Input: nums = [1,1,2,3]
Output: [1,3,3]


Constraints:

2 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100*/

package my.ds.letcode.essay.Arrays;

public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        int freq = 0;

        for (int i = 0; i < nums.length; i += 2) {
            freq = freq + nums[i];
        }

        int[] output = new int[freq];
        int index = 0;

        for (int i = 1; i < nums.length; i+=2){
            for (int j =0; j<nums[i-1]; j++){
                output[index] = nums[i];
                index++;
            }
        }

        return output;
    }

    public static void main(String[] args) {

        int nums[] = {1,2,5,6,3,4};
        DecompressRunLengthEncodedList encodedList = new DecompressRunLengthEncodedList();
        int result[] = encodedList.decompressRLElist(nums);

        System.out.print("[ ");
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i]+" ");
        }
        System.out.print("]");
    }
}
