package Chapter4_1.UndirectedGraphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/*无向图*/

public class Graph {

	/*
	 * 对于一个final变量， 
	 * 如果是基本数据类型的变量， 
	 * 则其数值一旦在初始化之后便不能更改； 如果是引用类型的变量，
	 * 则在对其初始化之后便不能再让其指向另一个对象。
	 */

	private int V; // 顶点数目
	private int E; // 边的数目
	private Bag<Integer>[] adj; // 邻接表

	@SuppressWarnings("unchecked")
	public Graph(int V) {

		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];  // 创建邻接表
		for (int v = 0; v < V; v++) { 		// 将邻接表里的每一项的链表初始化为空
			adj[v] = new Bag<Integer>();
		}

	}

	public Graph(In in) {

		this(in.readInt()); 		// 读取V并将图初始化
		int E = in.readInt(); 		// 读取E(边）
		for (int i = 0; i < E; i++) {
			// 添加一条边
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {

		/* 要添加一条连接v与w的边
		 * 我们将w添加到v的邻接表中并把v添加到w的邻接表中 */

		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	//和v相邻的所有顶点
	public Iterable<Integer> adj(int v) {
		return adj[v];

	}

	// 计算v的度数，度数=边的总数
	public int degree(Graph G, int v) {

		int degree = 0;
		for (int w : G.adj(v)) {
			degree++;
		}
		return degree;
	}

	// 计算所有顶点的最大度数
	public int maxDegree(Graph G) {

		int max = 0;
		for (int v = 0; v < G.V(); v++) {
			if (degree(G, v) > max)
				max = degree(G, v);
		}
		return max;
	}

	// 计算所有顶点的平均度数
	public double avgDegree(Graph G) {

		return 2.0 * G.E() / G.V();

	}

	// 计算自环的个数
	public int numberOfSelfLoops(Graph G) {

		int count = 0;
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				if (v == w) {
					count++;
				}
			}
		}

		return count / 2;// 每条边都被记过两次

	}

	// 图的邻接表的字符串表示
	public String toString() {

		String s = V + "vertices, " + E + " edges\n";
		for (int v = 0; v < V; v++) {
			s += v + ":";
			for (int w : this.adj(v)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
	
	
	
	
	
	
	
	
	
}
