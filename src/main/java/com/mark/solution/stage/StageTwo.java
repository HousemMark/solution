package com.mark.solution.stage;

import java.util.*;

/**
 * @program: 智灵时代广州研发中心
 * @description:基于第一阶段，支持0-99的数字，疑问：如何算是支持？返回空集合（第一阶段已实现）或是拆分后继续进行映射？
 * @author: 小蜘蛛(mazhonghao)
 * @create: 2020-11-7 21:20
 **/
public class StageTwo {
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
        // 递归算法
        recursion(arr, resp, 0, 0, new StringBuffer());
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
    private void recursion(int[] arr, List<String> resp, int index, int emptyIndex, StringBuffer stringBuffer) {
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

                // 拆分并解析每个数字
                for (char c : chars) {
                    Integer var2 = Integer.parseInt(String.valueOf(c));
                    String var3 = dic.get(var2);
                    if (var3 != null) {
                        for (int i = 0; i < var3.length(); i++) {
                            stringBuffer.append(var3.charAt(i));

                        }
                    }
                }
            } else {
                combine(arr, resp, index, emptyIndex, stringBuffer, arr[index]);
            }
        }
    }

    private void combine(int[] arr, List<String> resp, int index, int emptyIndex, StringBuffer stringBuffer, Integer key){
        String var1 = dic.get(key);
        // 如果是0或1的情况
        if (var1 == null) {
            recursion(arr, resp, index + 1, emptyIndex + 1, stringBuffer);
        } else {
            // 遍历后继续递归
            for (int i = 0; i < var1.length(); i++) {
                stringBuffer.append(var1.charAt(i));
                recursion(arr, resp, index + 1, emptyIndex, stringBuffer);
                // 清理旧数据
                stringBuffer.deleteCharAt(index - emptyIndex);
            }
        }
    }
}
