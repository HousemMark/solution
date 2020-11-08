package com.mark.solution.stage;

import java.util.*;

/**
 * @program: converting the digits from 0 to 99 into letters
 * @author: mazhonghao
 * @create: 2020-11-7 21:20
 **/
public class StageTwoFaster {
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
        // double recursion algorithm
        recursion(arr, resp, 0, 0, 0, new StringBuffer());
        long endTime = System.currentTimeMillis();
        System.out.println("stage two faster running time :" + (endTime - startTime));
        return resp;
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
    private void recursion(int[] arr, List<String> resp, int index, int emptyIndex, int childIndex, StringBuffer stringBuffer) {
        if (arr.length == index) {
            // 2-9 mapping is allowed to the result
            if (stringBuffer.length() != 0) {
                resp.add(stringBuffer.toString());
            }
        } else {
            // number is over than 10, split it, then doing the second recursion one by one
            if (arr[index] >= TEN_LIMIT) {
                String var1 = String.valueOf(arr[index]);
                // get the chars
                char[] chars = var1.toCharArray();
                // the second recursion
                childRecursion(chars, 0, childIndex, stringBuffer, arr, resp, index, emptyIndex);
            } else {
                // normal recursion
                combine(arr, resp, index, childIndex, emptyIndex, stringBuffer, arr[index]);
            }
        }
    }

    /**
     * the second recursion algorithm
     */
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
        // 0 or 1
        if (var1 == null) {
            recursion(arr, resp, index + 1, emptyIndex + 1, childIndex + 1, stringBuffer);
        } else {
            // iterate then recursion
            for (int i = 0; i < var1.length(); i++) {
                stringBuffer.append(var1.charAt(i));
                recursion(arr, resp, index + 1, emptyIndex, childIndex + 1, stringBuffer);
                // clean the old data
                stringBuffer.deleteCharAt(index - emptyIndex);
            }
        }
    }
}
