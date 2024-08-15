class Solution {

    public int maxProfit(int k, int[] prices) {

        //定义dp数组

        //设置为2k+1种状态  若遍历时 %2=1 说明是购入 若%2=0说明是卖出

        int[][] dp = new int[prices.length][2*k+1];

        //初始化

        for(int i=1;i<2*k+1;i++){

            if(i%2==1){

                dp[0][i] = -prices[0];

            }else{

                dp[0][i] = 0;

            }

        }

        for(int i=1;i<prices.length;i++){

            for(int j=1;j<2*k+1;j++){

                //说明是购入 有可能是上一次购入 或者是这次购入

                if(j%2==1){

                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]-prices[i]);

                }else{

                    //说明是卖出

                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]+prices[i]);

                }

            }

        }

        return dp[dp.length-1][2*k];

    }

}