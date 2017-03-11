
public class Main {

	// PROGRAM WYKONANY W RAMACH SZKOLENIA KM-PROGRAMS
	// http://km-programs.pl/

	public static void main(String[] args) {

		Customer k = new Customer();

		System.out.println(k);
		k.customerService();

		System.out.println(k.getAccountBalance());

		System.out.println("============");
		BusinessCustomer kb = new BusinessCustomer();
		kb.customerService();
		System.out.println("============");

		Bank b = new Bank("Klienci2");// Klienci
		b.customerService();
	}

}
