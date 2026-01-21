package se.lexicon;

import se.lexicon.controller.ContactController;

/**
 *
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
