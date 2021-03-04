/**
 * 选择排序（默认按照从小到大排序）
 * 算法思想：从待排序的数据中寻找最小值，将其与序列最左边的数字进行交换
 * 时间复杂度：O(n^2)
 */
public class SelectSort {
    public static void main(String[] args) {
        // 定义输入
        int[] nums = new int[] {5, 3, 2, 4, 1};

        // 选择排序
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;  // index表示当前循环中最小值的下标
            // 找出当前循环中的最小值的下标
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            // 交换元素（将本轮循环最小元素交换到最前面）
            int tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
        }

        // 输出结果
        System.out.println("选择排序后的结果为：");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
