package Chapter3_4.HashTables;

public class LinearProbingHashST<Key, Value> {
	
	
	/*基于线性探测法的散列表
	 * 原理：依靠空位来解决碰撞冲突
	 * ==》当碰撞发生时，将索引+1找下一个位置，直到找到空位
	 * 1.允许动态调整大小，当键值对比探测表大的时候，动态调整数组
	 * 2.命中--》该位置的键和被查找的键相同-->插入或更改或返回
	 * 未命中--》索引加一往后找
	 * 3.键簇：连续的条目，短小的键簇能保证较高的效率，越长需要探测就越多
	 * */
	
	

	private int N;// 键值对总数
	private int M = 16;// 线性探测表的大小
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

	// 调整数组大小
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
		// i=(i+1)%M 查找到了尾部可以返回头部
		// keys[i] = null是退出条件，代表找到空位插入了
		for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;// 替换了就退出整个函数
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
