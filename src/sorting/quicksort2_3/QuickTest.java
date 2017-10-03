package sorting.quicksort2_3;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

class QuickTest {

    public static void main(String[] args) {
        int MAX = 100;
        Integer[] aIntegers = new Integer[MAX];
        for (int i = 0; i < aIntegers.length; i++) {
            aIntegers[i] = StdRandom.uniform(-MAX, MAX);
        }
        System.out.println("Original: " + Arrays.toString(aIntegers));
        quicksort(aIntegers, 0, aIntegers.length - 1);
        System.out.println("Sorted: " + Arrays.toString(aIntegers));
    }

    static void quicksort(Integer[] a, int left, int right) {
        int i, j, t, temp;
        if (left > right)
            return;
        temp = a[left]; //temp中存的就是基准数
        i = left;
        j = right;
        while (i != j) {
            //顺序很重要，要先从右边开始找
            while (a[j] >= temp && i < j)
                j--;
            //再找右边的
            while (a[i] <= temp && i < j)
                i++;
            //交换两个数在数组中的位置
            if (i < j) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        //最终将基准数归位
        a[left] = a[i];
        a[i] = temp;

        quicksort(a, left, i - 1);//继续处理左边的，这里是一个递归的过程
        quicksort(a, i + 1, right);//继续处理右边的 ，这里是一个递归的过程
    }

}
