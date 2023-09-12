package com.leetcode;

// 给定一个经过编码的字符串，返回它解码后的字符串。
//
//编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
//你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
//此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//
//
//示例 1：
//
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
//示例 2：
//
//输入：s = "3[a2[c]]"
//输出："accaccacc"
//示例 3：
//
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
//示例 4：
//
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
//
//
//提示：
//
//1 <= s.length <= 30
//s 由小写英文字母、数字和方括号 '[]' 组成
//s 保证是一个 有效 的输入。
//s 中所有整数的取值范围为 [1, 300]
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 30
// s 由小写英文字母、数字和方括号 '[]' 组成
// s 保证是一个 有效 的输入。
// s 中所有整数的取值范围为 [1, 300]
//
// Related Topics 栈 递归 字符串
// 👍 1582 👎 0

//方法一：栈操作
//思路和算法
//
//本题中可能出现括号嵌套的情况，比如 2[a2[bc]]，这种情况下我们可以先转化成 2[abcbc]，在转化成 abcbcabcbc。我们可以把字母、数字和括号看成是独立的 TOKEN，并用栈来维护这些 TOKEN。
// 具体的做法是，遍历这个栈：
//
//如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈
//如果当前的字符为字母或者左括号，直接进栈
//如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，此时取出栈顶的数字（此时栈顶一定是数字，想想为什么？），就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
//重复如上操作，最终将栈中的元素按照从栈底到栈顶的顺序拼接起来，就得到了答案。注意：这里可以用不定长数组来模拟栈操作，方便从栈底向栈顶遍历。
//
//class Solution {
//    int ptr;
//
//    public String decodeString(String s) {
//        LinkedList<String> stk = new LinkedList<String>();
//        ptr = 0;
//
//        while (ptr < s.length()) {
//            char cur = s.charAt(ptr);
//            if (Character.isDigit(cur)) {
//                // 获取一个数字并进栈
//                String digits = getDigits(s);
//                stk.addLast(digits);
//            } else if (Character.isLetter(cur) || cur == '[') {
//                // 获取一个字母并进栈
//                stk.addLast(String.valueOf(s.charAt(ptr++)));
//            } else {
//                ++ptr;
//                LinkedList<String> sub = new LinkedList<String>();
//                while (!"[".equals(stk.peekLast())) {
//                    sub.addLast(stk.removeLast());
//                }
//                Collections.reverse(sub);
//                // 左括号出栈
//                stk.removeLast();
//                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
//                int repTime = Integer.parseInt(stk.removeLast());
//                StringBuffer t = new StringBuffer();
//                String o = getString(sub);
//                // 构造字符串
//                while (repTime-- > 0) {
//                    t.append(o);
//                }
//                // 将构造好的字符串入栈
//                stk.addLast(t.toString());
//            }
//        }
//
//        return getString(stk);
//    }
//
//    public String getDigits(String s) {
//        StringBuffer ret = new StringBuffer();
//        while (Character.isDigit(s.charAt(ptr))) {
//            ret.append(s.charAt(ptr++));
//        }
//        return ret.toString();
//    }
//
//    public String getString(LinkedList<String> v) {
//        StringBuffer ret = new StringBuffer();
//        for (String s : v) {
//            ret.append(s);
//        }
//        return ret.toString();
//    }
//}
//
//作者：力扣官方题解
//链接：https://leetcode.cn/problems/decode-string/solutions/264391/zi-fu-chuan-jie-ma-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//
//
//复杂度分析
//
//时间复杂度：记解码后得出的字符串长度为 SSS，除了遍历一次原字符串 sss，我们还需要将解码后的字符串中的每个字符都入栈，并最终拼接进答案中，故渐进时间复杂度为 O(S+∣s∣)O(S+|s|)O(S+∣s∣)，即 O(S)O(S)O(S)。
//空间复杂度：记解码后得出的字符串长度为 SSS，这里用栈维护 TOKEN，栈的总大小最终与 SSS 相同，故渐进空间复杂度为 O(S)O(S)O(S)。
//
//作者：力扣官方题解
//链接：https://leetcode.cn/problems/decode-string/solutions/264391/zi-fu-chuan-jie-ma-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

import java.util.Collections;
import java.util.LinkedList;

/**
 * D20230906N394DecodeString
 *
 * @author wei.he
 * @date 2023/9/6 9:47
 */
public class D20230906N394DecodeString {

    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                while(repTime-- > 0) {
                    t.append(o);
                }
                stk.addLast(t.toString());
            }
        }
        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while(Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for(String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

}
