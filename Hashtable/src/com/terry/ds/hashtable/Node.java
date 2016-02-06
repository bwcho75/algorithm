package com.terry.ds.hashtable;

public class Node<Item> {
	String key;
	Item value;
	Node<Item> next;
	Node<Item> prev;

	public Node(String key, Item value) {
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}

	public String getKey() {
		return key;
	}

	public void setValue(Item value) {
		this.value = value;
	}

	public Item getValue() {
		return value;
	}

	public Node<Item> getNext() {
		return next;
	}

	public void setNext(Node<Item> next) {
		this.next = next;
	}

	public Node<Item> getPrev() {
		return prev;
	}

	public void setPrev(Node<Item> prev) {
		this.prev = prev;
	}

}
