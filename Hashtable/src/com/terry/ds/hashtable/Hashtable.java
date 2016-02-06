package com.terry.ds.hashtable;

public interface Hashtable<Item> {
	public void put(String key, Item value);

	public Item get(String key);

	public void remove(String key);
}
