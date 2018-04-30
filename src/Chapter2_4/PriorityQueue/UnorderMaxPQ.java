package Chapter2_4.PriorityQueue;

public class UnorderMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;// ���ڶѵ���ȫ������
	private int N = 0;

	public UnorderMaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity];
	}

	public Key delMax() {//ɾ�������
		int max = 0;
		for (int i = 1; i < N; i++) {
			if (less(max, i))//�Ƚ�
				max = i;
		}
		exch(max, N - 1);//�����һ������
		return pq[--N];
	}

	public boolean isEmpaty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void insert(Key v) {

		pq[N++] = v;

	}

	private void exch(int i, int j) {
		Key t = pq[i] = pq[j];
		pq[j] = t;
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

}
