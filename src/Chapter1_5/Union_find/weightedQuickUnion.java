package Chapter1_5.Union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class weightedQuickUnion {

	private int[] id;// ����id���Դ���Ϊ������
	private int count;// ��������
	private int[] size;// ���Ĵ�С��Ĭ��ÿ�������Ķ�Ӧֵ����1

	// ��ʼ������id������
	public weightedQuickUnion(int N) {// ��������ʶ��ʼ��N������
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}

		size = new int[N];
		for (int i = 0; i < N; i++) {
			size[i] = 1;

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
	public int find(int i) {
		// �������ӣ��������ҵ����ڵ�
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	// ��p��q֮�����һ������
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}

		// ��С���ĸ��ڵ����ӵ������ĸ��ڵ�
		if (size[i] < size[j]) {//�Ƚ����Ĵ�С
			id[i] = j;//��id�۸�Ϊ�����ĸ��ڵ��ֵ
			size[j] += size[i];// sizeҪ���sz[j]=sz[i]+sz[j]
		} else {
			size[j] = i;
			size[i] += size[j];
		}
		count--;

	}

	public static void main(String[] args) {
		// �����StdIn�õ��Ķ�̬��ͨ������
		int N = StdIn.readInt();// ��ȡ���������
		weightedQuickUnion uf = new weightedQuickUnion(N);// ��ʼ��N������
		while (!StdIn.isEmpty()) {

			int p = StdIn.readInt();
			int q = StdIn.readInt();// ��ȡ������
			if (uf.connected(p, q))
				continue;// ����Ѿ���ͨ�����
			uf.union(p, q);// �鲢����
			StdOut.println(p + " " + q);// ��ӡ����

		}
		StdOut.println(uf.count() + "componets");

	}

}
