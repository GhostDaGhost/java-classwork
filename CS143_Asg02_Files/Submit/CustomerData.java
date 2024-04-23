import java.util.ArrayList;

/**
 * @author Alexander Arizola 
*/
public class CustomerData extends PersonData {
    private int customerNumber;
    private boolean mailingList;
    private ArrayList<Long> transactions;

    public String toString() {
        //Do not change this implementation
        String str = super.toString()+"; Customer number: "+customerNumber+"; Mailing list: "+mailingList+"; Transactions: "+transactions.toString();
        return str;
    }

    // Non-argument constructor that sets all variables (including inherited ones) to empty strings and transactions to an empty ArrayList.
    public CustomerData() {
        super(); // Calls parent constructor FIRST.

        // Set default values to variables.
        customerNumber = 0;
        mailingList = false;
        transactions = new ArrayList<>();
    }

    // Argumentative constructor that sets all fields with parameters.
    public CustomerData(String newFirstName, String newLastName, String newAddress, String newPhone, int newCustomerNumber, boolean newMailingList, ArrayList<Long> newTransactions) {
        super(newFirstName, newLastName, newAddress, newPhone); // Calls parent constructor FIRST.

        // Set values to variables.
        customerNumber = newCustomerNumber;
        mailingList = newMailingList;
        transactions = new ArrayList<>(newTransactions);
    }

    /**
     * Returns the customer number of the object.
     * @return The customer number.
    */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the customer number of the object.
     * @param newCustomerNumber The new customer number to set within the object.
    */
    public void setCustomerNumber(int newCustomerNumber) {
        customerNumber = newCustomerNumber;
    }

    /**
     * Returns the mailing list flag of the object.
     * @return The mailing list flag.
    */
    public boolean getMailingList() {
        return mailingList;
    }

    /**
     * Sets the mailing list flag of the object.
     * @param newMailingList The new mailing list flag to set within the object.
    */
    public void setMailingList(boolean newMailingList) {
        mailingList = newMailingList;
    }

    /**
     * Returns the transactions of the object.
     * @return The transactions.
    */
    public ArrayList<Long> getTransactions() {
        ArrayList<Long> deepCopyOfTransactions = new ArrayList<>();
        for (Long transaction : transactions) {
            deepCopyOfTransactions.add(transaction);
        }

        // Return the deep copy
        return deepCopyOfTransactions;
    }

    /**
     * Sets the transactions of the object.
     * @param newTransactions The new transactions data to set within the object.
    */
    public void setTransactions(ArrayList<Long> newTransactions) {
        if (newTransactions == null) {
            throw new IllegalArgumentException("New transactions cannot be null.");
        }

        // Create deep copy first and then add transactions
        transactions = new ArrayList<>();
        for (Long newTransaction : newTransactions) {
            transactions.add(newTransaction);
        }
    }

    /**
     * Adds a new transaction to the transactions array list.
     * @param t The new transaction to append to the list.
    */
    public void addTransaction(long t) {
        if (String.valueOf(t).length() > 15 || t <= 0) {
            throw new IllegalArgumentException("You passed an invalid transaction.");
        }

        // Add new transaction to existing array list.
        transactions.add(t);
    }

    /**
     * Overrides the clone method to provide a deep copy of the object.
     * @return a deep copy of the object
    */
    @Override
    public CustomerData clone() {
        CustomerData clonedCustomerData = (CustomerData) super.clone();

        // Deep copy the transactions
        clonedCustomerData.transactions = new ArrayList<>(transactions);
        return clonedCustomerData;
    }

    /**
     * Overrides the equals method to check if two CustomerData objects are equal.
     * @param otherCustomerData the object to compare with
     * @return true if the objects are equal, false otherwise
    */
    @Override
    public boolean equals(Object otherCustomerData) {
        if (this == otherCustomerData) {
            return true;
        }

        if (otherCustomerData == null || getClass() != otherCustomerData.getClass()) {
            return false;
        }

        if (!super.equals(otherCustomerData)) {
            return false;
        }

        CustomerData obj = (CustomerData) otherCustomerData;
        return customerNumber == obj.customerNumber && mailingList == obj.mailingList && transactions.equals(obj.transactions);
    }
}
