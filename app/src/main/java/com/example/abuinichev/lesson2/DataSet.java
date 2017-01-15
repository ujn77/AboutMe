package com.example.abuinichev.lesson2;

import java.util.ArrayList;
import java.util.List;

/**
 * The source of data for this app.
 * */
class DataSet {
	
	/** Inner data. */
	private List<String> mList = null;
	
	/**
	 * Construct a new {@link DataSet} instance with default parameters.
	 * */
	public DataSet() {
		mList = new ArrayList<>();
	}
	
	/**
	 * Returns number of count.
	 * */
	public int size() { return mList.size(); }
	
	/**
	 * Returns the element at the specified location in this {@link DataSet}.
	 * */
	public String get(int location) { return mList.get(location); }

	/**
	 * Adds the specified object at the end of this {@link DataSet}.
	 * */
	public void add(String object) { mList.add(object); }

	/**
	 * Replaces the element at the specified location in this {@link DataSet}
	 * with the specified object.
	 * */
	public void set(int location, String object) {
		mList.set(location, object);
	}

	/**
	 * Removes the object at the specified location from this {@link DataSet}.
	 * */
	public String remove(int location) { return mList.remove(location); }
	
	/**
	 * Removes all elements from this {@link DataSet}, leaving it empty.
	 * */
	public void clear() { mList.clear(); }

}