import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

public class ContactManger {
    ArrayList<Contact> contactList = new ArrayList<>();
    Iterator<Contact> iterator = contactList.iterator();

    public ContactManger() {

    }

    public void showList() {
        for (Contact contact : contactList)
            System.out.println(contact);
    }

    public void addContact(Contact newContact) {
        contactList.add(newContact);
    }

    public void updateList() {

    }

    public boolean removeByName(String name) {
        while (iterator.hasNext()) {
            Contact current = iterator.next();
            if (current.getFullName().equalsIgnoreCase(name)) {
                contactList.remove(current);
                return true;
            }
        }
        return false;
    }

    public boolean removeByPhoneNumber(String phoneNumber) {
        while (iterator.hasNext()) {
            Contact current = iterator.next();
            if (current.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                contactList.remove(current);
                return true;
            }

        }
        return true;
    }

    public ArrayList<Contact> find(String keyword) {
        ArrayList<Contact> result = new ArrayList<>();
        HashSet<Contact> set = new HashSet<>();
        for (Contact contact: contactList){
            if (checkKey(keyword,contact.getPhoneNumber())){
                set.add(contact);
            }
            if (checkKey(keyword,contact.getFullName())){
                set.add(contact);
            }
        }
        return result;
    }

    private boolean checkKey(String key, String target){
        String regex = ".*" + key + ".*";
        boolean isExist = Pattern.matches(regex,target);
        return isExist;
    }


}
