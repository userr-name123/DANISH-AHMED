import java.util.Scanner;

class Lab3P3{
	public static void main(String...args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String b = sc.next();
		
		Lab3P3 = new Lab3P3();
		p.display();
		p.display(10);
		p.display("MDA");
		P.display(20,"MDA");
	}
	Lab3P3(){
		System.out.println("constructor without params");	
	}
	public void show(){
		System.out.println("Method without parameters");
	}
	public void show(int x){
		System.out.println("Method with int param"+x);
	}	
	public void show(String str){
			System.out.println("Method with String param"+str);
	}
	public void show(int x,String str){
		System.out.println("Method with 2 param int and String"+x,str);
	}
}		
	
