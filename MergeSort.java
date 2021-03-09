import java.util.Arrays;

/**
 * 归并排序（默认按照从小到大排序）
 * 算法思想：
 * 时间复杂度：O(nlogn)
 */
public class MergeSort {
    public static void main(String[] args) {
        // 定义输入
        int[] nums = new int[] {5, 3, 2, 4, 1};

        // 归并排序
        int[] tmp = new int[nums.length];
        mergeSort(nums, 0, tmp.length - 1, tmp);

        // 输出结果
        System.out.println("插入排序后的结果为：");
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 归并排序 递归方式调用
     */
    public static void mergeSort(int[] nums, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid, tmp);  // 对左边序列进行归并排序
            mergeSort(nums, mid + 1, high, tmp);  // 对右边序列进行归并排序
            merge(nums, low, mid, high, tmp);  // 合并两个有序序列
        }
    }

    /**
     * 辅助函数，用于合并两个有序序列
     * @param nums
     * @param low
     * @param mid
     * @param high
     * @param tmp
     */
    public static void merge(int[] nums, int low, int mid, int high, int[] tmp) {
        int i = 0;
        int j = low, k = mid + 1;  // 左边序列和右边序列起始索引
        // 从左右序列中分别取最前面一个元素leftNum和rightNum，比较大小后，按照大小插入tmp中
        while (j <= mid && k <= high) {
            if (nums[j] < nums[k]) {
                tmp[i++] = nums[j++];
            } else {
                tmp[i++] = nums[k++];
            }
        }
        // 若左边序列还有剩余，则将其全部拷贝到tmp[]中
        while (j <= mid) {
            tmp[i++] = nums[j++];
        }
        // 若右边还有剩余，则将其全部拷贝到tmp[]中
        while (k <= high) {
            tmp[i++] = nums[k++];
        }
        // 将已经排好序的tmp拼接到nums中
        // 之前只是把排序的结果存在了tmp临时数据里，现在要把这部分复制到原来的arr数组对应的位置，
        // 这样在下一次用到nums的时候才是我们这次排好序的
        for (int t = 0; t < i; t++) {
            nums[low + t] = tmp[t];
        }
    }
}
