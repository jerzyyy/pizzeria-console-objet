package fr.pizzeria.model;

public class Exemple {

	public static void main(String[] args) {
		
		int result = 4;
		while(result < 100) {
			Calc j = new Calc(); 
			result=j.add(result,1);
			System.out.prinln(result);
		}
		
		int id =2;
		Pizza chevre = new Pizza(1);
		id+=1;
		Pizza fromage = new Pizza(id);
		id+=1;
		Pizza olive = new Pizza(id);
		
		System.out.println(chevre.id);
		System.out.println(fromage.id);
		System.out.println(olive.id);

	}

}
