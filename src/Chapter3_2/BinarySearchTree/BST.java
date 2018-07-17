package Chapter3_2.BinarySearchTree;

import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {

	/*
	 * 二叉查找树 
	 * 1.能将链表插入的灵活性和有序数组查找的高效性结合起来 数据结构由结点组成 --》每个结点只有一个父结点（根节点除外），
	 * 每个结点都只有左右两个链接，分别指向自己的左子节点和右子节点。 
	 * 每个链接看作指向另一颗二叉树 结点包含了一个键和值，键之间也有顺序之分以支持高效的查找
	 * 2.每个节点都含有一个Comparable的键 且每个结点的键都大于其左子树的任意结点的键， 
	 * 而小于右子树的任意结点的键
	 *  3.查找和插入都运用了递归算法
	 */

	private Node root;

	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int N;// 计数器

		// 嵌套定义私有类来表示二叉查找树上的结点
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

	/* ========查找====== */
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

	/* ====插入===== */
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
		x.N = size(x.left) + size(x.right) + 1;// 重置计数器
		return x;

	}

	/*
	 * 最小键：
	 * 如果左链接为空，一颗二叉查找树中最小的键就是根节点 如果左链接不为空，那么树中最小键就是左子树中的最小键 
	 * 最大键同理
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
	 * 向上取整 当在某个子树不能命中的时候，就会返回上一层结点
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

	/* 排名 */
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
	 * 返回给定键的排名（这个排名指的是根节点个数的排名）
	 */
	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		if (x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)// 左边，返回该键在左子树的排名（递归）
			return rank(key, x.left);
		else if (cmp > 0)// 递归，并且在到达的时候，在右边，是要加上根节点，所以加一
			return 1 + size(x.left) + rank(key, x.right);
		else// 相等，返回该键在左子树中的结点总数
			return size(x.left);
	}

	/* 范围查找 */
	public Iterable<Key> keys() {

		return keys(min(), max());

	}

	private Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	// 中序遍历，左根右
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
	 * 删除最小键 不断深入根结点的左子树中直到遇到一个空链接，
	 * 然后将该结点的链接指向该结点的右子树 而没有任何链接指向的结点会被删除并被垃圾收集器清理掉
	 */
	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {

		if (x.left == null) {
			return x.right;// 会返回被删除的节点。
			// 注意put是从左至右的，不会存在left子树=null的时候右子树有多层
		}
		x.left = deleteMin(x.left);// 递归更新
		x.N = size(x.left) + size(x.right) + 1;

		return x;
	}

	/*删除操作
	 * 实质：用要被删除的结点x后用它的后继结点填补它的位置（后继结点是其右子树的最小结点）
	 * 缺陷：后继结点的选择是一个随意的决定，且没有考虑树的对称性，会产生性能问题
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
		} // 寻找被删除的结点
		else if (cmp > 0) {
			x.right = delete(x.right, key);
		} else {
			if (x.right == null) {
				return x.left;
			}
			if (x.left == null) {
				return x.right;
			}
			Node t = x;// 将指向即将被删除的结点的链接保存为t
			// 将x指向它的后继结点
			x = min(t.right);// （这个后继节点就是其右子树的最小结点--》后继结点要用来顶替被删除结点的位置）
			x.right = deleteMin(t.right);
			x.left = t.left;// 将x的左链接设为t.left（因为t要被删除了）
		}
		// 这里困惑的根节点连接其实是：上一层结点.left一直是x，所以更新x就行了，指向一直是x不变的
		x.N = size(x.left) + size(x.right) + 1;// 重置结点数
		return x;
	}

}
