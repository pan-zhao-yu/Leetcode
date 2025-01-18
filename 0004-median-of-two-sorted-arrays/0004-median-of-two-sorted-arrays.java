class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;
        int left = 0;
        int right = nums1.length;
        double res = 0.0;

        while(left <= right){
            int i = left + (right - left) / 2;
            int j = half - i;

            int left1 = i <= 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = i >= nums1.length ? Integer.MAX_VALUE : nums1[i];
            int left2 = j <= 0 ? Integer.MIN_VALUE :nums2[j - 1];
            int right2 = j >= nums2.length ? Integer.MAX_VALUE : nums2[j];

            if(left1 <= right2 && left2 <= right1){
                if(total % 2 == 0){
                    int n1 = Math.max(left1, left2);
                    int n2 = Math.min(right1, right2);
                    res = (n1 + n2) / 2.0;
                    return res;
                }else{
                    return Math.max(left1, left2);
                }
            }else{
                if(left1 > right2){
                    right = i - 1;
                }else{
                    left = i + 1;
                }
            }
        }
        return res;
    }
}