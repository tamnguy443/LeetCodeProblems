/*
December 17th 2021

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

*/
class Solution {
	public static int maximalSquare(char[][] matrix) {
		// keep track of max row and col of 1, m x n
		int maxM = 0;
		// has to be a square so, m = n, row x col
		for (int i = 0; i < matrix.length; i++) {
			// loop thru row
			for (int j = 0; j < matrix[i].length; j++) {
				// loop thru col
				if (matrix[i][j] == '1') {
					int tempRow = 0;
					// sends to countOnes to read how many there are in row
					tempRow = countOnesRow(matrix, i, j);

					// check if the number is going to go past the col limit
					if (tempRow < matrix[i].length) {
						System.out.println(tempRow);
						int temp = 0;
						for (int k = 0; k < tempRow; k++) {

							// run down the col and see if they all have 1s same
							if (countOnesCol(matrix, i, j) == tempRow) {
								temp++;
							}
						}

						// check if temp == tempRow so it is a square of 1s
						if (temp == tempRow) {
							// check if tempRow is bigger than maxM
							if (maxM < tempRow) {
								maxM = tempRow;
							}
						}
					} else {
						maxM = 1;
					}

				}
			}
		}

		return maxM * maxM;
	}

	public static int countOnesRow(char[][] matrix, int indi, int indj) {
		// to count how many ones following at the index on a ROW
		int count = 0;
//		System.out.println(indi + ":" + indj);
		for (int j = indj; j < matrix.length; j++) {
			// starts at ind stops when encounter 0
			if (matrix[indi][j] == '1') {
				count++;

			} else {// 1 2
				if (count == 0) {
					count = 1;
				} else {
					return count;
				}
				break;
			}
		}

		return count;
	}

	public static int countOnesCol(char[][] matrix, int indi, int indj) {
		// to count how many ones following at the index on a Col
		int count = 0;
//		System.out.println(indi + ":" + indj);
		for (int i = indi; i < matrix[indi].length - 1; i++) {
			// starts at ind stops when encounter 0
			if (matrix[i][indj] == '1') {
				count++;

			} else {// 1 2
				if (count == 0) {
					count = 1;
				} else {
					return count;
				}
				break;
			}
		}

		return count;
	}
} 
