package Chapter1_5.Union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class quick_union {

	private int[] id;// 分量id（以触电为索引）
	private int count;// 分量数量

	// 初始化分量id的数量
	public quick_union(int N) {// 以整数标识初始化N个触点
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}

	}

	// 连通分量的数量
	public int count() {
		return count;
	}

	// 如果p和q存在同一个分量中则返回true
	public boolean connected(int p, int q) {
		return find(p) == find(q);

	}

	// p（0~N-1）所在的分量的标识符
	private int find(int i) {
		// 找出分量的名称
		while (i != id[i]) {//寻找父节点直到根节点
			i = id[i];//这个必然存在的触点（这个触点的索引指向自己）
		}

		return i;
	}

	// 在p和q之间添加一条连接
	public void union(int p, int q) {
		// 将p和q的根节点统一
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}

		id[pRoot] = qRoot;

		count--;

	}

	public static void main(String[] args) {
		// 解决由StdIn得到的动态连通性问题
		int N = StdIn.readInt();// 读取触电的数量
		quick_union uf = new quick_union(N);// 初始化N个分量
		while (!StdIn.isEmpty()) {

			int p = StdIn.readInt();
			int q = StdIn.readInt();// 读取整数对
			if (uf.connected(p, q))
				continue;// 如果已经连通则忽略
			uf.union(p, q);// 归并分量
			StdOut.println(p + " " + q);// 打印连接

		}
		StdOut.println(uf.count() + "componets");

	}

}
