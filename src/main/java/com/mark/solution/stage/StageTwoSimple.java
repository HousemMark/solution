package com.mark.solution.stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: converting the digits from 0 to 99 into letters
 * @author: mazhonghao
 * @create: 2020-11-7 21:20
 **/
public class StageTwoSimple {
    // number dictionary map
    private Map<Integer, String> dic;

    private Integer TEN_LIMIT = 10;

    /**
     * main algorithm
     */
    public List<String> solution(int[] arr) {
        long startTime = System.currentTimeMillis();
        if (arr.length == 0) {
            return new ArrayList<>();
        }
        initMap();
        List<String> resp = new ArrayList<>();
        // iterate and spilt the numbers
        Integer[] arr1 = convertArr(arr);
        // recursion algorithm
        recursion(arr1, resp, 0, 0, new StringBuffer());
        long endTime = System.currentTimeMillis();
        System.out.println("stage two simple running time :" + (endTime - startTime));
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
     * init dictionary mapping
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
     * recursion algorithm
     */
    private void recursion(Integer[] arr, List<String> resp, int index, int emptyIndex, StringBuffer stringBuffer) {
        if (arr.length == index) {
            // 2-9 mapping is allowed to the result
            resp.add(stringBuffer.toString());
        } else {
            String var1 = dic.get(arr[index]);
            // 0 or 1
            if (var1 == null) {
                recursion(arr, resp, index + 1, emptyIndex + 1, stringBuffer);
            } else {
                // iterate then recursion
                for (int i = 0; i < var1.length(); i++) {
                    stringBuffer.append(var1.charAt(i));
                    recursion(arr, resp, index + 1, emptyIndex, stringBuffer);
                    // clean the old data
                    stringBuffer.deleteCharAt(index - emptyIndex);
                }
            }
        }
    }
}
