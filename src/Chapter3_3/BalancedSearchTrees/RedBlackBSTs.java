package Chapter3_3.BalancedSearchTrees;

public class RedBlackBSTs<Key extends Comparable<Key>, Value> {

	/*
	 * ����� �����ӣ�����2-��㣨һ����+2�����ӡ����ӹ��ɡ�3-��㣨������+3�����ӡ� �����ӣ���2-3�����е���ͨ����
	 * �����Ӿ�Ϊ�����ӣ�û���κ�һ�����ͬʱ���������������� ÿ�ź������������ӵ�������·���ϵĺ�����������ͬ
	 */

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;

	private class Node {
		Key key;
		Value val;
		Node left, right;
		int N;// ������
		boolean color;
		// ÿ����㶼ֻ����һ��ָ���Լ������ӣ������ĸ����ָ��������
		// �����ӵ���ɫ�����ڱ�ʾ���ı�����

		public Node(Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;// ���丸���ָ�������ӵ���ɫ
		}
	}

	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}

	// ������ת������һ��ָ�������е�ĳ������������Ϊ����
	// ���豻ָ��Ľ����������Ǻ�ɫ�ģ�
	// ���������������б�Ҫ�ĵ���������һ����ָ�����ͬһ�����������������Ϊ��ɫ�ĸ��ڵ�����ӡ�

	// ������С-������Ϊ���ڵ�
	public Node rotateLeft(Node h) {

		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;// ����ԭɫ
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}

	// ��������-��С��Ϊ���ڵ�
	public Node rotateRight(Node h) {

		Node x = h.left;
		h.left = x.right;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}

	// ��ɫת����һ������������Ӷ��Ǻ�ɫ��ʱ�򣬽��ӽڵ����ɫ��Ϊ��ɫ��ͬʱ����������ɫҲ���
	// �ֲ��任����Ӱ��ƽ��
	public void flipColors(Node h) {

		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;

	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	/*
	 * ������� ԭ����ǣ�
	 * 1���붼������һ����ɫ�����ӣ�������������
	 * 2.�����������Ǻ�ɫ�ģ���Ҫ������ת
	 * 3.һ������µ����������Ǻ����ӣ��Ѻ��������ϴ��ݣ������������ӻ��Ϊ������
	 */

	public void put(Key key, Value val) {
		root = put(root, key, val);
		root.color = BLACK;
	}

	private Node put(Node h, Key key, Value val) {
		if (h == null)
			return new Node(key, val, 1, RED);

		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = put(h.left, key, val);
		else if (cmp < 0)
			h.right = put(h.right, key, val);
		else
			h.val = val;

		//��ɫ�������ұ�
		if (isRed(h.right) && !isRed(h.left)) {
			h = rotateLeft(h);
		}
		//���������ĺ�ɫ����
		if (isRed(h.left) && !isRed(h.left.left)) {
			h = rotateRight(h);
		}
		//���������Ӷ��Ǻ�ɫ��
		if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		h.N = size(h.left) + size(h.right) + 1;

		return h;
	}

}
