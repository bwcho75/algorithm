package com.terry.ds.hashtable.test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.terry.ds.hashtable.Hashtable;
import com.terry.ds.hashtable.HashtableImpl;

public class HashtableTest {

	@Test
	public void testGet() {
		Hashtable hash = new HashtableImpl(10);

		hash.put("terry", "daddy");
		hash.put("cath", "mom");
		hash.put("stella", "princess");
		hash.put("yury", "cute");
		hash.put("hello this is my family", "princess");

		assertEquals(hash.get("cath"), "mom");
		assertEquals(hash.get("terry"), "daddy");
		assertEquals(hash.get("stella"), "princess");
		assertEquals(hash.get("hello this is my family"), "princess");
	}

	@Test
	public void testRemove() {
		Hashtable hash = new HashtableImpl(10);

		hash.put("terry", "daddy");
		hash.put("cath", "mom");
		hash.put("stella", "princess");
		hash.put("yury", "cute");
		hash.put("hello this is my family", "princess");

		assertTrue(hash.get("cath").equals("mom"));
		hash.remove("cath");
		boolean nse_check = false;
		try {
			hash.get("cath");
		} catch (NoSuchElementException ne) {
			nse_check = true;
		}
		assertTrue(nse_check);
	}

}
