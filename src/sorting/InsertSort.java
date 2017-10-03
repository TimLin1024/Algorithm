package sorting;

import java.util.Arrays;

class InsertSort {
    public static void main(String[] args) {
        int[] ary = {12, 1, 89, 43, 65, 90, 10, 72, 0};
        insertSort2(ary);
        System.out.println(Arrays.toString(ary));
    }


    static void insertSort(int a[]) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {               //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表,找到合适位置插入
                int j = i - 1;
                int tmp = a[i];        //复制为哨兵，即存储待排序元素
                while (j >= 0 && tmp < a[j]) {  //查找在有序表的插入位置
                    a[j + 1] = a[j];
                    j--;         //元素后移
                }
                a[j + 1] = tmp;      //插入到正确位置，注意是 j + 1，因为跳出时 j--
            }
        }
    }


    private static void insertSort2(int[] a) {
        int len = a.length;
        int j;
        for (int i = 1; i < len; i++) {
            int t = a[i];
            for (j = i - 1; j >= 0 && t < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = t;
        }
    }

    static void insertSort3(int[] a) {
        int len = a.length;
        int j;
        for (int i = 1; i < len; i++) {
            int t = a[i];
            for (j = i - 1; j >= 0 && t < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = t;
        }
    }
//
//    private static void insertSort(int[] ary) {
//        int len = ary.length;
//
//        for (int i = 1; i < len; i++) {
//            int k = i;//记录位置
//            //找到合适的插入位置
//            /**
//             * 思路有误：
//             *  这里使用了选择的方法，而不是将有序表后移。会导致乱序，因为将小的数与后面的数交换，而实际上，找到的那个「最小数」应该只是后移一位
//             * */
//            for (int j = i - 1; j >= 0; j--) {
//                if (ary[k] < ary[j]) {
//                    System.out.println("ary[k]:" + ary[k] + " ary[j]: " + ary[j]);
//                    k = j;
//                }
//            }
//            int tmp = ary[k];
//            ary[k] = ary[i];
//            ary[i] = tmp;
//            System.out.println("第 " + i + " 趟：" + Arrays.toString(ary));
//
//        }
//    }


}
