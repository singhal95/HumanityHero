package humanity.nishcha.com.humanity0;

/**
 * Created by Nitin on 4/26/2018.
 */

public class Admin {


    int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    String name,email,ngo,address,phone,password;


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNgo(String ngo) {
        this.ngo = ngo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNgo() {
        return ngo;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
