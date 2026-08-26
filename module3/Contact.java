package module3;

public class Contact {
    //VALUES
    private String name;
    private String phone;

    //FIELDS: data each name holds
    public Contact (String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    //GETTERS
    public String getName() {return name; }
    public String getPhone() {return phone; }

    @Override
    public String toString(){
        return name + " | " + phone;
    }
}


