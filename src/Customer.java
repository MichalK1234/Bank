

import java.util.Scanner;

public class Customer {

	private String name;
	private String surname;
	private String accountNumber;
	private double accountBalance;

	Scanner sc = new Scanner(System.in);

	public String getName() {
		return name;
	}

	public void setName(String name) {

		if (!name.isEmpty()) {
			this.name = name.toUpperCase();
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {

		if (!surname.isEmpty()) {
			this.surname = surname.toUpperCase();
		}

	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		int suma = 0;
		accountNumber.toCharArray();
		for (int i = 0; i < accountNumber.length(); i++) {
			suma += accountNumber.charAt(i);
		}

		if ((accountNumber.matches("[0-9]{12}") && suma % 2 == 0)) {

			this.accountNumber = accountNumber;
		} else {
			this.accountNumber = "200000000000";
		}

	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		if (accountBalance >= 0.0 && accountBalance <= 1000000.0) {
			this.accountBalance = accountBalance;
		} else {
			this.accountBalance = 0.0;
		}

	}

	public Customer(String name, String surname, String accountNumber, double accountBalance) {
		super();
		setName(name);
		setSurname(surname);
		setAccountNumber(accountNumber);
		setAccountBalance(accountBalance);
	}

	public Customer() {

		System.out.print("Insert customer name: ");
		setName(sc.nextLine());
		System.out.print("Insert customer surname: ");
		setSurname(sc.nextLine());
		System.out.print("Insert customer account number: ");
		setAccountNumber(sc.nextLine());
		System.out.print("Insert customer account balance: ");
		setAccountBalance(Double.parseDouble(sc.nextLine()));

	}

	

	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", accountNumber=" + accountNumber
				+ ", accountBalance=" + accountBalance + "]";
	}

	public void withdraw() {
		System.out.print("Enter amount of money which you would like to withdraw: ");
		double d = Double.parseDouble(sc.nextLine());
		if (d <= accountBalance) {

			accountBalance = -d;

		} else {
			System.out.println("THERE IS NOT ENOUGH MONEY ON YOUR BANK ACCOUNT");
		}

	}

	public void deposit() {

		System.out.print("Enter amount of money which would you like to pay into your bank account: ");
		double d = Double.parseDouble(sc.nextLine());
		if (d > 0) {

			accountBalance += d;
		} else {
			System.out.println("TRANSACTION IMPOSSIBLE TO PERFORM");
		}

	}

	public void customerService() { 

		String numer = null;
		int i = 0;
		do {

			System.out.print("Insert account number: ");
			numer = sc.nextLine();
			if (!numer.matches(accountNumber)&&(i<2)) {
				System.out.println("Please try again");
			}
			i++;
			if (i > 2) {
				System.out.println("BANK ACCOUNT NUMBER ERROR");
			}
		} while ((i < 3) && !numer.matches(accountNumber));

		if (numer.matches(accountNumber)) {
			String transaction = null;
			do{
			System.out.print("Insert which transaction would you like to perform (DEPOSIT/WITHDRAW/STOP) : ");
			transaction = sc.nextLine();
			if (transaction.toUpperCase().matches("WITHDRAW")) {
				withdraw();
			} else if (transaction.toUpperCase().matches("DEPOSIT")) {
				deposit();
			} else if(transaction.toUpperCase().matches("STOP")){
				
			}else {
				System.out.println("TRANSACTION ERROR");
			}
			}while(!transaction.toUpperCase().matches("STOP"));
		}
	}

}
