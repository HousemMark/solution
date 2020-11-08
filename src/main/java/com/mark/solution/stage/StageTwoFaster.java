package com.mark.solution.stage;

import java.util.*;

/**
 * @program: 智灵时代广州研发中心
 * @description:基于第一阶段，支持0-99的数字，疑问：如何算是支持？返回空集合（第一阶段已实现）或是拆分后继续进行映射？
 * @author: 小蜘蛛(mazhonghao)
 * @create: 2020-11-7 21:20
 **/
public class StageTwoFaster {
    // 数字字典映射
    private Map<Integer, String> dic;

    private Integer TEN_LIMIT = 10;

    /**
     * 核心算法
     */
    public List<String> solution(int[] arr) {
        if (arr.length == 0) {
            return new ArrayList<>();
        }
        initMap();
        List<String> resp = new ArrayList<>();
        // 双层递归算法
        recursion(arr, resp, 0, 0, 0, new StringBuffer());
        return resp;
    }

    /**
     * 初始化Map映射
     */
    private void initMap() {
        dic = new HashMap<>();
        dic.put(2, "abc");
        dic.put(3, "def");
        dic.put(4, "ghi");
        dic.put(5, "jkl");
        dic.put(6, "mno");
        dic.put(7, "pqrs");
        dic.put(8, "tuv");
        dic.put(9, "wxyz");
    }

    /**
     * 递归，增加拆分个位数和十位数功能
     */
    private void recursion(int[] arr, List<String> resp, int index, int emptyIndex, int childIndex, StringBuffer stringBuffer) {
        if (arr.length == index) {
            // 存值
            if (stringBuffer.length() != 0) {
                resp.add(stringBuffer.toString());
            }
        } else {
            // 如果超过10，将其拆分后进行递归映射
            if (arr[index] >= TEN_LIMIT) {
                String var1 = String.valueOf(arr[index]);
                char[] chars = var1.toCharArray();
                // 把char数组转换成int数组，递归处理
                childRecursion(chars, 0, childIndex, stringBuffer, arr, resp, index, emptyIndex);
            } else {
                combine(arr, resp, index, childIndex, emptyIndex, stringBuffer, arr[index]);
            }
        }
    }

    private void childRecursion(char[] chars, int index, int childIndex, StringBuffer stb, int[] arr, List<String> resp, int outIndex, int emptyIndex) {
        if (chars.length == index) {
            recursion(arr, resp, outIndex + 1, emptyIndex, childIndex, stb);
            return;
        }
        int key = Integer.parseInt(String.valueOf(chars[index]));
        String value = dic.get(key);
        if (value == null) {
            childRecursion(chars, index + 1, childIndex, stb, arr, resp, outIndex, emptyIndex);
        } else {
            for (int i = 0; i < value.length(); i++) {
                stb.append(value.charAt(i));
                childRecursion(chars, index + 1, childIndex + 1, stb, arr, resp, outIndex, emptyIndex);
                stb.deleteCharAt(childIndex - emptyIndex);
            }
        }
    }

    private void combine(int[] arr, List<String> resp, int index, int childIndex, int emptyIndex, StringBuffer stringBuffer, Integer key) {
        String var1 = dic.get(key);
        // 如果是0或1的情况
        if (var1 == null) {
            recursion(arr, resp, index + 1, emptyIndex + 1, childIndex + 1, stringBuffer);
        } else {
            // 遍历后继续递归
            for (int i = 0; i < var1.length(); i++) {
                stringBuffer.append(var1.charAt(i));
                recursion(arr, resp, index + 1, emptyIndex, childIndex + 1, stringBuffer);
                // 清理旧数据
                stringBuffer.deleteCharAt(index - emptyIndex);
            }
        }
    }
}
