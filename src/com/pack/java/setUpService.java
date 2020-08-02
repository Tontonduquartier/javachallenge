package com.pack.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class setUpService {
	
	
	static Service s=new Service();
	static Set<Service> list_ser=new HashSet<Service>();
	static List<Client>list_client_service=new ArrayList<>();
	
	static BufferedReader IN=null;
	static Client cl=new Client();
	
	//this method add new services
	public static Service newerService() 
	{
	
		
		try{
			System.out.println("Entrer le nom du service:");
			
		IN=new BufferedReader(new InputStreamReader(System.in));
		//s.setNom_service(IN.readLine());
		String n_serv=(IN.readLine());
		System.out.println("Entrer le prix: ");
		IN=new BufferedReader(new InputStreamReader(System.in));
		//s.setPrice(Float.parseFloat(IN.readLine()));
		float cost=(Float.parseFloat(IN.readLine()));
		if(n_serv.length()>0 && cost>=0) {
			list_ser.add(new Service(n_serv,cost));
			showServices();
			return new Service(n_serv,cost);
		}else 
		{
			System.out.println("pas de nouveau service");
		}
		
		
				
		} catch (Exception e)
		{
		System.out.println("Erreur de saisi");
			newerService();	
		}
		return null;
		

	}
	
	
	
	//methode d'ajout des services statique
	public static void AddstaticServices() 
{
		list_ser.add(new Service("Basic Inspection",50));
		list_ser.add(new Service("Oil change", 85));
		list_ser.add(new Service("Tire rotation", (float) 23.5));		
		
	}
	
	public static void	initservices()
	{
		for(Service s:list_ser)
		{	
			System.out.println("==>"+s);
		}
		
	}
	
	
	
	//methode d'ajout des services
	public static void addServices()
	{
		newerService();
		if(newerService()!=null && newerService().getNom_service()!=null && newerService().getPrice()>=0) {
			list_ser.add(newerService());
			System.out.println("Service :"+newerService().getNom_service()+"<----->"+" prix :"+newerService().getPrice());
		}else {
			System.out.println("pas de nouveau service");
		}
	}
	
	//methode d'affichage des services
	static int isforBack=1;
	public static void showServices() 
	{
		
			for(Service s:list_ser)
			{
				
				System.out.println("==>"+s);
			}
		
		do
		{
			System.out.println("==> select 0 to go back");
			 isforBack=1;
			IN=new BufferedReader(new InputStreamReader(System.in));
			try {
				isforBack=Integer.parseInt(IN.readLine());
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				isforBack=1;
				System.out.println("Invalid number");
				showServices();
			}
			
		}
		while(isforBack!=0);
		
		operation();
		
	}

//---------------------------------------------------------------------------------------------------
	
	//cette methode retourne une valeur selon le choix
	
	static int choice;
	public static void MessageOfchoice() {
	//	int choice=0;
		//	Iterator<Service>it =list_ser.iterator();
			System.out.println("==>Selectionnez le numero selon votre choix :");
			System.out.println("==>Select number 1 for all services and costs :");
			System.out.println("==>Select number 2 to add more services :");
			System.out.println("==>Select number 3 to remove a service :");
			System.out.println("==>Select number 4 to remove all services :");
			System.out.println("==>Select number 5 to get add new client");
			System.out.println("==>Select number 6 to get sum of Tire Rotation and Oil change:");
			System.out.println("==>Select number 0 to exit this program :");
			
			System.out.print("==>$ :");
			try {
				IN=new BufferedReader(new InputStreamReader(System.in));
				choice= (Integer.parseInt(IN.readLine()));
				
			} catch (Exception e) {
				
				System.out.println("Invalid number");
				choice =10;
				
			}
	
	}
//--------------------------------------------------------------------------------------------------
	
	
	public 	static void removeService() {
		System.out.println("==>Donner le nom du service parmis ces services:");
		
		initservices();
		IN=new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String nameService=(IN.readLine());
			System.out.println("Entrer le prix equivalent a ce service que vous voulez supprimer:");
			float pr=(Float.parseFloat(IN.readLine()));
			System.out.println("Vous avez choisi le service ("+nameService+") dont le prix est ("+pr+")");
			
			boolean found=list_ser.remove(new Service(nameService, pr));
			if(found) {
				System.out.println("les services qui restent sont:");
				initservices();
				System.out.println("--------------------------------------------------------");
				System.out.println("");
				operation();
			}else {
				System.out.println("le service n'existe pas dans la liste.Verifiez votre syntaxe");
				
				System.out.println("--------------------------------------------------------");
				System.out.println("");
				operation();
				
			}
			
			
		} catch (IOException e) {
			System.out.println("Invalid number");
		
		}
		
	}
	
//------------------------------------------------------------------------------------------------------------
	//methode d'operation selon le choix
	
	static void operation() {
		MessageOfchoice();
		switch (choice) 
		{
		
		case 0:System.exit(0) ;
			
			break;
		case 1:
			showServices();
			
			
			break;
		case 2:newerService();
			
			break;
		case 3: removeService();
			
		case 4:
			list_ser.clear();
			newerService();
				
		case 5:
			Askclient();
			
			break;
		case 6: calculerSomme();
		default:
			MessageOfchoice();
			break;
		}
	}

	//_________________________________________________________________________________________________
	
	
	//mehode pour donner un service aux clients 
	
	static String nom_Cl="";
	static void Askclient() {
		System.out.println("==>Client name :");
		try {
			IN=new BufferedReader(new InputStreamReader(System.in));
			nom_Cl=IN.readLine();
			Add_Service_Client() ;
		} catch (IOException e) {
			System.out.println("error while streaming keyboard");
		}
	}
	 
	public static void Add_Service_Client() 
	{
		IN=new BufferedReader(new InputStreamReader(System.in));
		try {
			
			 
			System.out.println("==>Enter service name appears below:");
			initservices();
			String nameservice=IN.readLine();			
			System.out.println("==>Enter the price of the equivalent service:");
			float serviceprice=Float.parseFloat(IN.readLine());
			boolean isAdded=false;
			for(Service s:list_ser)
			{
				
				if(s.equals(new Service(nameservice, serviceprice))) 
				{
					list_client_service.add(new Client(nom_Cl, new Service(nameservice, serviceprice)));
					isAdded=true;
					break;				
					
				}
			}
			
			if(isAdded) 
			{
				showClientService();
			}else 
			{
				System.out.println("service not found!! check your syantax");
				System.out.println("press Y to continue:");
				IN=new BufferedReader(new InputStreamReader(System.in));
				String done=IN.readLine();
				if(done.equalsIgnoreCase("Y"))
				{
					Add_Service_Client();
				}else {
					operation();
				}
				
			}
					
		} catch (IOException e)
		{
			System.out.println("invalid number");
			Add_Service_Client();
		}
			
	}
	//methode d'affichage des clients et ses services obtenu
	public static void showClientService() 
	{
		
			System.out.println("Client Name |  Service Name  |  price");
			System.out.println("---------------------------------------------------------");
		
			System.out.println("__________________________________________________________");
			
			System.out.println("press A to continue adding more services on the same client:");
			System.out.println("press N to add new client:");
			System.out.println("press R to restart:");
			System.out.println("press Q to exit:");
			IN=new BufferedReader(new InputStreamReader(System.in));
			try {
				String str=IN.readLine();
				if(str.equalsIgnoreCase("A")) {
					Add_Service_Client() ;
				}
				if(str.equalsIgnoreCase("N")) 
				{
					Askclient();
				}
				if(str.equalsIgnoreCase("R"))
				{
					operation();
				}
				if (str.equalsIgnoreCase("Q"))
				{
					System.exit(0);
				}
			} catch (IOException e) {
				System.out.println("Une erreur s'est produite");
			}

	}

//-------------------------------------------------------------------------------------------------------------	
/*	public static void main(String[] args)
	{
		
		AddstaticServices();
		st_client_ser();
		operation();

	}*/
	
	//this method add Statically somme client and their obtein services
	
		public static void st_client_ser() {
			list_client_service.add(new Client("Faiq", new Service("Basic Inspection",50 )));
			list_client_service.add(new Client("Eshaan", new Service("Oil change",85)));
			list_client_service.add(new Client("Aliu", new Service("Tire rotation",(float) 23.5 )));
		}
		//methode help me to get sum of oil change and Tire rotation
		public static void  calculerSomme()
		{
			//List<Service>sr=new ArrayList<>();
			Set<Service>sv=new HashSet<Service>();
			
			//sv.addAll(list_ser);
			for (Service servc : list_ser) 
			{
				if(servc.equals(new Service("Oil change", 85)) || servc.equals(new Service("Tire rotation", (float) 23.5))) 
				{
					sv.add(servc); 
				}
				
			}
				
			
			//sr.add(new Service("Oil change",85));
			//sr.add(new Service("Tire rotation", (float) 23.5));
			float sum = 0;
			
				 System.out.println("Nom du client   | Nom du service  | Prix    |  Total");
				 System.out.println("-----------------------------------------------------");
				 sum = (float) sv.stream().filter(o->o.getPrice()>10).mapToDouble(o->o.getPrice()).sum();
				 System.out.println("La reponse de Faiq pour les pris du Tire Rotation et du Oil change: ");
				 System.out.println(""+sv);
				 System.out.println("TOTAL: "+sum);

				System.out.println("----------------------------------------------------------------------");
					
			}	
			
		} 
		

	
