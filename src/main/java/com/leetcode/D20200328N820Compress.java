package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * // [820]单词的压缩编码
 * //给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * //
 * // 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0,
 * // 2, 5]。
 * //
 * // 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * //
 * // 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * //
 * //
 * //
 * // 示例：
 * //
 * // 输入: words = ["time", "me", "bell"]
 * //输出: 10
 * //说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= words.length <= 2000
 * // 1 <= words[i].length <= 7
 * // 每个单词都是小写字母 。
 * //
 * //
 * 解答成功: 执行耗时:25 ms,击败了64.19% 的Java用户 内存消耗:41.3 MB,击败了18.18% 的Java用户
 * @date 2020/3/28 22:13
 */
public class D20200328N820Compress {
//    public int minimumLengthEncoding(String[] words) {
//        if (null == words || words.length == 0) {
//            return 0;
//        }
//        String result = "";
//        for (int i = 0; i < words.length; i++) {
//            if (i == 0) {
//                result += words[i]+"#";
//                continue;
//            }
//            if (words[i-1].contains(words[i]) && words[i-1].endsWith(words[i])) {
//                continue;
//            } else {
//                result = result + words[i]+"#";
//            }
//        }
//        System.out.println("result:"+result);
//        return result.length();
//    }

    public int minimumLengthEncoding(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for(String word:words) {
            for (int i = 1; i < word.length(); i++) {
                wordSet.remove(word.substring(i));
            }
        }
        int ans = 0;
        for(String word:wordSet) {
            ans += word.length()+1;
        }
        return ans;
    }

    @Test
    public void test() {
        String[] words = {"time", "me", "bell"};
        System.out.println(this.minimumLengthEncoding(words));
        Assert.assertEquals(10,this.minimumLengthEncoding(words));
    }
}
