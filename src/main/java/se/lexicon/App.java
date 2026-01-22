package se.lexicon;

import se.lexicon.controller.ContactController;

/**
 * Entry point for the Contact Management System application.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IO.println( "Welcome to the Contact Management System!" );
        ContactController controller = new ContactController();
        controller.run();
    }
}
