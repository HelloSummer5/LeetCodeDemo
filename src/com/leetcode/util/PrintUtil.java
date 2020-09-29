package com.leetcode.util;

/**
 * 打印工具
 */
public class PrintUtil {

    public static void print(int arr[]){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1){
                System.out.print(arr[i] + "]");
            }else {
                System.out.print(arr[i] + ",");
            }
        }
    }

    public static void println(Boolean res){
        System.out.println(res);
    }

}
