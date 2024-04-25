class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitCounts = new HashMap<>();
        int maxFruits = 0;
        int left = 0;
        int right = 0;
        for(right = 0; right < fruits.length; right++){
            fruitCounts.put(fruits[right], fruitCounts.getOrDefault(fruits[right], 0) + 1);
            
            while(fruitCounts.size() > 2){
                fruitCounts.put(fruits[left], fruitCounts.get(fruits[left]) - 1);
                if(fruitCounts.get(fruits[left]) == 0){
                    fruitCounts.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
}