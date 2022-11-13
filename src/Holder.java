import java.time.LocalDate;

public class Holder {
    private String name;
    private String surname;
    private LocalDate birthday;

    public Holder (String name, String surname, LocalDate birthday){
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Holder{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

