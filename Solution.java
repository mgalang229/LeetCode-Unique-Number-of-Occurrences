class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int max = 0;
        for (int x : arr) {
            max = Math.max(max, Math.abs(x));
        }
        int[] positive = new int[max+1], negative = new int[max+1];
        Arrays.fill(positive, 0);
        Arrays.fill(negative, 0);
        for (int x : arr) {
            if (x > 0) {
                positive[x]++;
            }
            if (x < 0) {
                negative[Math.abs(x)]++;
            }
        }
        int[] counter = new int[arr.length+1];
        Arrays.fill(counter, 0);
        for (int x : positive) {
            if (x == 0) {
                continue;
            }
            counter[x]++;
            if (counter[x] > 1) {
                return false;
            }
        }
        for (int x : negative) {
            if (x == 0) {
                continue;
            }
            counter[x]++;
            if (counter[x] > 1) {
                return false;
            }
        }
        return true;
    }
}
