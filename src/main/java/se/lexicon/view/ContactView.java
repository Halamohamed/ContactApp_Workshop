package se.lexicon.view;

import se.lexicon.model.Contact;

import java.util.List;

/**
 * View class to handle user interactions for contact management.
 */
public class ContactView {

    public String getUserInput(String prompt) {
        String name = IO.readln(prompt);
        return name;
    }

    // Display menu options to the user
    public void displayMenu() {
        IO.println("Contact Management System");
        IO.println("1. Add Contact");
        IO.println("2. View Contacts");
        IO.println("3. Search Contact");
        IO.println("4. Exit");
    }

    // Display a list of contacts
    public void displayContacts(List<Contact> contacts){
        if(contacts.isEmpty()){
            IO.println("No contacts available.");
        } else {
            for (Contact contact : contacts) {
                IO.println(contact.toString());
            }
        }
    }

    // Display a general message to the user
    public void displayMessage(String message){
        IO.println(message);
    }

    // Display an error message to the user
    public void displayError(String errorMessage){
        IO.println("Error: " + errorMessage);
    }
}
