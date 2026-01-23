package se.lexicon.exception;

public class ExceptionHandler{

    ContactStorageException contactStorageException;
    DuplicateContactException duplicateContactException;
    public void handler(Exception e){
        if(e.equals(contactStorageException))
        IO.println("Error reading contacts from file: "  + e.getMessage());
        else if(e.equals(duplicateContactException))
            IO.println("Error contact is already exists: " + e.getMessage());
         else  {
            IO.println("Error Occurred :" + e.getMessage());
        }

    }
}
