package com.games.LeetCode.Problems.MedianTwoSortedArrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int elementsCount = nums1.length + nums2.length;
        int[] combinedArray = combineArrays(nums1, nums2);
        int middleIndex = elementsCount / 2;
        if (elementsCount % 2 == 0) {
            return ((double)combinedArray[middleIndex-1] + (double)combinedArray[middleIndex]) / 2;
        } else {
            return combinedArray[middleIndex];
        }
    }

    public int[] combineArrays(int[] nums1, int[] nums2) {
        int elementsCount = nums1.length + nums2.length;
        int[] nums3 = new int[elementsCount];
        int iteratorIn1 = 0, iteratorIn2 = 0, iteratorIn3 = 0;
        while (iteratorIn1 < nums1.length && iteratorIn2 < nums2.length) {
            if (nums1[iteratorIn1] < nums2[iteratorIn2])
                nums3[iteratorIn3++] = nums1[iteratorIn1++];
            else
                nums3[iteratorIn3++] = nums2[iteratorIn2++];
        }
        while (iteratorIn1 < nums1.length)
            nums3[iteratorIn3++] = nums1[iteratorIn1++];
        while (iteratorIn2 < nums2.length)
            nums3[iteratorIn3++] = nums2[iteratorIn2++];
        return nums3;
    }
}
