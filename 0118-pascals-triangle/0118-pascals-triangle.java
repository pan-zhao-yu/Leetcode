// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//         List<List<Integer>> result = new ArrayList<>();
//         if(numRows <= 0) return result;
//         result.add(Arrays.asList(1));
//         for(int i = 1; i < numRows; i++){
//             List<Integer> row = new ArrayList<>();
//             List<Integer> prevRow = result.get(i - 1);
//             row.add(1);
//             for(int j = 1; j < i; j++){
//                 row.add(prevRow.get(j - 1) + prevRow.get(j));
//             }
//             row.add(1);
//             result.add(row);
//         }
//         return result;
//     }
// }

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<numRows; i++){
            List<Integer> list = new ArrayList<>();
            
            for(int j=0; j<=i; j++){
                if(j>0 && i>0 && res.get(i-1).size()-1>=j){
                    list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                } else{
                    list.add(1);
                }
            }
            res.add(list);
        }
        
        return res;
        
    }
}