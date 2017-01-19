package com.nhf;

import java.util.Arrays;

public class Sort
{
    public static void bubbleSort(int[] a)
    {
        int temp;
        boolean changed = true;
        for (int i = a.length; i > 0; i--)
        {
            for (int j = 0; j < i - 1; j++)
            {
                if (a[j] > a[j + 1])
                {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        
    }
    
    public static void main(String[] args)
    {
        int[] a = {10052, 10011, 12, 52, 62, 32, 48, 52, 33, 99};
        Sort.bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
    
}
