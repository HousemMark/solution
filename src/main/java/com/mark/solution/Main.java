package com.mark.solution;

import com.mark.solution.stage.StageOne;
import com.mark.solution.stage.StageTwoFaster;
import com.mark.solution.stage.StageTwoSimple;

import java.util.Arrays;
import java.util.List;

/**
 * @program: 智灵时代广州研发中心
 * @description:
 * @author: 小蜘蛛(mazhonghao)
 * @create: 2020-11-7 23:01
 **/
public class Main {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,1,2,2,2,3};
        StageOne stageOne = new StageOne();
        List<String> resp1 = stageOne.solution(arr1);
        System.out.println("the answer of stage one : " + Arrays.toString(resp1.toArray()));
        int[] arr2 = new int[]{21,22,23};
        StageTwoSimple stageTwo = new StageTwoSimple();
        List<String> resp2 = stageTwo.solution(arr2);
        System.out.println("the answer of stage two : " + Arrays.toString(resp2.toArray()));
        int[] arrFast = new int[]{21,22,23};
        StageTwoFaster stageTwoFaster = new StageTwoFaster();
        List<String> resp3 = stageTwoFaster.solution(arrFast);
        System.out.println("the answer of stage two : " + Arrays.toString(resp3.toArray()));
    }
}
