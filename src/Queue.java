import java.util.*;

public class Queue<T>
{
	private Stack<T> stack;
	//private Stack<T> st2;
	private int size;
	
	public Queue()
	{
		stack = new Stack<T>();
		//st2 = new Stack<T>();
		size = 0;
	}
	
	public void add(T obj)
	{
		stack.push(obj);
		size++;
	}
	
	public T poll()
	{
		if(stack.isEmpty())
			return null;
		
		Stack<T> helper = new Stack<T>();
		while (!stack.isEmpty())
			helper.push(stack.pop());
		
		T obj = helper.pop();
		
		while(!helper.isEmpty())
			stack.push(helper.pop());
		
		size--;
		return obj;
	}
	
	public T peek()
	{
		if(stack.isEmpty())
			return null;
		
		Stack<T> helper = new Stack<T>();
		while (!stack.isEmpty())
			helper.push(stack.pop());
		
		T obj = helper.peek();
		
		while(!helper.isEmpty())
			stack.push(helper.pop());
		
		return obj;
	}
	
	public boolean isEmpty()
	{
		return size == 0;	
	}
	
	public int getSize()
	{
		return size;
	}
	
	public String toString()
	{
		return stack.toString();
	}
	

}

//public class Queue<T>
//{
//	private Node<T> head;
//	private Node<T> tail;
//	private int size;
//
//	public Queue()
//	{
//		head = null;
//		tail = head;
//		size = 0;
//	}
//	
//	public void push(T obj)
//	{
//		Node<T> n = new Node<>(obj);
//		if(head == null)
//		{
//			head = n;
//			tail = head;
//			size++;
//		}
//		else
//		{
//			n.setPrevious(tail);
//			tail.setNext(n);
//			tail = n;
//			size++;
//			
//		}
//	}
//	
//	public T pop()
//	{
//		if(size == 0)
//		{
//			return null;
//		}
//		else if(size == 1)
//		{
//			T obj= head.getVal();
//			tail = null;
//			head = null;
//			size--;
//			return obj;
//		}
//		else
//		{
//			Node<T> node = head;
//			Node<T> next = node.getNext();
//			next.setPrevious(null);
//			head = next;
//			size--;
//			return node.getVal();
//		}
//	}
//	
//	public T peek()
//	{
//		if(size == 0)
//			return null;
//		return head.getVal();
//	}
//	
//	public boolean isEmpty()
//	{
//		return size == 0;	
//	}
//	
//	public int getSize()
//	{
//		return size;
//	}
//	
//	public String toString()
//	{
//		String s = new String();
//		Node<T> n = head;
//		s +="Queue: ";
//		while(n != null)
//		{
//			s += n.getVal() + " ";
//			n = n.getNext();
//		}
//		return s;
//	}
//}
