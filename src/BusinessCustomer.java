

public class BusinessCustomer extends Customer {

	private double tax;

	private int transactionCounter = 0; 

	private final int transactionAmountMax = 2;

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		if (tax >= 10.0 && tax <= 20.0) {
			this.tax = tax;
		} else {
			this.tax = 10.0;
		}
	}

	public int getTransactionAmountMax() {
		return transactionAmountMax;
	}

	

	public BusinessCustomer(String name, String surname, String accountNumber, double accountBalance, double tax) {
		super(name, surname, accountNumber, accountBalance);
		this.tax = tax;
	}

	public BusinessCustomer() {

		
		System.out.print("Set tax: ");
		setTax(Double.parseDouble(sc.nextLine()));

	}

	

	@Override
	public String toString() {
		return "BusinessCustomer [tax=" + tax + "]";
	}

	@Override
	public void withdraw() {
		System.out.print("Enter amount of money which you would like to withdraw: ");
		double d = Double.parseDouble(sc.nextLine());
		
		if (transactionCounter > transactionAmountMax
				&& (1 + tax * 0.01) * d + 0.02 * getAccountBalance() <= getAccountBalance()) {
			setAccountBalance(getAccountBalance() - d - (0.01 * d * tax) - (0.02 * getAccountBalance())); 
		} else if ((1 + tax * 0.01) * d <= getAccountBalance()) {
			setAccountBalance(getAccountBalance() - d - (0.01 * d * tax));
		} else {
			System.out.println("THERE IS NOT ENOUGH MONEY ON YOUR BANK ACCOUNT");
		}
		transactionCounter++;
	}

	@Override
	public void deposit() {
		System.out.print("Enter amount of moeny which would you like to pay into your bank account: ");
		double d = Double.parseDouble(sc.nextLine());
		if (d > 0) {

			if (transactionCounter > transactionAmountMax) {

				setAccountBalance(getAccountBalance() + d - (0.01 * d * tax) - (0.02 * getAccountBalance()));
			} else {
				setAccountBalance(getAccountBalance() + d - (0.01 * d * tax));
			}
			transactionCounter++;
		} else {
			System.out.println("TRANSACTION IMPOSSIBLE TO PERFORM");
		}
	}

	@Override
	public void customerService() {

		String numer = null;
		int i = 0;
		do {

			System.out.print("Insert account number: ");
			numer = sc.nextLine();
			if (!numer.matches(getAccountNumber())) {
				System.out.println("Please try again");
			}
			i++;
		} while ((i < 3) && !numer.matches(getAccountNumber()));

		if (numer.matches(getAccountNumber())) {
			String transaction = null;
			do {
				System.out.print("Insert which transaction would you like to perform (DEPOSIT/WITHDRAW/STOP) : ");
				transaction = sc.nextLine();
				if (transaction.toUpperCase().matches("WITHDRAW")) {
					withdraw();
				} else if (transaction.toUpperCase().matches("DEPOSIT")) {
					deposit();
				} else if (transaction.toUpperCase().matches("STOP")) {

				} else {
					System.out.println("TRANSACTION ERROR");
				}
			} while (!transaction.toUpperCase().matches("STOP"));
		}
	}

}
