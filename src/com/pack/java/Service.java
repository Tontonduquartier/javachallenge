package com.pack.java;

public class Service {
	
	private String nom_service;
	private float price;
	public Service(String nom,float price)
	{
		this.nom_service=nom;
		this.price=price;
		
	}
	
	public Service()
	{
		
	}
	//les getters and setters  sont necessaires pour pouvoir me fournir la somme a l'aide des filter dans les listes
	
	public String getNom_service()
	{
		return nom_service;
	}
	
	public void setNom_service(String nom_service) {
		this.nom_service = nom_service;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	//hashcode va m'aider a implementer l'interface Hashset afin de ne pas dupliquer les service sur les meme les prix. 

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom_service == null) ? 0 : nom_service.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		if (nom_service == null) {
			if (other.nom_service != null)
				return false;
		} else if (!nom_service.equals(other.nom_service))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}

	
	public String toString() {
		return "" + nom_service + " = $" + price + "";
	}
}
