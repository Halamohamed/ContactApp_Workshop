package se.lexicon.exception;

public class ExceptionHandler{

    public void handler(Exception e){
        IO.println("An error occurred: " + e.getMessage());

    }
}
