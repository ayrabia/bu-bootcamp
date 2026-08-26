package module3;

import java.util.*;

public class ContactManager {
    
    public static void main(String[] args){
        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: add contacts here
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Ayman Rabia", new Contact("Ayman Rabia", "+1 408 564 4309"));
        contacts.put("John Smith", new Contact("John Smith", "+1 123 456 7890"));
        contacts.put("Joe Hamilton", new Contact("Joe Hamilton", "+2 657 324 4839"));
        contacts.put("Nora Grace", new Contact("Nora Grace", "+3 567 586 2344"));

        // Step 5: look up a contact
        String searchName = "Ada Lovelace";
        Contact found = contacts.get(searchName);

        if (found == null){
            System.out.println("Contact Not Found!");
        }else{
            System.out.println("Contact Found: "+ found);
        }

        //testing with a name that does not exist
        String missingName = "Joe Melon";
        Contact notFound = contacts.get(missingName);

        if (found == null){
            System.out.println("Contact Not Found!");
        }else{
            System.out.println("Contact Found: " + notFound);
        }


        // Step 6: print sorted list
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("All Contacts: ");
        for(Contact c : sorted){
            System.out.println(c);
        }

    }

}
