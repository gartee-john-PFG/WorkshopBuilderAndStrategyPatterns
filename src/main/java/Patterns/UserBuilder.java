package Patterns;

public class UserBuilder {
    public final String firstName;
    public final String lastName;
    public int age;
    public String phone;
    public String address;

    public  UserBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }
    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }
    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    //  notice we are passing the Builder into the c-tor in this implementation
    public User build() {
        User user =  new User(this);
        validateUserObject(user);
        return user;
    }
    private void validateUserObject(User user) throws IllegalArgumentException {
        if(user.getFirstName() == null ){
            throw new IllegalArgumentException("First name missing");
        }

        if(user.getLastName() == null){
            throw new IllegalArgumentException("Last name missing");
        }
    }
}
