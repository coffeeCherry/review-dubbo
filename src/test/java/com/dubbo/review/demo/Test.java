package com.dubbo.review.demo;

import sun.rmi.runtime.NewThreadAction;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongliwei
 * @title: Test
 * @projectName review-dubbo
 * @description: TODO
 * @date 2020-03-0507:09
 */


//input.txt中有10万个随机整数，每行一个，
//范围从0-99999，需要分别统计[0-99]、[100-199]、[200-299]、
//[300-399]  …… [99900, 99999]，出现的次数。
// 输出为每个范围及其中数字出现的次数，范围和数字间空格分隔，每行一个





public class Test {


    /*
     * 思路
     *
     * 创建一个大小为1000 int数组
     * 其中 int[0] 代表 0—99
     * 其中 int[1] 代表 100—199
     * 其中 int[2] 代表 200—299
     * ……
     * 依次类推
     * 时间复杂为 O(n)
     * */
    public static void main(String[] args) {
        printResult("./input.txt");
    }

    private static void printResult(String filePath) {
        int n = 100000;
        int m = 100;
        int[] memo = new int[n / m];
        storageResult(memo, filePath);
        int temp;
        for (int i = 0; i < memo.length; i++) {
            temp = i * 100;
            System.out.println(temp + "—" + (temp + 99) + " " + memo[i]);
        }
    }

    private static void storageResult(int[] memo, String inputFilePath) {
        try (FileInputStream inputStream = new FileInputStream(inputFilePath);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                memo[Integer.parseInt(str) / 100]++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
