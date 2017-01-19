package com.nhf;

import java.util.HashMap;
import java.util.Map;

public class Test1
{
    public static void main(String[] args)
    {
    
    }
    
    public static void change(Out out)
    {
        
        Map map = out.getMap();
        if (map == null)
        {
            map = new HashMap();
        }
        
        map.put("test1", "value");
        System.out.println(out.getMap());
    }
    
    public static String test2(int a)
    {
        try
        {
            if (a == 1)
                throw new RuntimeException();
                
        }
        catch (Exception e)
        {
            return "error";
        }
        
        String b = "hello";
        
        try
        {
        
        }
        finally
        {
            System.out.println(b);
        }
        return null;
        
    }
}

class Out
{
    private Map map;
    
    public Map getMap()
    {
        return map;
    }
    
    public void setMap(Map map)
    {
        this.map = map;
    }
    
}
