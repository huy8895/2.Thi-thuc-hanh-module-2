import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    ContactManger contactManger = ContactManger.getInstance();
    ContactData contactData = new ContactData();
    private final String ONE = "1";
    private final String TWO = "2";
    private final String THREE = "3";
    private final String FOUR = "4";
    private final String FIVE = "5";
    private final String SIX = "6";
    private final String SEVEN = "7";
    private final String EIGHT = "8";
    private final String ZERO = "0";


    private static String choice ;
    void showMenu(){
        while (true) {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục): ");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Cập nhật ");
            System.out.println("4. Xóa ");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ File ");
            System.out.println("7. Ghi vào File ");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng: ");
            choice = scanner.nextLine();
            setFunction();
        }
    }

    void setFunction(){
        switch (choice){
            case ONE:
                contactManger.showList(contactManger.getListContact());
                if (contactManger.getListContact().size() == 0){
                    System.out.println("danh sanh rong");
                }
                System.out.println();
                break;
            case TWO:
                contactManger.addContact();
                break;
            case THREE:
                editMenu();
                break;
            case FOUR:
                menuRemove();
                break;
            case FIVE:
                menuFind();
                break;
            case SIX:
                contactData.readCSV();
                break;
            case SEVEN:
                contactData.writerCSV();
                break;
            case EIGHT:
                System.exit(0);
                break;
            default:
                showMenu();

        }
    }

    private void editMenu() {
        int index;

        System.out.println("nhap index cua contact can chinh sua: ");
        index = scanner.nextInt();
        scanner.nextLine();
        contactManger.edit(index);

    }

    void menuRemove(){
        System.out.println("chon phuong thuc xoa:");
        System.out.println("1. xoa theo ten nhap vao: ");
        System.out.println("2. xoa theo so dien thoai: ");
        System.out.println("0. quay tro lai ");
        choice = scanner.nextLine();
        switch (choice){
            case ONE:
                System.out.println("nhap ten: ");
                contactManger.removeByName(scanner.nextLine());
                break;
            case TWO:
                System.out.println("nhap so dien thoai: ");
                contactManger.removeByPhoneNumber(scanner.nextLine());
                break;
            case ZERO:
                showMenu();
                break;
            default:
                menuRemove();
        }
    }

    void menuFind(){
        ArrayList<Contact> result = new ArrayList<>();
        System.out.println("nhap tu khoa:");
        result = contactManger.find(scanner.nextLine());
        contactManger.showList(result);
        showMenu();

    }


}
