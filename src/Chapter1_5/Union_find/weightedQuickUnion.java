package Chapter1_5.Union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class weightedQuickUnion {

	private int[] id;// 分量id（以触电为索引）
	private int count;// 分量数量
	private int[] size;// 树的大小，默认每个索引的对应值都是1

	// 初始化分量id的数量
	public weightedQuickUnion(int N) {// 以整数标识初始化N个触点
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}

		size = new int[N];
		for (int i = 0; i < N; i++) {
			size[i] = 1;

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
	public int find(int i) {
		// 跟随链接（索引）找到根节点
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	// 在p和q之间添加一条连接
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}

		// 将小树的根节点连接到大树的根节点
		if (size[i] < size[j]) {//比较树的大小
			id[i] = j;//把id篡改为大树的根节点的值
			size[j] += size[i];// size要变大，sz[j]=sz[i]+sz[j]
		} else {
			size[j] = i;
			size[i] += size[j];
		}
		count--;

	}

	public static void main(String[] args) {
		// 解决由StdIn得到的动态连通性问题
		int N = StdIn.readInt();// 读取触电的数量
		weightedQuickUnion uf = new weightedQuickUnion(N);// 初始化N个分量
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
