package r.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public int printer(Scanner questionUser) {
		int choix;
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza ");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
		choix = questionUser.nextInt();// renvoie la valeur du choix de l'utilisateur
		return choix;
		
	}
	
	
	public static void main(String[] args) {
		Pizza[] tableau;
		tableau = new Pizza[8];
		
		tableau[0]=new Pizza(0,"PEP","Pépéroni",12.50);
		tableau[1]=new Pizza(1,"MAR","Margherita",14.50);
		tableau[2]=new Pizza(2,"REIN","La Reine",11.50);
		tableau[3]=new Pizza(3,"FRO","La 4 fromages",12.00);
		tableau[4]= new Pizza(4,"CAN","La cannibale",12.50);
		tableau[5]=new Pizza(5,"SAV","La savoyarde",13.00);
		tableau[6]=new Pizza(6,"ORI","L’orientale",13.50);
		tableau[7]=new Pizza(7,"IND","L’indienne",14.00);
		
		
		
		
		PizzeriaAdminConsoleApp dac = new PizzeriaAdminConsoleApp();//On fait une instance de la classe PizzeriaAdminConsoleApp
		Scanner questionUser = new Scanner(System.in);//On fait une instance de scanner importé plus haut
		int reponse = dac.printer(questionUser);
		
		while(reponse != 99) {
			
		
			if(reponse== 1) {
				System.out.println("Liste des pizzas");
				 int i;
					for(i=0;i<tableau.length;i++) {
						System.out.println(	tableau[i].code +" "+ tableau[i].libelle + " " + tableau[i].prix );		
						}
				 reponse = dac.printer(questionUser);	
			}else if(reponse==2) {
				System.out.println("Ajout d’une nouvelle pizza");
				
				System.out.println("Veuillez saisir le code: ");
				String code= questionUser.next();
				 
				
				 System.out.println("Veuillez saisir le nom (sans espace): ");
				 String libelle = questionUser.next();
				
				 System.out.println("Veuillez saisir le prix: ");
				 double prix = questionUser.nextDouble();
				 Pizza[]tableau2;
				 tableau2=new Pizza[tableau.length+1];
				 int i;
				 for(i=0;i<tableau.length;i++) {
					 tableau2[i]=tableau[i];
				 }
				
				 tableau2[tableau2.length-1]=new Pizza(tableau2.length-1,code,libelle,prix);
				 
				 
				 int j;
					for(j=0;j<tableau2.length;j++) {
						System.out.println(	tableau2[j].code +" "+ tableau2[j].libelle + " " + tableau2[j].prix );		
						}
				 tableau= tableau2;//tableau devient tableau 2
				 reponse = dac.printer(questionUser);
				
			}else if(reponse==3) {
				System.out.println("Mise à jour d’une pizza");
				int i;
				for(i=0;i<tableau.length;i++) {
					System.out.println(	tableau[i].code +" "+ tableau[i].libelle + " " + tableau[i].prix );		
				}//Boucle pour aller checker toutes les pizzas
				System.out.println("Veuillez choisir le code de la pizza à modifier.");
				String codePizza= questionUser.next();//Selection du code de la pizza
				System.out.println("Veuillez saisir le nouveau code");
				String updateCodePizza= questionUser.next();//Mise à jour du nom de la pizza
				System.out.println("Veuillez saisir le nouveau nom (sans espace)");
				String updateNamePizza= questionUser.next();//Mise à jour du nom de la pizza
				System.out.println("Veuillez saisir le nouveau prix");
				double updatePricePizza= questionUser.nextDouble();//Mise a jour du prix de la pizza
				
				for(i=0;i<tableau.length;i++) {
					if(tableau[i].code.compareTo(codePizza)==0) { //tableau[i].equalsIgnoreCase(codePizza)
						
						tableau[i].code= updateCodePizza;
						tableau[i].libelle=updateNamePizza;
						tableau[i].prix= updatePricePizza;
						


					}
					System.out.println(	tableau[i].code +" "+ tableau[i].libelle + " " + tableau[i].prix );		
				}
				

					
					reponse = dac.printer(questionUser);	
			}else if(reponse==4) {
				System.out.println("suppression d’une pizza");
				System.out.println("Veuillez choisir le code de la pizza à supprimer:");
				String removeCodePizza= questionUser.next();
				
				int i;
				for(i=0;i<tableau.length;i++) {
					if(tableau[i].code.compareTo(removeCodePizza)==0) { //tableau[i].equalsIgnoreCase(codePizza)
						
						tableau[i].code= null;
						tableau[i].libelle=null;
						tableau[i].prix=0 ;
						


					}
				};
				 reponse = dac.printer(questionUser);
			} else {
				reponse = defaultfunctionnement(dac, questionUser);
			}
		}
		System.out.println("Aurevoir☹");
	}
	
	public static Integer defaultfunctionnement(PizzeriaAdminConsoleApp dac, Scanner questionUser) {
		System.out.println("mauvaise saisie");
		return dac.printer(questionUser);
	}

}
