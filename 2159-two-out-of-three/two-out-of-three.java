class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1)
            set1.add(num);

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2)
            set2.add(num);

        Set<Integer> set3 = new HashSet<>();
        for (int num : nums3)
            set3.add(num);

        Set<Integer> ans = new HashSet<>();

        Set<Integer> temp = new HashSet<>(set1);
        temp.retainAll(set2);
        ans.addAll(temp);

        temp = new HashSet<>(set2);
        temp.retainAll(set3);
        ans.addAll(temp);

        temp = new HashSet<>(set1);
        temp.retainAll(set3);
        ans.addAll(temp);

        return new ArrayList<>(ans);
    }
}