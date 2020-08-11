import java.util.*;
import java.util.regex.Pattern;

public class ContactManger {
    ArrayList<Contact> contactList = new ArrayList<>();
    Iterator<Contact> iterator = contactList.iterator();
    ArrayList<Contact> tempList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private final static ContactManger instance = new ContactManger();
    Queue<Contact> queue = new LinkedList<>();



    public ContactManger() {
        queue.addAll(contactList);
    }

    public ArrayList<Contact> getListContact(){
        return contactList;
    }

    public void showList(){
        ArrayList<Contact> result = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            result.add(queue.poll());
        }
        showList(result);
    }

    public void showList(ArrayList<Contact> list) {
        for (Contact contact: list){
            System.out.println(contact);
        }
        System.out.println();

    }

    public static ContactManger getInstance(){
        return instance;
    }

    public void addContact() {
        String phoneNumber;
        String group;
        String fullName;
        String gender;
        String address;
        String dateOfBirth;
        String email;
        do {
            System.out.println("nhap so dien thoai:");
            phoneNumber = scanner.nextLine();
            System.out.println("nhap nhom danh ba:");
             group = scanner.nextLine();
            System.out.println("nhap gioi ho ten: ");
             fullName = scanner.nextLine();
            System.out.println("nhap gioi tinh: ");
             gender = scanner.nextLine();
            System.out.println("nhap dia chi: ");
             address = scanner.nextLine();
            System.out.println("nhap ngay sinh: ");
             dateOfBirth = scanner.nextLine();
            System.out.println("nhap email: ");
             email = scanner.nextLine();
        } while (phoneNumber == null || group == null || fullName== null||gender == null || address == null ||dateOfBirth == null || email == null);

        Contact newContact = new Contact(phoneNumber,group,fullName,gender,address,dateOfBirth,email);
        contactList.add(newContact);
    }

    public void edit(int index,String phoneNumber, String group,String fullName, String gender, String address, String dateOfBirth,String email ) {

        Contact current = contactList.get(index);
        current.setPhoneNumber(phoneNumber);
        current.setGroup(group);
        current.setFullName(fullName);
        current.setGender(gender);
        current.setAddress(address);
        current.setDateOfBirth(dateOfBirth);
        current.setEmail(email);

    }

    public boolean removeByName(String name) {
        while (iterator.hasNext()) {
            Contact current = iterator.next();
            if (current.getPhoneNumber().equalsIgnoreCase(name)) {
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
            if (checkKey(keyword,contact.getPhoneNumber())){
                set.add(contact);
            }
            if (checkKey(keyword,contact.getGender())){
                set.add(contact);
            }
        }
        result.addAll(set);
        return result;
    }

    private boolean checkKey(String key, String target){
        String regex = ".*" + key + ".*";
        boolean isExist = Pattern.matches(regex,target);
        return isExist;
    }


}
