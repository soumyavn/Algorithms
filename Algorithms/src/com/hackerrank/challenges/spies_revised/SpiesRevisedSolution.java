package com.hackerrank.challenges.spies_revised;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SpiesRevisedSolution {

	static final int N = 99;
	static int count;
	static int[] result = new int[N];
	static int[][] mtrx = new int[N][N];

	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			result[i] = -1;
		}

		for (int j = 0; j < N; j++)
			for (int k = 0; k < N; k++)
				mtrx[j][k] = 0;
		count = checkSolution(0);

		System.out.println(N);
		String output = "" + result[0];
		for (int i = 1; i < N; i++) {
			output = output + " " + result[i];
		}
		System.out.println(output);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)

				if (mtrx[i][j] == -1)
					System.out.print('S' + " ");
				else
					System.out.print('*' + " ");

			System.out.println();
		}

	}

	static void checkColumn(int col, boolean isReverse) {
		if (isReverse) {
			for (int j = 0; j < N; j++) {
				if (mtrx[j][col] > 0)
					mtrx[j][col]--;

			}
		} else {
			for (int j = 0; j < N; j++) {
				if (mtrx[j][col] != -1)
					mtrx[j][col]++;

			}
		}

	}

	static void checkRow(int row, boolean isReverse) {
		if (isReverse) {
			for (int i = 0; i < N; i++) {
				if (mtrx[row][i] > 0)
					mtrx[row][i]--;

			}
		} else {
			for (int i = 0; i < N; i++) {
				if (mtrx[row][i] != -1)
					mtrx[row][i]++;

			}
		}

	}

	static void checkRDiag(int row, int col) {
		int dcolumn = col + 1;
		for (int i = row + 1; i < N; i++) {
			if (dcolumn >= N) {
				break;
			}
			if (mtrx[i][dcolumn] != -1) {
				mtrx[i][dcolumn]++;
			}
			dcolumn++;
		}

	}

	static void checkLDiag(int row, int col) {
		int dcolumn = col - 1;
		for (int i = row + 1; i < N; i++) {
			if (dcolumn < 0) {
				break;
			}
			if (mtrx[i][dcolumn] != -1) {
				mtrx[i][dcolumn]++;
			}
			dcolumn--;
		}

	}

	static void checkLine(int row, int col, boolean isReverse) {

		int bc;
		int br;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < N; j++) {

				if (mtrx[i][j] == -1) {
					if (j == col || i + j == (row + col) || i - j == (row - col)) {
						break;
					}
					br = i;
					bc = j;
					if (isReverse)
						blockLine(br, bc, row, col, true);
					else
						blockLine(br, bc, row, col, false);

					break;
				}
			}
		}

	}

	static void blockLine(int brow, int bcol, int row, int col, boolean isReverse) {
		int iInc = row - brow;
		int jInc = col - bcol;
		int j = col + jInc;
		System.out.println(iInc + " " + jInc);
		for (int i = row + iInc; i < N; i = i + iInc) {
			if (j >= N || j < 0) {
				break;
			}
			if (isReverse) {
				if (mtrx[i][j] > 0)
					mtrx[i][j]--;
			} else {
				if (mtrx[i][j] != -1) {
					mtrx[i][j]++;
				}
			}
			j = j + jInc;
		}
	}

	static void revCheckRDiag(int row, int col) {
		int dcolumn = col + 1;
		for (int i = row + 1; i < N; i++) {
			if (dcolumn >= N) {
				break;
			}
			if (mtrx[i][dcolumn] > 0) {
				mtrx[i][dcolumn]--;
			}
			dcolumn++;
		}

	}

	static void revCheckLDiag(int row, int col) {
		int dcolumn = col - 1;
		for (int i = row + 1; i < N; i++) {
			if (dcolumn < 0) {
				break;
			}
			if (mtrx[i][dcolumn] > 0) {
				mtrx[i][dcolumn]--;
			}
			dcolumn--;
		}

	}

	static int checkSolution(int row) {

		int count = 0;
		for (int col = 0; col < N; col++) {
			count = 0;
			if (mtrx[row][col] == 0) {

				mtrx[row][col] = -1;
				result[row] = col + 1;
				// criteria -1
				checkColumn(col, false);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++)

						System.out.print(mtrx[i][j] + " ");

					System.out.println();
				}
				System.out.println();
				// Criteria 2
				checkRow(row, false);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++)

						System.out.print(mtrx[i][j] + " ");

					System.out.println();
				}
				System.out.println();
				// crteria 3
				checkRDiag(row, col);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++)

						System.out.print(mtrx[i][j] + " ");

					System.out.println();
				}
				System.out.println();
				// criteria 4
				checkLDiag(row, col);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++)

						System.out.print(mtrx[i][j] + " ");

					System.out.println();
				}
				System.out.println();
				// Criteria 5
				checkLine(row, col, false);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++)

						System.out.print(mtrx[i][j] + " ");

					System.out.println();
				}
				System.out.println();
				// checkLine2(row, col);
				if (row == N - 1) {
					count++;
					break;
				} else {
					count = checkSolution(row + 1);
					if (count == N - row - 1) {
						count++;
						break;
					} else {
						// criteria -1
						mtrx[row][col] = 0;
						result[row] = 0;
						checkColumn(col, true);
						// Criteria 2
						checkRow(row, true);
						// crteria 3
						revCheckRDiag(row, col);
						// criteria 4
						revCheckLDiag(row, col);
						// Criteria 5
						checkLine(row, col, true);
						// revCheckLine2(row, col);
					}

				}

			}

		}
		return count;
	}
}
