package Chapter1_5_Union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class quick_find {

	private int[] id;// 分量id（以触电为索引）
	private int count;// 分量数量

	// 初始化分量id的数量
	public quick_find(int N) {// 以整数标识初始化N个触点
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
	public int find(int p) {
		return id[p];
	}

	// 在p和q之间添加一条连接
	public void union(int p, int q) {
		// 将p和q归并到相同的分量中
		// 实质上就是篡改id

		int pID = find(p);
		int qID = find(q);

		// 如果p和q已经在相同的分量之中则不需要采取任何行动
		if (pID == qID) {
			return;
		}

		// 将p的分量重命名为q的名称（篡改id）
		for (int i = 0; i < id.length; i++) {// 遍历id，id已经被赋值过0~9了
			if (id[i] == pID) {//找到需要更改的id索引
				id[i] = qID; // 关键是后者的id，统一为要后者的id
			}
		}
		count--;// 执行一次union要递减一次，不要放错了

	}

	public static void main(String[] args) {
		// 解决由StdIn得到的动态连通性问题
		int N = StdIn.readInt();// 读取触点的数量
		quick_find uf = new quick_find(N);// 初始化N个分量
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
