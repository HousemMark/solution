package com.mark.solution;

import com.mark.solution.stage.StageOne;
import com.mark.solution.stage.StageTwoFaster;
import com.mark.solution.stage.StageTwoSimple;

import java.util.Arrays;
import java.util.List;

public class MainTest {
    private static StageOne stageOne;
    private static StageTwoSimple stageTwoSimple;
    private static StageTwoFaster stageTwoFaster;

    public static void main(String[] args) {
        stageOne = new StageOne();
        stageTwoSimple = new StageTwoSimple();
        stageTwoFaster = new StageTwoFaster();
        // 0-9 测试用例
        testTenLimit(stageOne, stageTwoSimple, stageTwoFaster);
        // 0-99 测试用例
        testHundredLimit(stageOne, stageTwoSimple, stageTwoFaster);
        // 多位数测试用例
        testMultipleLimit(stageOne, stageTwoSimple, stageTwoFaster);
    }

    private static void testMultipleLimit(StageOne stageOne, StageTwoSimple stageTwoSimple, StageTwoFaster stageTwoFaster) {
        int[] arr = new int[]{123, 154, 198};
        List<String> resp1 = stageOne.solution(arr);
        System.out.println("the answer of stage one : " + Arrays.toString(resp1.toArray()));
        List<String> resp2 = stageTwoSimple.solution(arr);
        System.out.println("the answer of stage two : " + Arrays.toString(resp2.toArray()));
        List<String> resp3 = stageTwoFaster.solution(arr);
        System.out.println("the answer of stage two : " + Arrays.toString(resp3.toArray()));
    }

    private static void testHundredLimit(StageOne stageOne, StageTwoSimple stageTwoSimple, StageTwoFaster stageTwoFaster) {
        int[] arr = new int[]{1, 12, 23, 34, 45, 6, 7, 8, 89, 90};
        List<String> resp1 = stageOne.solution(arr);
//        System.out.println("the answer of stage one : " + Arrays.toString(resp1.toArray()));
        List<String> resp2 = stageTwoSimple.solution(arr);
//        System.out.println("the answer of stage two : " + Arrays.toString(resp2.toArray()));
        List<String> resp3 = stageTwoFaster.solution(arr);
//        System.out.println("the answer of stage two : " + Arrays.toString(resp3.toArray()));
    }

    private static void testTenLimit(StageOne stageOne, StageTwoSimple stageTwoSimple, StageTwoFaster stageTwoFaster) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        List<String> resp1 = stageOne.solution(arr);
        System.out.println("the answer of stage one : " + Arrays.toString(resp1.toArray()));
        List<String> resp2 = stageTwoSimple.solution(arr);
        System.out.println("the answer of stage two : " + Arrays.toString(resp2.toArray()));
        List<String> resp3 = stageTwoFaster.solution(arr);
        System.out.println("the answer of stage two : " + Arrays.toString(resp3.toArray()));
    }
}
