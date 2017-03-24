
public class P088_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Exception case
        if (nums1 == null || nums2 == null) {
            return;
        }

        // Recursion
        // if (n == 0) {
        //     return;
        // }

        // if (m == 0) {
        //     for (int i = 0; i < n; i++) {
        //         nums1[i] = nums2[i];
        //     }
        //     return;
        // }

        // if (nums1[m - 1] < nums2[n - 1]) {
        //     nums1[m + n - 1] = nums2[n - 1];
        //     merge(nums1, m, nums2, n - 1);
        // } else {
        //     nums1[m + n - 1] = nums1[m - 1];
        //     merge(nums1, m - 1, nums2, n);
        // }

        // Iterative
        while (n > 0) {
            if (m == 0) {
                for (int i = 0; i < n; i++) {
                    nums1[i] = nums2[i];
                }
                return;
            }

            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[m + n - 1] = nums2[(n--) - 1];
            } else {
                nums1[m + n - 1] = nums1[(m--) - 1];
            }
        }
    }
}
