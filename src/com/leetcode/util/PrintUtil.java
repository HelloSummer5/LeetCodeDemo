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

    public static void print(Boolean res){
        System.out.print(res);
    }

}
