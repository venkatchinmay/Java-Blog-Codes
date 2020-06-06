package com.corejava.List;

public interface List<T> {
	
	public void add(T value) throws Exception;
	
	public void addFirst(T value) throws Exception ;
	
	public void addLast(T value) throws Exception ;
	
	public void addAtPosition(T value,int position) throws Exception;
	
	public String traversingList() throws Exception;
	
	public String positionOfElement(T value);
	
	public void removeByValue(T value) throws Exception;
	
	public int size() ;
	
	public void removeAll();
	
	
	
	
	

}
