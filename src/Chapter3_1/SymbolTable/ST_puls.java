package Chapter3_1.SymbolTable;

/*Ordered symbol tables.
 * 有序符号表*/

public interface ST_puls<Key,Value> {
	public void put(Key key,Value value);
	public Value get(Key key);
	public void delete(Key key);
	public boolean contains(Key key);
	public boolean isEmpty();
	public int size();
	public Key min();
	public Key max();
	public Key floor(Key key);//小于等于key的最大值
	public Key ceiling(Key key);//大于等于key的最小值
	public int rank(Key key);//小于key键的数量
	public Key select(int k);//排名为k的键
	public void deleteMin();
	public void deleteMax();
	public int size(Key lo,Key hi);//lo..hi之间键的数量
	public Iterable<Key> keys(Key lo,Key hi);//lo..hi之间的所有键（已排序）
	Iterable<Key> keys();//包含迭代器以方便用例遍历所有的键，所有键的集合，已排序
}
