package linkedSeries;
import stdio.stdio;

/**
 * 链表的基本实现，泛型,
 * API:
 *     LinkedList()      构造函数，进行链表初始化;
 *     void insert(int pos, T item)     在链表下标为{@code pos}的位置插入元素{@code item};
 *     void add(T item)      在链表末尾插入元素{@code item};
 *     T delete(int pos)      将链表下标为{@code pos}的位置节点删除，并返回其中储存的元素;
 * */
public class LinkedList<T> {
	/*定义链表节点的结构*/
	private class Node {
		T data;
		Node next;
	}
	private Node first; //定义链表头节点
	private int len;   //记录链表长度
	
	/**
	 * 初始化链表
	 * */
	public LinkedList() {
		first = new Node(); //给头节点分配空间，初始化
		first.next = null;  //将头节点的下一位next释放
		len = 0;
	}
	/**
	 * 在链表末尾插入元素
	 * */
	public void add(T item) { 
		insert(len, item);  //调用insert方法，插入位置为链表的长度，即末尾
	}
	/**
	 * 指定下标插入元素
	 * */
	public void insert(int pos, T item) {
		if(pos > len) 
			throw new IndexOutOfBoundsException("超出范围");
		
		int c = 0;
		Node p = first;
		Node tmpNode = new Node();
		
		while(p != null && c < pos) {
			p = p.next;
			c++;
		}
		
		tmpNode.data = item;
		tmpNode.next = p.next;
		p.next = tmpNode;
		len++;
	}
	/**
	 * 删除指定下标的元素
	 * @return 指定删除的元素
	 * */
	public T delete(int pos) {
		if(pos > len) 
			throw new IndexOutOfBoundsException("超出范围");
		Node p = first;
		T tmpElem;
		int c = 0;
		
		while(p != null && c < pos) {
			p = p.next;
			c++;
		}
		
		tmpElem = p.next.data;
		p.next = p.next.next;
		
		len--;
		
		return tmpElem;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.insert(0, 999);
		list.insert(4, 999);
		stdio.println(list.delete(3));
	}

}
