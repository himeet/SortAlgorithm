import java.util.Arrays;

/**
 * 堆排序（默认按照从小到大排序）
 * 算法思想：略
 * 时间复杂度：O(nlogn)
 * 参考资料：https://www.bilibili.com/video/BV1Eb41147dK?from=search&seid=10734322853593375875(PHD视频讲堆排序)
 * 备注1：堆是一种数据结构，可以被视为一种完全二叉树，即树里面除了最后一层其它层都是满的
 *       也正是因为这个，树里面每个节点的子女和双亲节点的序号都可以根据当前节点的序号直
 *       接求出：
 *       parent(i) = （i - 1）/ 2
 *       left(i) = 2 * i + 1
 *       right(i) = 2 * i + 2
 * 备注2：顶堆分为大顶堆和小顶堆
 */
public class HeapSort {
    public static void main(String[] args) {
        // 定义输入
        int[] nums = new int[] {5, 3, 2, 4, 1};

        // 堆排序
        heapSort(nums, nums.length);

        // 输出结果
        System.out.println("堆排序后的结果为：");
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 堆排序
     * @param nums
     */
    public static void heapSort(int[] nums, int heapSize) {
        buildHeap(nums, heapSize);
        for (int i = heapSize - 1; i >= 0; i--) {  // 从最后一个节点出发，一直到第0个节点
            swap(nums, i, 0);
            heapify(nums, i, 0);  // i表示当前树的节点数
        }
    }

    /**
     * 建造堆：从最后一个节点的parent开始向前建造堆
     * @param nums
     * @param heapSize
     */
    public static void buildHeap(int[] nums, int heapSize) {
        int lastNode = heapSize - 1;
        int parent = (lastNode - 1) / 2;
        for (int i = parent; i >= 0; i--) {  // 从最后一个节点的parent出发，一直到第0个节点
            heapify(nums, heapSize, i);
        }
    }

    /**
     * 堆化：从root根节点出发，向下堆化（此函数运行完后，不一定整棵树都是堆）（这里建立的是「大顶堆」）
     * @param nums
     * @param heapSize 堆的大小，即节点总个数
     * @param root 将以root为根的树进行堆化
     */
    public static void heapify(int[] nums, int heapSize, int root) {
        // 递归结束边界
        if (root >= heapSize) {
            return;
        }

        int leftChild = 2 * root + 1;  // 根据公式推得
        int rightChild = 2 * root + 2;  // 根据公式推得
        int max = root;
        if (leftChild < heapSize && nums[leftChild] > nums[max]) {
            max = leftChild;
        }
        if (rightChild < heapSize && nums[rightChild] > nums[max]) {
            max = rightChild;
        }
        if (max != root) {
            swap(nums, max, root);
            heapify(nums, heapSize, max);  // 递归调用
        }
    }

    /**
     * 交换nums数组中i位置和j位置的元素
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
