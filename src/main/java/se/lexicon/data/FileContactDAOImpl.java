package se.lexicon.data;

import se.lexicon.model.Contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileContactDAOImpl implements ContactDAO{

    Path filePath;

    @Override
    public List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<>();
        if(!Files.exists(filePath)) return contacts;
        try {
            BufferedReader reader = Files.newBufferedReader(filePath);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                contacts.add(new Contact(parts[0], parts[1]));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void save(Contact contact) {

    }

    @Override
    public Contact findByName(String name) {
        return null;
    }
}
