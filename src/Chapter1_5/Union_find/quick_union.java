package Chapter1_5.Union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class quick_union {

	private int[] id;// ����id���Դ���Ϊ������
	private int count;// ��������

	// ��ʼ������id������
	public quick_union(int N) {// ��������ʶ��ʼ��N������
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
		}

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
		quick_union uf = new quick_union(N);// ��ʼ��N������
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
