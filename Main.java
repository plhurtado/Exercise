
import java.io.FileReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

public class Main {
	
	private static ArrayList<People> people;
	private static LocalDate now;
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void printPerson (int i) {
		System.out.println(people.get(i).getSocialSecurityNumber() + " - ");
		System.out.println(people.get(i).getFirstName() + " - ");
		System.out.println(people.get(i).getLastName() + " - ");
		System.out.println(people.get(i).getEmail() + " - ");
		System.out.println(people.get(i).getDateOfBirth() + " - ");
		System.out.println(people.get(i).getPhoneNumber() + " - ");
		System.out.println(people.get(i).getCity() + " \n ");
	}
	
	public static void printGroup (ArrayList<Group> group) {
		for (int i=0; i<group.size();i++) {
			System.out.println(group.get(i).getLastName() + " - ");
			System.out.println(group.get(i).getAdults() + " - ");
			System.out.println(group.get(i).getKids() + " \n ");
		}
	}
	
	public static void loadUser(String fileName) {
		//Leer el fichero e ir creando un objeto de tipo People por cada una de las personas del archivo JSON.
		//Una vez que se tenga todo almacenado se imprimirá por pantalla.
		for (int i=0; i<people.size();i++) {
			printPerson (i);
		}
	}
	
	public static void getUserByEmail(String email) {

		int age = 0;
		int result = -1;
		
		for (int i=0; i<people.size(); i++) {
			if (people.get(i).getEmail() == email) {
				now = LocalDate.now();
				Period periodo = Period.between(people.get(i).getDateOfBirth(), now);
				if (periodo.getYears()>age) {
					age = periodo.getYears();
					result = i;
				}
			}
		}
		if (result != -1) {
			printPerson(result);
		}
		else
			 System.out.println("Null");
	}
	 
	public static void loadSortedUserGroup() {
		for(int i=0;i<people.size();i++){
            for(int j=i+1;j<people.size();j++){
                if(people.get(i).getLastName().compareToIgnoreCase(people.get(i).getLastName())>0){
                    People aux=people.get(i);
                    people.set(i, people.get(j));
                    people.set(j, aux);

                }
            }
        }
		ArrayList<Group> group = new ArrayList<Group>();
		String last ="";
		int adults=0;
		int kids=0;
		
		for(int i=0;i<people.size();i++){
			if (people.get(i).getLastName().equals(last)) {
				now = LocalDate.now();
				Period periodo = Period.between(people.get(i).getDateOfBirth(), now);
				int age = periodo.getYears();
				if (age<18) 
					kids++;
				else 
					adults++;
			}
			else if (adults!=0 || kids!=0) {
				Group aux = new Group(people.get(i-1).getLastName(), adults, kids);
				group.add(aux);
				adults=0;
				kids=0;	
				i--;
			}
			else {
				now = LocalDate.now();
				Period periodo = Period.between(people.get(i).getDateOfBirth(), now);
				int age = periodo.getYears();
				if (age<18) 
					kids++;
				else 
					adults++;
			}
			
		}
		
		printGroup(group);

	}

	public static void main(String[] args) {
		String fileName = args[0];
		String email = args[1];
		loadUser(fileName);
		getUserByEmail(email);
		loadSortedUserGroup();
		
	}

}

