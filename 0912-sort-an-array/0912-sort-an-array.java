class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void mergeSort(int[] nums, int low, int high){
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }
    
    private void merge(int[] nums, int low, int mid, int high){
        int[] temp = new int[nums.length];
        int left = low;
        int right = mid + 1;
        int index = low;

        while(left <= mid && right <= high){
            if(nums[left] < nums[right]){
                temp[index++] = nums[left++];
            }else{
                temp[index++] = nums[right++];
            }
        }
        
        while(left <= mid){
            temp[index++] = nums[left++];
        }
        
        while(right <= high){
            temp[index++] = nums[right++];
        }

        for(int i = low; i <= high; i++){
            nums[i] = temp[i];
        }
    }
}
