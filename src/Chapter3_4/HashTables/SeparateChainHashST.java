package Chapter3_4.HashTables;

import edu.princeton.cs.algs4.SequentialSearchST;

public class SeparateChainHashST<Key, Value> {
	
	
	/*������������ɢ�б�
	 * ΪM��Ԫ�طֱ𹹽����ű�������ɢ�е�����ļ���Ч���Եͣ�
	 * �˷��ű�ʵ��ά����һ�����������
	 * �����Ҫ�����ҵ���������С�ļ������ǲ���ĳ����Χ�ڵļ���ɢ�б��Ǻ��ʵ�ѡ��
	 * */
	

	private int N;// ��ֵ������
	private int M;// ɢ�б�Ĵ�С
	// ˳����ң��������������γɵĴ��������������
	private SequentialSearchST<Key, Value>[] st;

	public SeparateChainHashST() {
		this(997);
	}

	@SuppressWarnings("unchecked")
	public SeparateChainHashST(int M) {

		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];

		for (int i = 0; i < M; i++) {
			st[i] = new SequentialSearchST<Key, Value>();
		}

	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7ffffff) % M;
	}

	public Value get(Key key) {
		return (Value) st[hash(key)].get(key);
	}

	public void put(Key key, Value val) {
		st[hash(key)].put(key, val);
	}

	public Iterable<Key> keys() {
		return null;
	}

}
