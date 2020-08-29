package com.artofcoding.java9features;

/**
 * Hello world!
 *
 */
// java 7 - try with -resources
// java 9 - depricated the finalize the method 
class Resource implements AutoCloseable {
	public Resource() {System.out.println("creating the external Resource");}
	public void op1() { System.out.println("0p1");}
	/*public void finalize() { // bad idea 
		System.out.println("clean up external resources");
	}*/
	public void close () { // bad idea 
	System.out.println("clean up external resources");
	}
}


public class TryWithResources 
{
	
	public static void use() {
		try(Resource res = new Resource()){
			res.op1();
		}
		//System.out.println(res);
	}
	
	// java 9
	public static void use9(Resource res) {
		//try(final/effectively final)
		//res = res;
		try(res){
			res.op1();
		}
		System.out.println(res);
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //Resource res = new Resource();
        /*try(Resource res = new Resource()){
			res.op1();
		}*/
       
        // funniest method 
        //System.gc(); 
        use9(new Resource());
      // underscore  
       //int _  =  5 ;
        int __ = 5; // dont do this 
        
    }
}
