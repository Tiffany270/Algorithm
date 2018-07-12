package Chapter3_1.SymbolTable;

/*Ordered symbol tables.
 * ������ű�*/

public interface ST_puls<Key,Value> {
	public void put(Key key,Value value);
	public Value get(Key key);
	public void delete(Key key);
	public boolean contains(Key key);
	public boolean isEmpty();
	public int size();
	public Key min();
	public Key max();
	public Key floor(Key key);//С�ڵ���key�����ֵ
	public Key ceiling(Key key);//���ڵ���key����Сֵ
	public int rank(Key key);//С��key��������
	public Key select(int k);//����Ϊk�ļ�
	public void deleteMin();
	public void deleteMax();
	public int size(Key lo,Key hi);//lo..hi֮���������
	public Iterable<Key> keys(Key lo,Key hi);//lo..hi֮������м���������
	Iterable<Key> keys();//�����������Է��������������еļ������м��ļ��ϣ�������
}
