package Chapter3_2.BinarySearchTree;

import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {

	/*
	 * ��������� 
	 * 1.�ܽ�������������Ժ�����������ҵĸ�Ч�Խ������ ���ݽṹ�ɽ����� --��ÿ�����ֻ��һ������㣨���ڵ���⣩��
	 * ÿ����㶼ֻ�������������ӣ��ֱ�ָ���Լ������ӽڵ�����ӽڵ㡣 
	 * ÿ�����ӿ���ָ����һ�Ŷ����� ��������һ������ֵ����֮��Ҳ��˳��֮����֧�ָ�Ч�Ĳ���
	 * 2.ÿ���ڵ㶼����һ��Comparable�ļ� ��ÿ�����ļ�����������������������ļ��� 
	 * ��С����������������ļ�
	 *  3.���ҺͲ��붼�����˵ݹ��㷨
	 */

	private Node root;

	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int N;// ������

		// Ƕ�׶���˽��������ʾ����������ϵĽ��
		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}

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

	/* ========����====== */
	public Value get(Key key) {

		return get(root, key);

	}

	private Value get(Node x, Key key) {

		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	/* ====����===== */
	public void put(Key key, Value val) {
		root = put(root, key, val);

	}

	private Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		} else
			x.val = val;
		x.N = size(x.left) + size(x.right) + 1;// ���ü�����
		return x;

	}

	/*
	 * ��С����
	 * ���������Ϊ�գ�һ�Ŷ������������С�ļ����Ǹ��ڵ� ��������Ӳ�Ϊ�գ���ô������С�������������е���С�� 
	 * ����ͬ��
	 */
	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		return min(x.left);
	}

	public Key max() {
		return max(root).key;
	}

	private Node max(Node x) {
		if (x.right == null)
			return x;
		return min(x.right);
	}

	public Key floor(Key key) {

		Node x = floor(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	/*
	 * ����ȡ�� ����ĳ�������������е�ʱ�򣬾ͻ᷵����һ����
	 */
	private Node floor(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		}
		if (cmp < 0) {
			return floor(x.left, key);
		}
		Node t = floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;
	}

	public Key select(int k) {
		return select(root, k).key;
	}

	/* ���� */
	private Node select(Node x, int k) {
		if (x == null)
			return null;
		int t = size(x.left);
		if (t > k)
			return select(x.left, k);
		else if (t < k)
			return select(x.right, k - t - 1);
		else

			return x;
	}

	/*
	 * ���ظ��������������������ָ���Ǹ��ڵ������������
	 */
	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		if (x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)// ��ߣ����ظü������������������ݹ飩
			return rank(key, x.left);
		else if (cmp > 0)// �ݹ飬�����ڵ����ʱ�����ұߣ���Ҫ���ϸ��ڵ㣬���Լ�һ
			return 1 + size(x.left) + rank(key, x.right);
		else// ��ȣ����ظü����������еĽ������
			return size(x.left);
	}

	/* ��Χ���� */
	public Iterable<Key> keys() {

		return keys(min(), max());

	}

	private Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	// ��������������
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null)
			return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0)
			keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0)
			queue.enqueue(x.key);
		if (cmphi > 0)
			keys(x.right, queue, lo, hi);

	}

	/*
	 * ɾ����С�� ���������������������ֱ������һ�������ӣ�
	 * Ȼ�󽫸ý�������ָ��ý��������� ��û���κ�����ָ��Ľ��ᱻɾ�����������ռ��������
	 */
	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {

		if (x.left == null) {
			return x.right;// �᷵�ر�ɾ���Ľڵ㡣
			// ע��put�Ǵ������ҵģ��������left����=null��ʱ���������ж��
		}
		x.left = deleteMin(x.left);// �ݹ����
		x.N = size(x.left) + size(x.right) + 1;

		return x;
	}

	/*ɾ������
	 * ʵ�ʣ���Ҫ��ɾ���Ľ��x�������ĺ�̽�������λ�ã���̽����������������С��㣩
	 * ȱ�ݣ���̽���ѡ����һ������ľ�������û�п������ĶԳ��ԣ��������������
	 * */
	
	public void delete(Key key) {

		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {

		if (x == null)
			return null;

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = delete(x.left, key);
		} // Ѱ�ұ�ɾ���Ľ��
		else if (cmp > 0) {
			x.right = delete(x.right, key);
		} else {
			if (x.right == null) {
				return x.left;
			}
			if (x.left == null) {
				return x.right;
			}
			Node t = x;// ��ָ�򼴽���ɾ���Ľ������ӱ���Ϊt
			// ��xָ�����ĺ�̽��
			x = min(t.right);// �������̽ڵ����������������С���--����̽��Ҫ�������汻ɾ������λ�ã�
			x.right = deleteMin(t.right);
			x.left = t.left;// ��x����������Ϊt.left����ΪtҪ��ɾ���ˣ�
		}
		// ��������ĸ��ڵ�������ʵ�ǣ���һ����.leftһֱ��x�����Ը���x�����ˣ�ָ��һֱ��x�����
		x.N = size(x.left) + size(x.right) + 1;// ���ý����
		return x;
	}

}
