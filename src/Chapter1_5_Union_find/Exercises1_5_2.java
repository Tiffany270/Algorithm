package Chapter1_5_Union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercises1_5_2 {
	/*quick-union�㷨
	 * ���������ÿһ������������id[]��������ݺͷ�������Ĵ���
	 * */

	private static int[] id;// ����id���Դ���Ϊ������
	private static int count;// ��������
	private static int arrVisit = 0;// ������ʴ���

	// ��ʼ������id������
	public Exercises1_5_2(int N) {// ��������ʶ��ʼ��N������
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}

	}

	// ��ͨ����������
	public int count() {
		return count;
	}

	// ���p��q����ͬһ���������򷵻�true
	public boolean connected(int p, int q) {
		return find(p) == find(q);

	}

	// p��0~N-1�����ڵķ����ı�ʶ��
	private int find(int i) {
		
		
		
		// �ҳ�����������
		while (i != id[i]) {//Ѱ�Ҹ��ڵ�ֱ�����ڵ�
			i = id[i];//�����Ȼ���ڵĴ��㣨������������ָ���Լ���
			arrVisit++;
		}
		arrVisit++;

		return i;
	}

	// ��p��q֮�����һ������
	public void union(int p, int q) {
		// ��p��q�ĸ��ڵ�ͳһ
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}

		id[pRoot] = qRoot;

		count--;

	}

	public static void main(String[] args) {
		// �����StdIn�õ��Ķ�̬��ͨ������
		int N = StdIn.readInt();// ��ȡ���������
		Exercises1_5_2 uf = new Exercises1_5_2(N);// ��ʼ��N������
		while (!StdIn.isEmpty()) {

			int p = StdIn.readInt();
			int q = StdIn.readInt();// ��ȡ������
			if (uf.connected(p, q))
				continue;// ����Ѿ���ͨ�����
			uf.union(p, q);// �鲢����
			StdOut.print(p + " " + q + "  id:");// ��ӡ����

			// ��ӡId
			for (int i = 0; i < id.length; i++) {
				StdOut.print(id[i]);
			}

			System.out.println(" ������" + arrVisit);

		}
		StdOut.println(uf.count() + "componets");


	}

}
