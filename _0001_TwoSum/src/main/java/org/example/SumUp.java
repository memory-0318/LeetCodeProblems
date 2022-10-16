package org.example;

/**
 * @author Brian Su <memory0318@gmail.com>
 * @description:
 * @date: 2022/10/16
 */
public class SumUp {
    public int[] twoSum(int[] nums, int target) {
        int[] resultIdxArray = null;

        boolean found = false;
        for (int fixedIdx = 0; fixedIdx < nums.length && !found; ++fixedIdx) {
            for (int scanPtrIdx = fixedIdx + 1; scanPtrIdx < nums.length && !found; ++scanPtrIdx) {
                if (nums[fixedIdx] + nums[scanPtrIdx] == target) {
                    resultIdxArray = new int[] { fixedIdx, scanPtrIdx };
                    break;
                }
            }
        }

        return resultIdxArray;
    }
}
