public class Contact {
    private String fullName;
    private String phoneNumber;
    private String address;
    private String email;
    private String facebookAccount;

    public Contact() {
    }

    public Contact(String fullName, String phoneNumber, String address, String email, String facebookAccount) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.facebookAccount = facebookAccount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebookAccount() {
        return facebookAccount;
    }

    public void setFacebookAccount(String facebookAccount) {
        this.facebookAccount = facebookAccount;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", facebookAccount='" + facebookAccount + '\'' +
                '}';
    }
}
