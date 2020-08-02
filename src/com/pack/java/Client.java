package com.pack.java;

public class Client {
	private String nom_client;
	private Service service_client;
	
	
/*	public Service getService_client() {
		return service_client;
	}

	public void setService_client(Service service_client) {
		this.service_client = service_client;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}
	
	
	*/
	//ici les getters and setters ne sont pas necessaire
	public Client(String nom_client,Service service)
	{
		this.nom_client=nom_client;
		this.service_client=service;
	}

	public Client() {
		
	}
	public String toString() {
		return " " + nom_client + " :" + service_client + "";
	}
	
}
