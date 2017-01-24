package com.nhf;

public class Annotation
{
    public static void main(String[] args)
    {
    
    }
    private String age;
    private String name;
    
    public String getName(){
        return name;
    }
    
    public void setName(String myname){
        name = myname;
    }


	/**
	*    add setAge comment
	*/
	public void setAge(String age) {
		this.age = age;
	}

    
    /**
    *   add comment
    */
    public String getAge(){
        return age;
    }
            

    
  
}
