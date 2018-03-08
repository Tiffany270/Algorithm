package Chapter1_5_Union_find;

/*
 * ���������ÿһ������������id[]��������ݺͷ�������Ĵ���
 * */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercises1_5_1 {

	private static int[] id;// ����id���Դ���Ϊ������
	private static int count;// ��������
	private static int arrVisit=0;//������ʴ���

	// ��ʼ������id������
	public Exercises1_5_1(int N) {// ��������ʶ��ʼ��N������
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
		arrVisit++;
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
		for (int i = 0; i < id.length; i++,arrVisit++) {// ����id��id�Ѿ�����ֵ��0~9��
			if (id[i] == pID) {//�ҵ���Ҫ���ĵ�id����
				id[i] = qID; // �ؼ��Ǻ��ߵ�id��ͳһΪҪ���ߵ�id
			}
		}
		
		
		count--;// ִ��һ��unionҪ�ݼ�һ�Σ���Ҫ�Ŵ���

	}

	public static void main(String[] args) {
		// �����StdIn�õ��Ķ�̬��ͨ������
		int N = StdIn.readInt();// ��ȡ���������
		Exercises1_5_1 uf = new Exercises1_5_1(N);// ��ʼ��N������
		while (!StdIn.isEmpty()) {

			int p = StdIn.readInt();
			int q = StdIn.readInt();// ��ȡ������
			if (uf.connected(p, q))
				continue;// ����Ѿ���ͨ�����
			uf.union(p, q);// �鲢����
			StdOut.print(p + " " + q+"  id:");// ��ӡ����
			
			//��ӡId
			for (int i = 0; i < id.length; i++) {
				StdOut.print(id[i]);
			}
			
			System.out.println(" ������"+arrVisit);

		}
		StdOut.println(uf.count() + "componets");

	}

}
