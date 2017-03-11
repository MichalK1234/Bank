

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Bank {

	private Set<Customer> customersCollection = new TreeSet<>((k1, k2) -> k1.getName().compareTo(k2.getName())); 


	public Bank(String fileName) {

		File plik = new File(fileName + ".txt");
		try (Scanner sc = new Scanner(plik)) {

			while (sc.hasNextLine()) {
				String[] tab = sc.nextLine().split(" ");
				customersCollection.add(new Customer(tab[0], tab[1], tab[2], Double.parseDouble(tab[3])));
			}
		} catch (Exception e) {

			e.getMessage();
			e.printStackTrace();

		}

	}
	
	public void customerService(){
		
		customersCollection.stream().forEach(f->{
			f.customerService();
		});
		
		customersCollection.stream()
		.forEach(f->{ 
			System.out.println(f.getName()+ " " + " " + f.getSurname() + " " + f.getAccountBalance());
		});
		
		
	}

}
