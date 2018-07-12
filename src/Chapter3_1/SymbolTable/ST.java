package Chapter3_1.SymbolTable;

/*符号表API
 * 1.使用泛型
 * 2.键不能为空
 * 3.get方法是否返回空来测试给定的键是否存在于符号表中
 * 4.关于删除 ：延时删除---》将键对应的值置为空
 * 即使删除---》立即从表中删除指定的键如put(key,null)
 * 5.迭代：所有实现必须包含iterator方法来返回一个迭代器
 * 6.所有对象都继承了equals（）方法，自定义的键需要重写equals（）方法
 * */

public interface ST<Key,Value> {
	public void put(Key key,Value value);
	public Value get(Key key);
	public void delete(Key key);
	public boolean contains(Key key);
	public boolean isEmpty();
	public int size();
	Iterable<Key> keys();//包含迭代器以方便用例遍历所有的键
}
