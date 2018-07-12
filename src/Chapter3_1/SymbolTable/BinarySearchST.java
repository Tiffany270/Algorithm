package Chapter3_1.SymbolTable;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*二分查找（基于有序数组）
 * 该段符号表的实现用两个数组来保存键和值
 * */

public class BinarySearchST<Key extends Comparable<Key>, Value> {

	private static final int INIT_CAPACITY = 2;
	private Key[] keys;
	private Value[] vals;
	private int N;

	public BinarySearchST() {
		this(INIT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	private void resize(int capacity) {
		assert capacity >= N;
		Key[] tempk = (Key[]) new Comparable[capacity];
		Value[] tempv = (Value[]) new Object[capacity];
		for (int i = 0; i < N; i++) {
			tempk[i] = keys[i];
			tempv[i] = vals[i];
		}
		vals = tempv;
		keys = tempk;
	}

	public int size() {
		return N;
	}

	public Value get(Key key) {
		if (isEmpty()) {
			return null;
		}
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			return vals[i];
		}

		else {
			return null;
		}

	}

	public int rank(Key key) {// 二分查找运用开始

		/*
		 * 首先将key和中间键比较，如果相等则返回其索引 如果小于中间键则在左半部分查找，大于则在右半部份查找
		 */

		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}

		return lo;
	}

	public void put(Key key, Value val) {
		/* 此方法会在插入新元素前将所有较大的键向后移动一格 */

		if (key == null)
			throw new IllegalArgumentException("first argument to put() is null");

		if (val == null) {
			delete(key);
			return;
		}

		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}

		if (N == keys.length)
			resize(2 * keys.length);
		for (int j = N; j > i; j--) {
			// 注意j>i的条件，代表是较大的键需要排在前面，循环其他键向后移动
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	public void delete(Key key) {
		put(key, null);
	}

	public Key min() {
		return keys[0];

	}

	public Key max() {
		return keys[N - 1];
	}

	public Key select(int k) {
		return keys[k];
	}

	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}

	public Key floor(Key key) {
		int i = rank(key);
		return keys[i];
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		if (lo == null)
			throw new IllegalArgumentException("first argument to keys() is null");
		if (hi == null)
			throw new IllegalArgumentException("second argument to keys() is null");

		Queue<Key> queue = new Queue<Key>();
		if (lo.compareTo(hi) > 0)
			return queue;
		for (int i = rank(lo); i < rank(hi); i++)
			queue.enqueue(keys[i]);
		if (contains(hi))
			queue.enqueue(keys[rank(hi)]);
		return queue;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Iterable<Key> keys() {
		Queue<Key> q = new Queue<Key>();
		for (int i = 0; i < keys.length; i++) {
			q.enqueue(keys[i]);
		}
		return q;
	}

	public static void main(String[] args) {
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}

}
