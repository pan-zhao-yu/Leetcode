class SnapshotArray {
    private int snapId = 0;
    private final List<List<int[]>> arr;  // 每项是 [snapId, value]

    public SnapshotArray(int length) {
        arr = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{-1, 0});   // 初值：在 snap -1 为 0，便于二分
            arr.add(list);
        }
    }

    public void set(int index, int val) {
        List<int[]> list = arr.get(index);
        int[] last = list.get(list.size() - 1);
        if (last[0] == snapId) {          // 同一快照内多次set：覆盖
            last[1] = val;
        } else {
            list.add(new int[]{snapId, val});
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int target) {
        List<int[]> list = arr.get(index);
        int l = 0, r = list.size() - 1, ans = 0;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (list.get(m)[0] <= target) {
                ans = list.get(m)[1];
                l = m + 1;
            } else r = m - 1;
        }
        return ans;
    }
}
