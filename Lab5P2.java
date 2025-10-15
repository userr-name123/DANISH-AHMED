import java.util.Scanner;
import  java.lang.Exception;
class MyCalculator {
       public long power(int n,int p)throws Exception{
              long result = 1;
            if(n<0 || p<0)
            throw new Exception("n or p should not be negative.");
            if(n==0 && p==0)
            throw new Exception("n and p should not be zero.");
            for(int i=0;i<p;i++){
                result = result * n;
            }
            return result;
        
            }
    }    
