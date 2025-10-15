import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Add{
    
    
    public void add(int...a){
        String str = " ";
        int sum=0;
        for(int i : a){
            sum = sum + i;
            System.out.print(i);
            if(i<=a.length-1)
            System.out.print("+");
        }
        System.out.println("=" + sum);
        
    }
}


