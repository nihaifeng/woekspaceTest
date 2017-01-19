package com.nhf.rtti;

import java.util.HashMap;
import java.util.Map;

class Building
{
};

class House extends Building
{

}

public class ClassCasts
{
    public static void main(String[] args)
    {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        //houseType.isassi
        Map<String, Map<String, Integer>> map = null;
        Map<String, Map<String, Integer>> map2 = new HashMap();
    }
}
