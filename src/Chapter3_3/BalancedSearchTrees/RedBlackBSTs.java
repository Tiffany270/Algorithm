package Chapter3_3.BalancedSearchTrees;

public class RedBlackBSTs<Key extends Comparable<Key>, Value> {

	/*
	 * 红黑树 红链接：将【2-结点（一个键+2个链接】连接构成【3-结点（两个键+3个链接】 黑链接：【2-3】树中的普通链接
	 * 红链接均为左链接，没有任何一个结点同时和两条红链接相连 每颗红黑树任意空链接到跟结点的路径上的黑链接数量相同
	 */

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;

	private class Node {
		Key key;
		Value val;
		Node left, right;
		int N;// 计数器
		boolean color;
		// 每个结点都只会有一条指向自己的链接（从它的父结点指向它），
		// 将链接的颜色保存在表示结点的变量中

		public Node(Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;// 由其父结点指向它链接的颜色
		}
	}

	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}

	// 往左旋转：接受一条指向红黑树中的某个结点的链接作为参数
	// 假设被指向的结点的右链接是红色的，
	// 这个方法会对树进行必要的调整并返回一个【指向包含同一组键的子树且左链接为红色的根节点的链接】

	// 两个键小-》大作为根节点
	public Node rotateLeft(Node h) {

		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;// 保留原色
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}

	// 两个键大-》小作为根节点
	public Node rotateRight(Node h) {

		Node x = h.left;
		h.left = x.right;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}

	// 颜色转换：一个结点左右链接都是红色的时候，将子节点的颜色变为黑色的同时，父结点的颜色也变红
	// 局部变换，不影响平衡
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
	 * 插入操作 原则就是：
	 * 1插入都会新增一个红色的链接，不管是左还是右
	 * 2.出现右链接是红色的，就要向左旋转
	 * 3.一个结点下的两条链接是红链接，把红链接向上传递，而两条子链接会变为黑链接
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

		//红色链接在右边
		if (isRed(h.right) && !isRed(h.left)) {
			h = rotateLeft(h);
		}
		//两条连续的红色链接
		if (isRed(h.left) && !isRed(h.left.left)) {
			h = rotateRight(h);
		}
		//两天子链接都是红色的
		if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		h.N = size(h.left) + size(h.right) + 1;

		return h;
	}

}
