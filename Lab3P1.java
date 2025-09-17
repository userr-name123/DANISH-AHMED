import java.util.Scanner;

class Lab3P1{
	public static void main(String...args){
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		int i = 2;
		while(i<n){
			int j = 2,count=0;
			if(i==2)
			while(j<i){
				if(i%j==0)
				break;
				else count++;
				
				j++;
				if(count>0)
					System.out.println(i);
					i++;
							
				
			}
		}
	}
}
