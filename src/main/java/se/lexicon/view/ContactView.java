package se.lexicon.view;

import se.lexicon.model.Contact;

import java.util.List;

public class ContactView {

    public String getUserInput(String prompt) {
        String name = IO.readln(prompt);
        return name;
    }

    public void displayMenu() {
        IO.println("Contact Management System");
        IO.println("1. Add Contact");
        IO.println("2. View Contacts");
        IO.println("3. Search Contact");
        IO.println("4. Exit");
    }

    public void displayContacts(List<Contact> contacts){
        if(contacts.isEmpty()){
            IO.println("No contacts available.");
        } else {
            for (Contact contact : contacts) {
                IO.println(contact.toString());
            }
        }
    }

    public void displayMessage(String message){
        IO.println(message);
    }

    public void displayError(String errorMessage){
        IO.println("Error: " + errorMessage);
    }
}
