package se.lexicon.data;

import se.lexicon.exception.ContactStorageException;
import se.lexicon.exception.DuplicateContactException;
import se.lexicon.model.Contact;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * File-based implementation of ContactDAO.
 * Stores contacts in a text file.
 */
public class FileContactDAOImpl implements ContactDAO{

    Path filePath = Path.of("dir/contacts.txt");

    // Reads List of contacts from file
    @Override
    public List<Contact> findAll() throws Exception {
        List<Contact> contacts = new ArrayList<>();
        if(!Files.exists(filePath)) return contacts;
        try (BufferedReader reader = Files.newBufferedReader(filePath)){

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                contacts.add(new Contact(parts[0], parts[1]));
            }
        }catch (IOException e){
            throw new ContactStorageException("Error reading contacts from file: " + filePath.toString());
        }
        return contacts;
    }

    // Saves a new contact to the file
    @Override
    public void save(Contact contact) throws Exception {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if(findByName(contact.getName()) != null){
            throw new DuplicateContactException("Contact with name " + contact.getName() + " already exists.");
        }
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND)) {
            writer.write(contact.getName() + "," + contact.getPhoneNumber());
            writer.newLine();
        } catch (IOException e) {
            throw new ContactStorageException("Error saving contact to file: " + filePath.toString());
        }

    }

    // Finds a contact by name
    @Override
    public Contact findByName(String name) throws Exception {
        return findAll().stream().filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

}



