package Chapter3_1.SymbolTable;

public class SybolTable<Key extends Comparable<Key>, Value> {
	
	
	/*���ű�ļ�ʵ�֣�����ʱ������������м���˳���ǲ�ȷ����*/

	public void put(Key key, Value value) {
		
		//�����Դ���
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
