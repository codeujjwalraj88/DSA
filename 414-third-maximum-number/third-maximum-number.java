class Solution {
    public int thirdMax(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);   // duplicates हट जाएंगे
        }

        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        if (list.size() < 3) {
            return list.get(list.size() - 1);   // maximum
        }

        return list.get(list.size() - 3);       // third maximum
    }
}