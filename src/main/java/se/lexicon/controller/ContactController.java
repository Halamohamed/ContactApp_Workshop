package se.lexicon.controller;

import se.lexicon.data.ContactDAO;
import se.lexicon.data.FileContactDAOImpl;
import se.lexicon.exception.ExceptionHandler;
import se.lexicon.model.Contact;
import se.lexicon.view.ContactView;

public class ContactController {

    ContactDAO dao;
    ContactView view;

    public ContactController() {
        this.dao = new FileContactDAOImpl();
        this.view = new ContactView();
    }

    public void run(){
        boolean exit = false;
        while (!exit) {
            view.displayMenu();
            String choice = view.getUserInput("Select an option: ");
            switch (choice) {
                case "1":
                    String name = view.getUserInput("Enter contact name: ");
                    String phoneNumber = view.getUserInput("Enter contact phone number: ");
                    try {
                        dao.save(new Contact(name, phoneNumber));
                        view.displayMessage("Contact saved successfully.");
                    } catch (Exception e) {
                        view.displayError(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        view.displayContacts(dao.findAll());
                    } catch (Exception e) {
                        view.displayError(e.getMessage());
                    }
                    break;
                case "3":
                    String searchName = view.getUserInput("Enter contact name to search: ");
                    try {
                        Contact contact = dao.findByName(searchName);
                        if (contact != null) {
                            view.displayMessage("Contact found: " + contact);
                        } else {
                            view.displayMessage("Contact not found.");
                        }
                    } catch (Exception e) {
                        view.displayError(e.getMessage());
                    }
                    break;
                case "4":
                    IO.println("Exiting the application. Goodbye!");
                    exit = true;
                    break;
                default:
                    view.displayMessage("Invalid option. Please try again.");
            }
        }

    }
}
