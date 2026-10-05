class Solution {

    static boolean issorted(List<Integer> list, int i) {
        if (i == 0) {
            return true;
        }

        if (list.get(i) < list.get(i - 1)) {
            return false;
        }

        return issorted(list, i - 1);
    }

    public boolean check(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i : nums) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {

            if (issorted(list, list.size() - 1)) {
                return true;
            }

            // last element ko remove karo
            Integer ld = list.get(list.size() - 1);
            list.remove(list.size() - 1);

            // front mein add karo
            list.add(0, ld);
        }

        return false;
    }
}