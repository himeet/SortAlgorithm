import java.util.Arrays;

/**
 * 冒泡排序（默认按照从小到大排序）
 * 时间复杂度：O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        // 定义输入
        int[] nums = new int[] {5, 3, 2, 4, 1};

        // 冒泡排序
        bubbleSort(nums);

        // 输出结果
        System.out.println("冒泡排序后的结果为：");
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {  // 冒泡排序需要进行length-1次冒泡
            for (int j = 0; j < nums.length - 1 - i; j++) {  // 每次冒泡后都将每一轮中最大的值换到最后，所以需要每一轮都减去i
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }
}
