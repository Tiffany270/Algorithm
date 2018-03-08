package Chapter1_1_Fundation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
	/*
	 * ���ֲ��� ������Ϊ�� ����һ���ļ���Ϊ���������˵���׼�����е����д������ļ��е���Ŀ������ӡ�ڰ������ϵ�������
	 */

	public static void main(String[] args) {

		int[] whitelist = StdIn.readAllInts();
		Arrays.sort(whitelist);

		List<Integer> data = read();

		for (int i = 0; i < data.size(); i++) {

			// StdOut.println(data.get(i));

			if (rank(data.get(i), whitelist) >= 0) {
				StdOut.println(data.get(i));
			}

		}

	}

	public static ArrayList<Integer> read() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner in = null;
		try {
			in = new Scanner(new File("F:\\JavaWorkspace\\Algorithm\\src\\data\\data.txt"));
			while (in.hasNext()) {
				list.add(in.nextInt());
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�û�ҵ�");
			e.printStackTrace();
		}
		in.close();
		return list;
	}

	private static int rank(int key, int[] list) {

		int lo = 0;
		int hi = list.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < list[mid]) {// �������±꣡
				hi = mid - 1;
			} else if (key > list[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}

		}

		return -1;
	}

}
