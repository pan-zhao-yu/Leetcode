class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        long sumH = 0, sumV = 0;
        long res = 0;
        for(int h : horizontalCut){
            sumH += h;
        }
        for(int v : verticalCut){
            sumV += v;
        }
        int h = horizontalCut.length - 1, v = verticalCut.length - 1;
        while(h >= 0 && v >= 0){
            if(horizontalCut[h] > verticalCut[v]){
                res += horizontalCut[h] + sumV;
                sumH -= horizontalCut[h];
                h--;
            }else{
                res += verticalCut[v] + sumH;
                sumV -= verticalCut[v];
                v--;
            }
        }
        return res + sumH + sumV;
    }
}