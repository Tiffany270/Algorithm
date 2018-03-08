package Chapter1_5_Union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class quick_find {

	private int[] id;// ����id���Դ���Ϊ������
	private int count;// ��������

	// ��ʼ������id������
	public quick_find(int N) {// ��������ʶ��ʼ��N������
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
	public int find(int p) {
		return id[p];
	}

	// ��p��q֮�����һ������
	public void union(int p, int q) {
		// ��p��q�鲢����ͬ�ķ�����
		// ʵ���Ͼ��Ǵ۸�id

		int pID = find(p);
		int qID = find(q);

		// ���p��q�Ѿ�����ͬ�ķ���֮������Ҫ��ȡ�κ��ж�
		if (pID == qID) {
			return;
		}

		// ��p�ķ���������Ϊq�����ƣ��۸�id��
		for (int i = 0; i < id.length; i++) {// ����id��id�Ѿ�����ֵ��0~9��
			if (id[i] == pID) {//�ҵ���Ҫ���ĵ�id����
				id[i] = qID; // �ؼ��Ǻ��ߵ�id��ͳһΪҪ���ߵ�id
			}
		}
		count--;// ִ��һ��unionҪ�ݼ�һ�Σ���Ҫ�Ŵ���

	}

	public static void main(String[] args) {
		// �����StdIn�õ��Ķ�̬��ͨ������
		int N = StdIn.readInt();// ��ȡ���������
		quick_find uf = new quick_find(N);// ��ʼ��N������
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
