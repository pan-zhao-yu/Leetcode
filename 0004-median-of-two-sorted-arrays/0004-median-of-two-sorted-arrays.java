class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int totalLen = nums1.length + nums2.length;
        int half = (totalLen + 1) / 2;
        int left = 0, right = nums1.length;
        double res = 0.0;
        while(left <= right){
            int mid1 = left + (right - left) / 2;
            int mid2 = half - mid1;
            int left1 = mid1 <= 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int right1 = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];
            int left2 = mid2 <= 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int right2 = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];
            if(left1 <= right2 && left2 <= right1){
                if(totalLen % 2 == 0){
                    int resLeft = Math.max(left1, left2);
                    int resRight = Math.min(right1, right2);
                    res = (resLeft + resRight) / 2.0;
                    return res;
                }else{
                    return Math.max(left1, left2);
                }
            }else{
                if(left1 > right2){
                    right = mid1 - 1;
                }else{
                    left = mid1 + 1;
                }
            }
        }
        return res;
    }
}