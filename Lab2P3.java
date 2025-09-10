import java.util.Scanner;

class Lab2P3{
	public static void main(String...args){
	Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		
		String op = s.next();
		
		String str = switch(op){
			case "++" -> "Gramps";
			case "--","=","-" -> "how are you";
			default -> "sorry";
		};
		System.out.println("Result is; "+ str);
	}		
}			
