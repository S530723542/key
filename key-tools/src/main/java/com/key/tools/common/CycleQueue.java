package com.key.tools.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * 线程不安全的
 * 
 * @author SHEN
 *
 * @param <E>
 */
public class CycleQueue<E> implements Queue<E>
{
	private List<E>	list;

	private int		length;

	private int		head;

	private int		end;

	public CycleQueue(int length)
	{
		this.length = length;
		list = new ArrayList<E>(length + 1);
		head = 0;
		end = 0;
	}

	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		if (c == null)
		{
			return false;
		}
		if (c.size() > length)
		{
			return false;
		} else
		{
			Iterator<? extends E> iterator = c.iterator();
			while (iterator.hasNext())
			{
				offer(iterator.next());
			}
			return true;
		}

	}

	@Override
	public void clear()
	{
		head = 0;
		end = 0;

	}

	@Override
	public boolean contains(Object o)
	{

		int size = end >= head ? end - head : end + length + 1 - head;
		if (o == null)
		{
			for (int i = 0; i < size; i++)
			{
				E e = get(i);
				if (e == null)
				{
					return true;
				}
			}
		} else
		{
			for (int i = 0; i < size; i++)
			{
				E e = get(i);
				if (o.equals(e))
				{
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		if (c == null)
		{
			return false;
		}
		Iterator<?> iterator = c.iterator();
		while (iterator.hasNext())
		{
			Object o = iterator.next();
			if (!contains(o))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty()
	{
		if (size() == 0)
		{
			return true;
		} else
		{
			return false;
		}

	}

	@Override
	public Iterator<E> iterator()
	{
		return new Itr();
	}

	@Override
	public boolean remove(Object o)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size()
	{
		int size = end >= head ? end - head : end + length + 1 - head;
		return size;
	}

	public int left()
	{
		int left = length - size();
		return left;

	}

	@Override
	public Object[] toArray()
	{
		int size = size();
		Object[] array = new Object[size];
		for (int i = 0; i < size; i++)
		{
			array[i] = get(i);
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a)
	{
		int size = size();

		if (a.length < size)
		{
			size = a.length;
		}
		for (int i = 0; i < size; i++)
		{
			a[i] = (T) get(i);
		}
		return a;
	}

	@Override
	public boolean add(E e)
	{
		if (end == head)
		{
			throw new IllegalStateException();
		}
		list.add(end, e);
		end = getIndex(end, 1);
		return true;
	}

	@Override
	public E element()
	{
		if (head == end)
		{
			throw new NoSuchElementException();
		} else
		{
			return list.get(head);
		}
	}

	@Override
	public boolean offer(E e)
	{
		return add(e);
	}

	@Override
	public E peek()
	{
		if (head == end)
		{
			return null;
		} else
		{
			return list.get(head);
		}
	}

	@Override
	public E poll()
	{
		if (head == end)
		{
			return null;
		} else
		{
			E e = list.get(head);
			head = getIndex(head, 1);
			return e;
		}
	}

	public E get(int i)
	{
		int size = size();
		if (i > size)
		{
			throw new ArrayIndexOutOfBoundsException("size is " + size
					+ " ,but i is " + i);
		}
		int index = getIndex(i, head);
		return list.get(index);
	}

	private int getIndex(int i, int j)
	{
		int index = i + j;
		if (index > list.size())
		{
			index = index - list.size();
		}
		return index;
	}

	@Override
	public E remove()
	{
		if (head == end)
		{
			throw new NoSuchElementException();
		} else
		{
			E e = list.get(head);
			head = getIndex(head, 1);
			return e;
		}
	}

	private class Itr implements Iterator<E>
	{

		@Override
		public boolean hasNext()
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next()
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove()
		{
			// TODO Auto-generated method stub

		}

	}

}
