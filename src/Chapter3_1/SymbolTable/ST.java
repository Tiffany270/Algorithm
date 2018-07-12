package Chapter3_1.SymbolTable;

/*���ű�API
 * 1.ʹ�÷���
 * 2.������Ϊ��
 * 3.get�����Ƿ񷵻ؿ������Ը����ļ��Ƿ�����ڷ��ű���
 * 4.����ɾ�� ����ʱɾ��---��������Ӧ��ֵ��Ϊ��
 * ��ʹɾ��---�������ӱ���ɾ��ָ���ļ���put(key,null)
 * 5.����������ʵ�ֱ������iterator����������һ��������
 * 6.���ж��󶼼̳���equals�����������Զ���ļ���Ҫ��дequals��������
 * */

public interface ST<Key,Value> {
	public void put(Key key,Value value);
	public Value get(Key key);
	public void delete(Key key);
	public boolean contains(Key key);
	public boolean isEmpty();
	public int size();
	Iterable<Key> keys();//�����������Է��������������еļ�
}
