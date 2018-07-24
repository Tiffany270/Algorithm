package Chapter4_1.UndirectedGraphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/*����ͼ*/

public class Graph {

	/*
	 * ����һ��final������ 
	 * ����ǻ����������͵ı����� 
	 * ������ֵһ���ڳ�ʼ��֮��㲻�ܸ��ģ� ������������͵ı�����
	 * ���ڶ����ʼ��֮��㲻��������ָ����һ������
	 */

	private int V; // ������Ŀ
	private int E; // �ߵ���Ŀ
	private Bag<Integer>[] adj; // �ڽӱ�

	@SuppressWarnings("unchecked")
	public Graph(int V) {

		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];  // �����ڽӱ�
		for (int v = 0; v < V; v++) { 		// ���ڽӱ����ÿһ��������ʼ��Ϊ��
			adj[v] = new Bag<Integer>();
		}

	}

	public Graph(In in) {

		this(in.readInt()); 		// ��ȡV����ͼ��ʼ��
		int E = in.readInt(); 		// ��ȡE(�ߣ�
		for (int i = 0; i < E; i++) {
			// ���һ����
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

		/* Ҫ���һ������v��w�ı�
		 * ���ǽ�w��ӵ�v���ڽӱ��в���v��ӵ�w���ڽӱ��� */

		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	//��v���ڵ����ж���
	public Iterable<Integer> adj(int v) {
		return adj[v];

	}

	// ����v�Ķ���������=�ߵ�����
	public int degree(Graph G, int v) {

		int degree = 0;
		for (int w : G.adj(v)) {
			degree++;
		}
		return degree;
	}

	// �������ж����������
	public int maxDegree(Graph G) {

		int max = 0;
		for (int v = 0; v < G.V(); v++) {
			if (degree(G, v) > max)
				max = degree(G, v);
		}
		return max;
	}

	// �������ж����ƽ������
	public double avgDegree(Graph G) {

		return 2.0 * G.E() / G.V();

	}

	// �����Ի��ĸ���
	public int numberOfSelfLoops(Graph G) {

		int count = 0;
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				if (v == w) {
					count++;
				}
			}
		}

		return count / 2;// ÿ���߶����ǹ�����

	}

	// ͼ���ڽӱ���ַ�����ʾ
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
