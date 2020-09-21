package com.artofcoding.java9features;

public interface Java9Feature {
	// not allowed in java 7 	
	//int getNumberOfCoresjava7() { return 9;}
	// allowed in java 7 
	int getNumberOfCores();

	// java 8
	default int getNumberOfCores1() { return 9;} 
	static int getNumberOfCore2() { return 4;}

	// java 9
	default int getNumberOfCores3() { return getCount();} 
	static int getNumberOfCore4() { return getCount2() ;}
	private int getCount() { return 4;}
	private static int getCount2() { return 9;}

	// dont use it 
	// private default  int getCount2() { return 9;}
}
