package com.key.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App
{
	public static void main(String[] args)
	{
		List<String> list=new ArrayList<String>();
		list.add("1");
		list.add("2");
//		LinkedList<E>
		Iterator<String> iterator=list.iterator();
		iterator.next();
		iterator.remove();
		System.out.println(list.get(0));
		System.out.println("Hello World!");
	}
}
