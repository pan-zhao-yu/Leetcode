class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;
        int left = 0;
        int right = nums1.length;
        double res = 0.0;
        while(left <= right){
            int i = left + (right - left) / 2; //partition index for nums1
            int j =  half - i; //index for nums2
            int left1 = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int left2 = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
            if(left1 <= right2 && left2 <= right1){// partition is correct
                if(total % 2 == 0){
                    int n1 = Math.max(left1, left2);
                    int n2 = Math.min(right1, right2);
                    res = (n1 + n2) / 2.0;
                }else{
                    res = Math.max(left1, left2);
                }
                return res;
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