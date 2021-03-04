/**
 * 插入排序（默认按照从小到大排序）
 * 算法思想：从右侧的未排序区域内取出一个数据，然后将它插入到已排序区域内合适的位置上
 * 时间复杂度：O(n^2)
 */
public class InsertSort {
    public static void main(String[] args) {
        // 定义输入
        int[] nums = new int[] {5, 3, 2, 4, 1};

        // 插入排序
        for (int i = 1; i < nums.length; i++) {  // 这里的索引i从1开始，因为单个元素nums[0]是有序的
            int temp = nums[i];  // 从无序数列中取出一个元素，赋值给temp。因为下面的步骤中会将元素右移，会覆盖掉nums[i]本身的元素
            int t = i - 1;  // t表示左侧有序数列的索引，索引逐渐递减
            while (t >= 0 && nums[t] > temp) {
                nums[t+1] = nums[t];  // 左边有序数列中的元素右移
                t--;
            }
            nums[t+1] = temp;  // 把该元素插入到空位上（因为循环的最后t--，所以插入到了t+1的位置）
        }

        // 输出结果
        System.out.println("插入排序后的结果为：");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
