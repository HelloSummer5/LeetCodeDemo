### 题目描述

> 给定两个数组，编写一个函数来计算它们的交集。
示例1：
```
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
```
示例1：
```
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[4,9]
```

### 思路
有空补，欢迎在线催更。

### 代码
```java
class Solution {
// 这个方法好笨，有空优化
    public int[] intersect(int[] nums1, int[] nums2) {
        Map map = new HashMap<>();
        List<Integer> res= new ArrayList<>();
        // 第一个数组元素放入map
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            if (map.containsKey(key)){
                map.put(key, (Integer)map.get(key) + 1);
            }else {
                map.put(nums1[i], 1);
            }
        }
        // 第二个数组元素
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            if (map.containsKey(key) && (int)map.get(key) > 0){
                map.put(key, (int)map.get(key) - 1);
                res.add(key);
            }
        }
        // List<Integer> 转 int[]
        int[] result = res.stream().mapToInt(Integer::valueOf).toArray();
        return result;
    }
}
```

- 本项目代码：[LeetCode350](https://github.com/HelloSummer5/LeetCodeDemo/blob/master/src/com/leetcode/array/LeetCode350.java "悬停显示")
