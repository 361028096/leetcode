import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

/**
 * // [面试题40]最小的k个数
 * //输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：arr = [3,2,1], k = 2
 * //输出：[1,2] 或者 [2,1]
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：arr = [0,1,2,1], k = 1
 * //输出：[0]
 * //
 * //
 * //
 * // 限制：
 * //
 * //
 * // 0 <= k <= arr.length <= 10000
 * // 0 <= arr[i] <= 10000
 * //
 * // Related Topics 堆 分治算法
 *
 *
 * @date 2020/3/20 09:57
 */
public class D20200320NM40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr,0,k);
    }


    @Test
    public void test() {
        int[] arr = {3,1,2};
        Arrays.sort(arr);
        System.out.println(JSON.toJSONString(arr));
        System.out.println(JSON.toJSONString(Arrays.copyOfRange(arr,0,2)));
        Assert.assertEquals(new int[]{1,2},this.getLeastNumbers(new int[]{3,2,1},2));
    }

    @Test
    public void testMap() {
        Map<String,String> map = new HashMap<>();
        map.put("key","value");
        System.out.println(JSON.toJSONString(map));
    }
}
