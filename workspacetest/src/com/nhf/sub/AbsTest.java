package com.nhf.sub;

public class AbsTest extends AbstractClass
{
    public static void main(String[] args)
    {
        Class<?> clazz = AbsTest.class;
        Class<?> supClazz = clazz.getSuperclass();
        try
        {
            Object obj = supClazz.newInstance();
            System.out.println(obj);
        }
        catch (InstantiationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

abstract class AbstractClass
{
    public void test()
    {
    
    }
    
    @Override
    public String toString()
    {
        
        return super.toString() + "this is AbstractClass";
    }
    
}