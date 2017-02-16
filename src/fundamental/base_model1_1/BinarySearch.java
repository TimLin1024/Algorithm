package fundamental.base_model1_1;

import java.util.Arrays;

import javax.sound.midi.MidiChannel;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {

	public static int rank(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		int mid = (low + high) / 2;
		while (low <= high) {
			if (a[mid] > key) {
				high = mid - 1;
			} else if (a[mid] < key) {
				low = mid + 1;
			} else {
				return mid;
			}
			mid = (low + high) / 2;
		}
		return -1;
	}

	public static int rankMinIndex(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		int mid = (low + high) / 2;
		while (low <= high) {
			if (a[mid] > key) {
				high = mid - 1;
			} else if (a[mid] < key) {
				low = mid + 1;
			} else {
				//顺序不可颠倒，不然mid-1可能越界
				while (mid > 0 && key == a[mid - 1] ) {
					--mid;
				}
				return mid;
			}
			mid = (low + high) / 2;
		}
		return -1;
	}

	public static int recurseBinarySearch(int[] a, int low, int high, int key) {
		if (low < high) {
			int mid = (low + high) / 2;
			if (key < a[mid]) {
				return recurseBinarySearch(a, low, mid - 1, key);
			} else if (key > a[mid]) {
				return recurseBinarySearch(a, mid + 1, high, key);
			} else {
				return mid;
			}
		} else {
			return -1;
		}
	}

	
	public static int rank(int key, int[] a) {
		if (a == null) {
			throw new IllegalArgumentException("ary can't be null");
		}
		return rank(key, a, 0, a.length-1, 1);
	}

	public static int rank(int key, int[] a, int lo, int hi, int depth) {
		if (lo > hi) {
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
//		//打印缩进与 lo hi
//		for (int i = 0; i < depth; i++) {
//			System.out.print(" ");
//		}
//		System.out.println("lo:" + lo + ",hi:" + hi);
		if (a[mid] > key) {
			return rank(key, a, lo, mid - 1, ++depth);
		} else if (a[mid] < key) {
			return rank(key, a, mid + 1, hi, ++depth);
		} else {
			return mid;
		}
	}
	
	public static void main(String[] args) {
		int[] whiteList = In.readInts(args[0]);
		Arrays.sort(whiteList);
		System.out.println(Arrays.toString(whiteList));
		fundamental.data_abstraction1_2.Counter counter = new fundamental.data_abstraction1_2.Counter("BinarySearch");
		
		int[] inputList = In.readInts(args[1]);
		for (int i = 0; i < inputList.length; i++) {
			if (rank(inputList[i], whiteList) < 0) {
				System.out.println("-"+inputList[i]);
			}else{
				System.out.println("+"+inputList[i]);
			}
		}
	}
}
