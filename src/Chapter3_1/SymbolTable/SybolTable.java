package Chapter3_1.SymbolTable;

public class SybolTable<Key extends Comparable<Key>, Value> {
	
	
	/*符号表的简单实现：测试时，用例的输出中键的顺序是不确定的*/

	public void put(Key key, Value value) {
		
		//防御性代码
		if (value == null) {
			delete(key);
			return;
		}

	}

	public Value get(Key key) {

		return null ;
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

}
