package Chapter3_1.SymbolTable;

public class SequentialSearchST<Key, Value> {

	/*
	 * 顺序查找 基于无序链表
	 * 随机命中（查找表中的每个键）---》~N/2
	 * 效率非常低效，无法满足处理庞大输入问题的需求，比较的总次数和查找次数与插入次数的乘积成正比
	 */

	private Node first;

	private class Node {
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;

		}

	}

	public Value get(Key key) {

		for (Node x = first; x != null; x = x.next) {

			if (key.equals(x.key)) {
				return x.val;
			}

		}
		return null;

	}

	public void put(Key key, Value val) {

		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
			first = new Node(key, val, first);
		}
	}
}