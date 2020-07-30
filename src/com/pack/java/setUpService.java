package com.pack.java;

import java.util.Scanner;



public class setUpService extends Service {
	
	
	@Override
	public String name_service() {
		System.out.println("Nom du service :");
		
		try (Scanner sc = new Scanner(System.in)) {
			String name=sc.nextLine();
			if(name!=null)
				return name;
		}
		return null;
	}

	@Override
	public int price_service() {
		System.out.println("Prix :");
		int price=0;
		try (Scanner sc = new Scanner(System.in)) {
		 price =sc.nextInt();
			if(price>0)
				return price;
		}
		
	
		return 0;
	}

	
}