/**
 * @author Alexander Arizola 
*/
public class PersonData extends HasState implements Cloneable {
    protected String lastName;
    protected String firstName;
    protected String address;
    protected String phone;
    
    public String toString() {
        // Do not change this implementation
        return "First name: "+firstName+"; Last name: "+lastName+"; Address: "+address+"; Phone: "+phone;
    }

    // Non-argument constructor that sets all fields to empty strings.
    public PersonData() {
        lastName = "";
        firstName = "";

        address = "";
        phone = "";
    }

    // Argumentative constructor that sets all fields with parameters.
    public PersonData(String newFirstName, String newLastName, String newAddress, String newPhone) {
        firstName = newFirstName;
        lastName = newLastName;

        address = newAddress;
        phone = newPhone;
    }

    /**
     * Returns the first name of the object.
     * @return The first name.
    */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the object.
     * @param newFirstName The new first name to set within the object.
    */
    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    /**
     * Returns the last name of the object.
     * @return The last name.
    */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the object.
     * @param newLastName The new last name to set within the object.
    */
    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    /**
     * Returns the address of the object.
     * @return The address.
    */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the object.
     * @param newAddress The new address to set within the object.
    */
    public void setAddress(String newAddress) {
        address = newAddress;
    }

    /**
     * Returns the phone number of the object.
     * @return The phone number.
    */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the object.
     * @param newPhone The new phone number to set within the object.
    */
    public void setPhone(String newPhone) {
        phone = newPhone;
    }

    /**
     * Overrides the clone method to provide a deep copy of the object.
     * @return a deep copy of the object
    */
    @Override
    public PersonData clone() {
        try {
            return (PersonData) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning is not supported in this object.");
            System.exit(1);
            return null;
        }
    }

    /**
     * Overrides the equals method to check if two PersonData objects are equal.
     * @param otherObjectToCheck the object to compare with
     * @return true if the objects are equal, false otherwise
    */
    @Override
    public boolean equals(Object otherObjectToCheck) {
        if (this == otherObjectToCheck) {
            return true;
        }


        if (otherObjectToCheck == null || getClass() != otherObjectToCheck.getClass()) {
            return false;
        }

        PersonData obj = (PersonData) otherObjectToCheck;
        return lastName.equals(obj.lastName) && firstName.equals(obj.firstName) && address.equals(obj.address) && phone.equals(obj.phone);
    }
}
