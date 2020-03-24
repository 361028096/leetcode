package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1160. 拼写单词
 * //给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * //
 * // 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * //
 * // 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * //
 * // 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * //输出：6
 * //解释：
 * //可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * //输出：10
 * //解释：
 * //可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= words.length <= 1000
 * // 1 <= words[i].length, chars.length <= 100
 * // 所有字符串中都仅包含小写英文字母
 * //
 * // Related Topics 数组 哈希表
 *
 *
 * @date 2020/3/17 9:16
 */
public class D20200317N1160SpellWorld {
    public static final String str = "aaa";

    public int countCharacters(String[] words, String chars) {
        int result = 0;
        for (String word : words) {
            if (isExist(word,chars)) {
                result += word.length();
            }
        }
        return result;
    }

    private boolean isExist(String word,String chars) {
        if (chars == null || chars.length()<=0) {
            return false;
        } else {
            for (char alphabet:word.toCharArray()) {
                if (!chars.contains(String.valueOf(alphabet))) {
                    return false;
                } else {
                    chars = chars.replaceFirst(String.valueOf(alphabet),"_");
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        //         //""
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
//        String[] words = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin","ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl","boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx","nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop","hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr","lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl","tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp","qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz","yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue","hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv","cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob","qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
//        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
//        Assert.assertEquals(0,this.countCharacters(words,chars));
        System.out.println(this.isExist("cat",chars));
        System.out.println(chars);
    }
}
