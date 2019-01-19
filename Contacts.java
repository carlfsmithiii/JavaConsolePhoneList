import java.util.ArrayList;

public class Contacts {
    private ArrayList<Contact> contactsList = new ArrayList<Contact>();

    public void storeContact(String name, String phoneNumber) {
        contactsList.add(new Contact(name, phoneNumber));
    }

    public boolean modifyContact(String oldName, String newName, String newPhoneNumber) {
        Contact match = findMatch(oldName);
        if (match == null) {
            return false;
        }
        match.setName(newName);
        match.setPhoneNumber(newPhoneNumber);
        return true;
    }

    private Contact findMatch(String name) {
        for (Contact contact : contactsList) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public boolean removeContact(String name) {
        Contact match = findMatch(name);
        if (match == null) {
            return false;
        }
        contactsList.remove(match);
        return true;
    }

    public boolean hasContact(String name) {
        Contact match = findMatch(name);
        return !(match == null);
    }

    public Contact[] getContacts() {
        return contactsList.toArray(new Contact[contactsList.size()]);
    }
}