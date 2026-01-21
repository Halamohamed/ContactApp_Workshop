package se.lexicon.data;

import se.lexicon.exception.ContactStorageException;
import se.lexicon.exception.DuplicateContactException;
import se.lexicon.model.Contact;

import java.util.List;

public interface ContactDAO {
    public List<Contact> findAll() throws Exception;
    public void save(Contact contact) throws Exception, ContactStorageException;
    public Contact findByName(String name) throws Exception;

}
