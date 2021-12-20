/*
December 19th 2021
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements. 

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

//		char[][] test = { { '1' } };
		int[] arr = { 3, 8, -10, 23, 19, -4, -14, 27 };

		System.out.println(minimumAbsDifference(arr) + "a");
//		System.out.println();
	}

	public static List<List<Integer>> minimumAbsDifference(int[] arr) {

		ArrayList<List<Integer>> min = new ArrayList<List<Integer>>();
		int minDiff = 900000000;

		for (int i = 0; i < arr.length; i++) {
			// loop through array to see whats the MIN difference is
			int x = 0;
			int y = 0;
			int z = 0;

			for (int j = 0; j < arr.length; j++) {
				x = arr[i];
				y = arr[j];
				// see if x is bigger than y and then subtract
				if (x > y) {
					z = x - y;
				} else {
					z = y - x;
				}

				// check if z is smaller than min diff
				if (i != j) {
					if (z < minDiff) {
						minDiff = z;
					}
				}
			}
		}

		for (int i = 0; i < arr.length - 1; i++) {
			int x = 0;
			int y = 0;
			int z = 0;
			for (int j = 0; j < arr.length; j++) {
				x = arr[i];
				y = arr[j];
				// see if x is bigger than y and then subtract
				if (x > y) {
					z = x - y;
				} else {
					z = y - x;
				}
				List<Integer> a = new ArrayList<Integer>();
				int hold = 0;
				if (y < x) {
					hold = y;
					y = x;
					x = hold;
				}
				a.add(x);
				a.add(y);
				// check if z is smaller than min diff
				if (i != j) {
					if (z == minDiff && !min.contains(a)) {
						min.add(a);
					}
				}
			}

		}
		System.out.println(minDiff);
		Collections.sort(min, new ListComparator<>());
		return min;
	}

}

class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

	@Override
	public int compare(List<T> o1, List<T> o2) {
		for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
			int c = o1.get(i).compareTo(o2.get(i));
			if (c != 0) {
				return c;
			}
		}
		return Integer.compare(o1.size(), o2.size());
	}
}
