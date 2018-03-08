package Chapter1_3_QueuesAndStacks;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item> {

	/*
	 * firstָ��firstָ����еĿ�ͷ lastָ����еĽ�β
	 */
	private Node first;
	private Node last;
	private int size;
	
	private class Node{
		Node next;
		Item item;
	}

	public Queue() {
	}

	// �ӱ�β���һ��Ԫ��
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item=item;
		last.next = null;
		
		if(isEmpty()) {
			first = last;
			
		}else {
			oldlast.next=last;
		}
		size++;
		
		
	}

	//�ӱ�ͷɾ��һ��Ԫ��
	public Item dequeue() {
		Item item = first.item;
		
		first = first.next;
		if(isEmpty()) {
			last = null;
			
		}
		size--;
		
		return item;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				queue.enqueue(item);
			} else if (!queue.isEmpty()) {
				StdOut.print(queue.dequeue() + " ");
			}
		}

		StdOut.print(" left " + queue.size() + " on queue");

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
