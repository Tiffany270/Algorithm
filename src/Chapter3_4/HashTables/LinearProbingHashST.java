package Chapter3_4.HashTables;

public class LinearProbingHashST<Key, Value> {
	
	
	/*��������̽�ⷨ��ɢ�б�
	 * ԭ��������λ�������ײ��ͻ
	 * ==������ײ����ʱ��������+1����һ��λ�ã�ֱ���ҵ���λ
	 * 1.����̬������С������ֵ�Ա�̽�����ʱ�򣬶�̬��������
	 * 2.����--����λ�õļ��ͱ����ҵļ���ͬ-->�������Ļ򷵻�
	 * δ����--��������һ������
	 * 3.���أ���������Ŀ����С�ļ����ܱ�֤�ϸߵ�Ч�ʣ�Խ����Ҫ̽���Խ��
	 * */
	
	

	private int N;// ��ֵ������
	private int M = 16;// ����̽���Ĵ�С
	private Key[] keys;
	private Value[] vals;

	@SuppressWarnings("unchecked")
	public LinearProbingHashST() {
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}

	@SuppressWarnings("unchecked")
	public LinearProbingHashST(int cap) {
		keys = (Key[]) new Object[cap];
		vals = (Value[]) new Object[cap];
	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	// ���������С
	private void resize(int cap) {
		LinearProbingHashST<Key, Value> t;
		t = new LinearProbingHashST<Key, Value>(cap);
		for (int i = 0; i < M; i++) {
			if (keys[i] != null) {
				t.put(keys[i], vals[i]);
			}
		}
		keys = t.keys;
		vals = t.vals;
		M = t.M;

	}

	public void put(Key key, Value val) {

		if (N >= M / 2)
			resize(2 * M);

		int i;
		// i=(i+1)%M ���ҵ���β�����Է���ͷ��
		// keys[i] = null���˳������������ҵ���λ������
		for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;// �滻�˾��˳���������
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	public Value get(Key key) {

		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				return vals[i];
			}
		}

		return null;
	}

}
