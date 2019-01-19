import java.util.Scanner;

public class MobilePhone {
    private Scanner scanner = new Scanner(System.in);
    private Contacts contacts = new Contacts();
    private String[] menuOptions = { "1 -- Print List of Contacts", "2 -- Add New Contact",
            "3 -- Update Existing Contact", "4 -- Remove Contact", "5 -- Search for Contact", "9 -- Quit" };

    private void storeContact() {
        System.out.print("Contact Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone Number: "); 
        String phoneNumber = scanner.nextLine();
        contacts.storeContact(name, phoneNumber);
        System.out.println();
    }

    private boolean modifyContact() {
        System.out.print("Contacts name: ");
        String oldName = scanner.nextLine();
        System.out.print("Updated name: ");
        String newName = scanner.nextLine();
        System.out.print("Updated phone number: ");
        String newPhoneNumber = scanner.nextLine();
        System.out.println();
        return contacts.modifyContact(oldName, newName, newPhoneNumber);
    }

    private boolean removeContact() {
        System.out.print("Contact to remove: ");
        String name = scanner.nextLine();
        return contacts.removeContact(name);
    }

    private void queryContacts() {
        System.out.print("Contact Name: ");
        String name = scanner.nextLine();
        if (contacts.hasContact(name)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private void printContacts() {
        for (Contact contact : contacts.getContacts()) {
            System.out.println("Name: " + contact.getName() + ", Phone Number: " + contact.getPhoneNumber());
        }
        System.out.println();
    }

    public void showMenu() {
        boolean showAgain = true;
        while (showAgain) {
            System.out.println("Please Select from the following menu: ");
            for (String menuItem : menuOptions) {
                System.out.println(menuItem);
            }
    
            int selectedMenuItem = scanner.nextInt();
            scanner.nextLine();
    
            switch (selectedMenuItem) {
            case 1:
                printContacts();
                break;
            case 2:
                storeContact();
                break;
            case 3:
                modifyContact();
                break;
            case 4:
                removeContact();
                break;
            case 5:
                queryContacts();
                break;
            case 9:
                showAgain = false;
                break;
            default:
                continue;
            }
        }

    }
}