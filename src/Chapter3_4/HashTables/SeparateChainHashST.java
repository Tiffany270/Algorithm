package Chapter3_4.HashTables;

import edu.princeton.cs.algs4.SequentialSearchST;

public class SeparateChainHashST<Key, Value> {
	
	
	/*基于拉链法的散列表
	 * 为M个元素分别构建符号表来保存散列到里面的键（效率稍低）
	 * 此符号表实现维护着一条链表的数组
	 * 如果需要快速找到最大或者最小的键，或是查找某给范围内的键，散列表不是合适的选择
	 * */
	

	private int N;// 键值对总数
	private int M;// 散列表的大小
	// 顺序查找（基于无序链表）形成的存放链表对象的数组
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
