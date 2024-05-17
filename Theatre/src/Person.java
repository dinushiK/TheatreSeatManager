public class Person {
    private String firstName;
    private String Surname;
    private String Email;

    public Person(String name, String surname, String email) {
        this.firstName = name;
        this.Surname = surname;
        this.Email = email;
    }

    public String getName() {
        return firstName;
    }

    public String getSurname() {
        return Surname;
    }

    public String getEmail() {
        return Email;
    }
}