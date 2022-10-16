package org.example;

/**
 * @author Brian Su <memory0318@gmail.com>
 * @description:
 * @date: 2022/10/16
 */
public class ProductCalculator {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int productFromLeft = 1;
        for (int idx = 0; idx < nums.length; ++idx) {
            result[idx] = productFromLeft;
            productFromLeft *= nums[idx];
        }

        int productFromRight = 1;
        for (int idx = nums.length - 1; idx >= 0; --idx) {
            result[idx] *= productFromRight;
            productFromRight *= nums[idx];
        }

        return result;
    }
}
