public class QuickSort {
    public static void main(String[] args) {
        // 定义输入
        int[] nums = new int[] {5, 3, 2, 4, 1};

        // 快速排序
        quickSort(nums, 0, nums.length - 1);

        // 输出结果
        System.out.println("快速排序后的结果为：");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 快速排序 递归调用
     * @param nums
     */
    public static void quickSort(int[] nums, int low, int high) {  // low,high为每次处理数组时的首、尾元素索引
        // 递归结束边界：当low==high时表示只有一个元素，不必排序了
        if (low >= high) {
            return;
        }

        // 选出左右两个哨兵元素和基准元素，这里左边的哨兵也是基准元素
        int i = low, j = high, base = nums[low];  // i为左哨兵，j为右哨兵，base为基准元素
        while (i < j) {
            // 右边哨兵从后向前找
            while (nums[j] >= base && i < j) {
                j--;
            }
            // 左边哨兵从前向后找
            while (nums[i] <= base && i < j) {
                i++;
            }
            // 交换i和j处的元素
            swap(nums, i, j);
        }
        // 基准元素归位（基准元素与左右哨兵交汇处交换 此时i==j）
        swap(nums, low, j);

        // 对base左边序列进行排序。递归调用
        quickSort(nums, low, j - 1);
        // 对base右边序列进行排序。递归调用
        quickSort(nums, j + 1, high);
    }

    /**
     * 交换数组nums中 下标i和下标j的元素
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
