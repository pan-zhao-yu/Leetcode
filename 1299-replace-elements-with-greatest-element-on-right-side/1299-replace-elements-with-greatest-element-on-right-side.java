class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int n = arr.length;
        int a;
        for(int i = n - 1; i >= 0; --i){
            a = arr[i];
            arr[i] = max;
            max = Math.max(max, a);
        }
        return arr;
    }
}

