package amber.server;

import java.util.Scanner;

public class Controler {
	
	public static Object work(Object obj){
		String in=((String) obj);
		System.out.println("> "+in);
		String res;
		if(in.equals("Hello")){
			res="Yo";
		}else if(in.equals("who are you")){
			res="i'm server";
		}else if(in.equals("who am i?")){
			res="you are Client";
		}else{
			res="i don't care";
			System.out.println("didn't");
		}
		System.out.println(res);
		return res;
	}
}
