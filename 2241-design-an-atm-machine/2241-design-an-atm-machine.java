class ATM {
    private Map<Integer, Integer> balance;
    private final int[] denominations;

    public ATM() {
        balance = new HashMap<>();
        denominations = new int[]{20, 50, 100, 200, 500};
        for (int denom : denominations) {
            balance.put(denom, 0);
        }
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            int denom = denominations[i];
            balance.put(denom, balance.getOrDefault(denom, 0) + banknotesCount[i]);
        }
    }

    public int[] withdraw(int amount) {
        int[] res = new int[5];
        Map<Integer, Integer> tempBalance = new HashMap<>(balance);

        for (int i = denominations.length - 1; i >= 0; i--) {
            int denom = denominations[i];
            int availableNotes = tempBalance.getOrDefault(denom, 0);
            int neededNotes = amount / denom;
            int usedNotes = Math.min(neededNotes, availableNotes);
            res[i] = usedNotes;
            amount -= usedNotes * denom;
            tempBalance.put(denom, availableNotes - usedNotes);
        }

        if (amount == 0) {
            balance = tempBalance;
            return res;
        } else {
            return new int[]{-1};
        }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */