package Chapter2_4.PriorityQueue;

public class MaxPQ<Key extends Comparable<Key>> {

	private Key[] pq;// ���ڶѵ���ȫ������
	private int N = 0;

	MaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];

	}

	public void insert(Key v) {
		pq[++N] = v;
		swim(N);

	}
	
	public Key delMax() {
		Key max= pq[1];
		exch(1,N--);
		pq[N+1]=null;
		sink(1);
		return max;
	}

	private void sink(int k) {//�³�
		while(2*k<=N) {
			int j=2*k;
			if(j<N&&less(j,j+1)) {
				j++;
			}
			if(!less(k,j))break;
			exch(k,j);
			k=j;
		}
	}

	private void swim(int k) {// �ϸ�
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void exch(int i, int j) {
		Key t = pq[i] = pq[j];
		pq[j] = t;
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	public boolean isEmpaty() {
		return N == 0;
	}

	public int size() {
		return N;
	}
	

	
}
