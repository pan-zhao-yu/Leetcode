// class Solution {
//     public int[] sortArray(int[] nums) {
//         mergeSort(nums, 0, nums.length - 1);
//         return nums;
//     }
    
//     private void mergeSort(int[] nums, int low, int high){
//         if(low >= high) return;
//         int mid = low + (high - low) / 2;
//         mergeSort(nums, low, mid);
//         mergeSort(nums, mid + 1, high);
//         merge(nums, low, mid, high);
//     }
    
//     private void merge(int[] nums, int low, int mid, int high){
//         ArrayList<Integer> arr = new ArrayList<>();
//         int left = low;
//         int right = mid + 1;
//         while(low <= mid && right <= high){
//             if(nums[left] <= nums[right]){
//                 arr.add(nums[left]);
//                 left++;
//             }else{
//                 arr.add(nums[right]);
//                 right++;
//             }
//         }
//         while(left <= mid){
//             arr.add(nums[left]);
//             left++;
//         }
//         while(right <= high){
//             arr.add(nums[right]);
//             right++;
//         }
//         for(int i = low; i <= high; i++){
//             nums[i] = arr.get(i - low);
//         }
//     }
// }

class Solution {
    //Using Merge Sort
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    public void mergeSort(int []arr, int low, int high){
        if(low >= high) return;

        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, high, mid);
    }
    public void merge(int []arr, int low, int high, int mid){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low; i<= high; i++){
            arr[i] = temp.get(i-low);
        }
    }
}
