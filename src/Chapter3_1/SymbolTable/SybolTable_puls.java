package Chapter3_1.SymbolTable;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class SybolTable_puls<Key extends Comparable<Key>, Value> {
	
	/*有序符号表：测试用例的时候会将键按顺序打印出来，是一种索引用例*/

	public void put(Key key, Value value) {

		// 防御性代码
		if (value == null) {
			delete(key);
			return;
		}

	}

	public Value get(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Key key) {
		put(key, null);
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterable<Key> keys() {
		return null;
	}

	public Key min() {
		return null;
	}

	public Key max() {
		return null;
	}

	public Key floor(Key key) {
		return null;
	}

	public Key ceiling(Key key) {
		return null;
	}

	public int rank(Key key) {
		return 0;
	}

	public Key select(int k) {
		return null;
	}

	public void deleteMin() {
		delete(min());
	}

	public void deleteMax() {
		delete(max());

	}

	public int size(Key lo, Key hi) {
		if (lo.compareTo(lo) < 0) {
			return 0;
		} else if (contains(hi)) {
			return rank(hi) - rank(lo) + 1;
		} else {
			return rank(hi) - rank(lo);
		}
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		return keys(min(), max());
	}

}
