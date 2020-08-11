import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.util.ArrayList;

public class ContactData {
    File file = new File("data.dat");
    File CSVFile = new File("data/contacts.csv");
    ContactManger contactManger = new ContactManger();

    ArrayList<Contact> open() throws IOException, ClassNotFoundException {
        ArrayList<Contact> result = new ArrayList<>();
        ObjectInputStream ois  = new ObjectInputStream(new FileInputStream(file));
        result =(ArrayList<Contact>) ois.readObject();
        ois.close();
        return result;
    }

    void save(ArrayList<Contact> listContact) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(listContact);
        oos.close();
    }

    void readCSV(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(CSVFile));
            String line;
            String[] arrayString;
            Contact contact = new Contact();
            while ((line = bufferedReader.readLine())!= null){
                arrayString = line.split(", ");
                for (String s: arrayString){
                    System.out.print(s + "\t");
                }
                System.out.println();

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void writerCSV() {
        try {
            PrintWriter writer = new PrintWriter(CSVFile);
            writer.write("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email");
            for (Contact contact: contactManger.contactList){
                writer.println(contact.getPhoneNumber()+
                        ","+contact.getGroup()+
                        ","+contact.getFullName()+
                        ","+contact.getGender()+
                        ","+contact.getAddress()+
                        ","+contact.getDateOfBirth()+
                        ","+contact.getEmail());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
