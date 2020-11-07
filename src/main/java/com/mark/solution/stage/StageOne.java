package com.mark.solution.stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: 智灵时代广州研发中心
 * @description:将输入的数字（0-9）数组按照手机按键式的映射组合并返回
 * @author: 小蜘蛛(mazhonghao)
 * @create: 2020-11-7 21:20
 **/
public class StageOne {
    // 数字字典
    private Map<Integer, String> dic;

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
     * 递归
     */
    private void recursion(int[] arr, List<String> resp, int index, int emptyIndex, StringBuffer stringBuffer) {
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
