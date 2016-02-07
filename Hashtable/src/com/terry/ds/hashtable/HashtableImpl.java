package com.terry.ds.hashtable;

import java.util.NoSuchElementException;

public class HashtableImpl<Item> implements Hashtable<Item> {

	static boolean DEBUG = true;

	void debug(String str) {
		if (DEBUG)
			System.out.println("DEBUG " + str);
	}

	private static int THRESOLD = 70;
	int size = 0;
	int nofnode = 0;
	Node<Item> bucket[];

	@SuppressWarnings("unchecked")
	public HashtableImpl(int size) {
		bucket = new Node[size];
		this.size = size;
	}

	@Override
	public void put(String key,Item value){
		put(key,value,false,this.bucket);
	}
	public void put(String key, Item value,boolean resize,Node[] bucket) {
		// put value into key
		
		//bucket = this.bucket;
		if(nofnode>size) return;
		Node node = new Node(key, value);
		Node pos_node = null;

		debug(".put(" + key + ") index is " + hash(key) % size);
		if(!resize){
			try {
				// 해당키에 대해서 이미 값이 있는지 없는지를 확인
				pos_node = getNode(key);
			} catch (NoSuchElementException ne) {
				// 만약에, 해당 키로 값이 없는 경우
				debug(".put(" + key + ") is not exist");
				pos_node = null;
			}
		}

		if (pos_node == null) {
			// 해당 키에 대한 값이 없을 경우.
			// 새로운 노드를 만들어서 해당 노드에 해당하는 버킷에 저장한다.
			nofnode++;
			int index = hash(key) % size;

			if (bucket[index] == null) {
				// 버킷이 비어 있는 경우, bucket이 이 노드를 가리키도록 한다.
				bucket[index] = node;
				debug(".put(" + key + ") adding " + key + " to head");
			} else {
				// 버킷이 비어 있지 않는 경우 노드를 만들어서 버킷 맨 앞에 끼워 넣는다.
				Node head = bucket[index];
				node.setNext(bucket[index].getNext());

				bucket[index] = node;
				node.setNext(head);
				head.setPrev(node);
				debug(".put(" + key + ") adding " + key + " into list");
			}
		} else {
			// 해당 키에 대한 값이 이미 있을 경우, 값만 업데이트 한다.
			pos_node.setValue(value);
		}
		debug("size :"+size+" nofnode:"+nofnode);
		// 만약에 bucket 사이즈가 THRESOLD를 넘어가면 bucket를 두배 사이즈로 다시 만든다.
		if(nofnode > size*this.THRESOLD/100 && !resize) {
			
			debug("nofnode :"+nofnode);
			debug("threadhold :"+size*this.THRESOLD/100);
			resize(2);
		}

	}

	@Override
	public Item get(String key) throws NoSuchElementException,
			IndexOutOfBoundsException {

		Node node = getNode(key);
		Item value = (Item) node.getValue();

		return value;
	}

	private Node<Item> getNode(String key) throws NoSuchElementException,
			IndexOutOfBoundsException {
		int index = hash(key) % size;
		if (index > size || index < 0)
			throw new java.lang.IndexOutOfBoundsException(" index is " + index
					+ ", size is " + size);

		Node node = bucket[index];
		while (node != null) {
			debug(".getNode(" + key + ") traverse node, current key is "
					+ node.getKey());
			if (node.getKey().equals(key))
				return node;
			node = node.getNext();
		}// while

		throw new java.util.NoSuchElementException(key
				+ " is not exist, index is " + index);
	}

	@Override
	public void remove(String key) throws NoSuchElementException {
		// TODO Auto-generated method stub
		Node node;
		try {
			node = getNode(key);
		} catch (NoSuchElementException ne) {
			throw ne;
		}

		int index = hash(node.getKey()) % size;

		if (bucket[index] == node) {
			// 해당 버킷에 노드가 하나인 경우
			bucket[index] = null;
		} else {
			// 해당 버킷이 링크드 리스트에서 첫 노드가 아니라 중간 노드인 경우
			Node next = node.getNext();
			Node prev = node.getPrev();
			prev.setNext(next);
			next.setPrev(prev);
		}
		nofnode--;
	}

	private int hash(String key) {
		// caculate hash for key;
		int len = key.length();
		char ch[] = key.toCharArray();
		int hash = 0;

		for (int i = 0; i < len; i++) {
			hash = hash * 31 + ch[i];
		}

		if (hash < 0)
			hash = hash * -1;
		// System.out.println("key "+key+" hash "+hash+" String.hash "+key.hashCode());

		return hash;
	}

	private void resize(int w) {
		Node<Item> new_bucket[] = new Node[size * w];
		size = size * w;
		for(int i=0;i<bucket.length;i++){
			Node head = bucket[i];
			Node cursor = head;
			while(cursor != null) {
				String key = cursor.getKey();
				Item value = (Item) cursor.getValue();
				debug(".resize copying key "+key);
				put(key,value,true,new_bucket);
				cursor = cursor.getNext();
			}// while
		}
		bucket = new_bucket;
	}

}
