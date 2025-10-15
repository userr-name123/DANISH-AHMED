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
        int count = 1;
        for(int i : a){
            sum = sum + i;
            System.out.print(i);
            if(count !=a.length)
            System.out.print("+");
            count++;
        }
        System.out.println("=" + sum);
        
    }
}


