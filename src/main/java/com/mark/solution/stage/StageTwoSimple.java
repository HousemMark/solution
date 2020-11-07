package com.mark.solution.stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: 智灵时代广州研发中心
 * @description:基于第一阶段，支持0-99的数字，疑问：如何算是支持？返回空集合（第一阶段已实现）或是拆分后继续进行映射？
 * @author: 小蜘蛛(mazhonghao)
 * @create: 2020-11-7 21:20
 **/
public class StageTwoSimple {
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
        Integer[] arr1 = convertArr(arr);
        // 递归算法
        recursion(arr1, resp, 0, 0, new StringBuffer());
        return resp;
    }

    private Integer[] convertArr(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (num <= TEN_LIMIT) {
                list.add(num);
            } else {
                String s = String.valueOf(num);
                char[] chars = s.toCharArray();
                for (char c : chars) {
                    list.add(Integer.parseInt(String.valueOf(c)));
                }
            }
        }
        Integer[] arrs = new Integer[list.size()];
        return list.toArray(arrs);
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
    private void recursion(Integer[] arr, List<String> resp, int index, int emptyIndex, StringBuffer stringBuffer) {
        if (arr.length == index) {
            // 存值
            resp.add(stringBuffer.toString());
        } else {
            String var1 = dic.get(arr[index]);
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
}
