class Solution {
    static Set<List<Integer>> subsets(int[] arr, List<Integer> list,
                                      Set<List<Integer>> set, int index) {
        if (index == arr.length) {
            set.add(new ArrayList<>(list));
            return set;
        }

        list.add(arr[index]);
        subsets(arr, list, set, index + 1);

        list.remove(list.size() - 1);

        subsets(arr, list, set, index + 1);

        return set;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        subsets(nums, new ArrayList<>(), set, 0);

        return new ArrayList<>(set);
    }
}