/**
Parity Permutation

要求奇偶相间的所有方案

Sol: 类似于Permutation
*/

public List<List<Integer>> findAllParityPermutations(int a) {
    List<List<Integer>> list = new ArrayList<>();
    if (a % 2 == 0) {
        int[] oddArr = new int[a];
        int[] evenArr = new int[a];
        for (int i = 0; i < a; i++) {
            oddArr[i] = i + 1;
            evenArr[i] = a - i;
        }
        helper(oddArr, 0, list);
        helper(evenArr, 0, list);
    } else {
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = i + 1;
        }
        helper(arr, 0, list);
    }
    Collections.sort(list, (x, y) -> Arrays.toString(x.toArray()).compareTo(Arrays.toString(y.toArray())));
    return list;
}

private void helper(int[] arr, int idx, List<List<Integer>> list) {
    if (idx == arr.length - 1) {
        List<Integer> permutation = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            permutation.add(arr[i]);
        }
        list.add(permutation);
    }
    for (int i = idx; i < arr.length; i += 2) {
        swap(arr, idx, i);
        helper(arr, idx + 1, list);
        swap(arr, idx, i);
    }
}

private void swap(int[] arr, int idx1, int idx2) {
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
}