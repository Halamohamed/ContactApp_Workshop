package se.lexicon.model;

/**
 * Represents a contact with a name and phone number.
 */
public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) throw new IllegalArgumentException("Name cannot be null");
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || !phoneNumber.matches("^\\d{10}$"))
            throw new IllegalArgumentException("Phone number cannot be null or must be 10 digits");
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
