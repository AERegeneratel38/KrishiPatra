package Model;

public class User {

    private String Name;
    private String Password;
    private String DOB;
    private String District;

    public User() {
    }

    public User (String name, String password, String dob, String district){
        Name = name;
        Password = password;
        District = district;
        DOB = dob;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }
}
