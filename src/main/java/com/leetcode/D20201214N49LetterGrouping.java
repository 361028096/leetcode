package com.leetcode;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.*;
import java.util.jar.JarEntry;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @date 2020/12/14 10:15
 */
public class D20201214N49LetterGrouping {


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> resultMap = new HashMap<>();
        for (String str:strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String temp = String.valueOf(strChar);
            if (resultMap.containsKey(temp)) {
                List<String> history = new ArrayList<>(resultMap.get(temp));
                history.add(str);
                resultMap.put(temp,history);
            } else {
                resultMap.put(temp, Collections.singletonList(str));
            }
        }

        List<List<String>> resultList = new ArrayList<>();
        for (String key: resultMap.keySet()) {
            resultList.add(resultMap.get(key));
        }

        return resultList;
    }
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> resultMap = new HashMap<>();
        for (String str:strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String key = new String(strChar);

            List<String> history = resultMap.getOrDefault(key,new ArrayList<>());
            history.add(str);
            resultMap.put(key,history);

        }
        return new ArrayList<List<String>>(resultMap.values());
    }

    // ["eat","tea","tan","ate","nat","bat"]
    // ["eat","tea","tan","ate","nat","bat"]

    @Test
    public void test() {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<String> list = Arrays.asList(strs);
        List<List<String>>  result = new ArrayList<>();
        result = this.groupAnagrams(strs);
        System.out.println(JSON.toJSONString(result));
    }

    // 1.char转string
    // 2.修改list


}
