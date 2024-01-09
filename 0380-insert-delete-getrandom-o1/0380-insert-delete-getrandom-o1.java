public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement); // Move the last element to the 'deleted' position
        map.put(lastElement, index);
        list.remove(list.size() - 1); // Remove the last element
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
