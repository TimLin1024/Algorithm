package sorting;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] ary = {12, 1, 89, 43, 65, 90, 0, 782};
        selectSort(ary);
        System.out.println(Arrays.toString(ary));
    }

    private static void selectSort(int[] ary) {
        int len = ary.length;
        for (int i = 0; i < len - 1; i++) {//只需要比较到倒数第二个
            int k = findMinKeyIndex(ary, len, i);
            if (k != i) {
                swap(ary, i, k);
            }
        }
    }

    private static void swap(int[] ary, int i, int k) {
        int tmp = ary[k];
        ary[k] = ary[i];
        ary[i] = tmp;
    }

    private static int findMinKeyIndex(int[] ary, int len, int i) {
        int k = i;//记录最小数的下标
        //找到本轮中最小数的下标
        for (int j = i + 1; j < len; j++) {
            if (ary[k] > ary[j]) {
                k = j;
            }
        }
        return k;
    }


}
