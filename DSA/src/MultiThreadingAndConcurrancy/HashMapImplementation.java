package MultiThreadingAndConcurrancy;

import java.util.*;

class MapPair
{
	int key;
	int value;

	MapPair(int key , int value)
	{
		this.key = key;
		this.value = value;
	}
}

class LinkedListMapNode {
	public MapPair pair;
	public LinkedListMapNode next;
	public LinkedListMapNode random;
	public LinkedListMapNode() {}
	public LinkedListMapNode(MapPair pair) 
	{ 
		this.pair = pair;
	}
}


public class HashMapImplementation {

	List<LinkedListMapNode> list;
	int capacity;
	public HashMapImplementation(int capacity) {
		// TODO Auto-generated constructor stub
		list = new ArrayList<>();
		for(int i=0;i<capacity ; i++)
		{
			list.add(new LinkedListMapNode());
		}

		this.capacity=capacity;
	}

	private int hashed(int key)
	{
		return key%capacity;
	}

	public void put(int key , int value)
	{
		int hashedValue = hashed(key);
		insert(hashedValue , key , value);
	}

	private void insert(int hashed , int key , int value)
	{
		LinkedListMapNode curr = new LinkedListMapNode(new MapPair(key,value));
		if(list.get(hashed).pair == null)
		{
			list.add(hashed , curr);
		}
		else
		{
			LinkedListMapNode linked = list.get(hashed);

			LinkedListMapNode temp = linked;

			while(temp.next != null)
			{
				MapPair pair = temp.pair;
				if(pair.key == key)
				{
					pair.value = value;
					return;
				}
				temp = temp.next;
			}
			temp.next = curr;

		}
	}

	public int get(int key)
	{
		int hashedValue = hashed(key);
		LinkedListMapNode curr = list.get(hashedValue);

		LinkedListMapNode temp = curr;

		while(temp != null)
		{
			MapPair pair = temp.pair;
			if(pair == null) return -1;
			if(pair.key == key) return pair.value;

			temp = temp.next;
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMapImplementation hashMap= new HashMapImplementation(16);
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		hashMap.put(3, 3);
		hashMap.put(4, 4);
		hashMap.put(5, 5);

		hashMap.put(17, 11);
		hashMap.put(18, 12);
		hashMap.put(19, 13);
		hashMap.put(20, 14);
		hashMap.put(21, 15);

		System.out.println(hashMap.get(1));
		System.out.println(hashMap.get(2));
		System.out.println(hashMap.get(3));
		System.out.println(hashMap.get(4));
		System.out.println(hashMap.get(5));
		System.out.println(hashMap.get(17));
		System.out.println(hashMap.get(18));
		System.out.println(hashMap.get(19));
		System.out.println(hashMap.get(20));
		System.out.println(hashMap.get(21));

		System.out.println(hashMap.get(23));

		hashMap.put(1, 100);
		System.out.println(hashMap.get(1));

	}

}
