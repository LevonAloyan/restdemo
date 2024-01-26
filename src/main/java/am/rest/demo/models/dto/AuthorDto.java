package am.rest.demo.models.dto;

public class AuthorDto {

    private Integer identificator;
    private String name;
    private String surname;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getIdentificator() {
        return identificator;
    }

    public void setIdentificator(Integer identificator) {
        this.identificator = identificator;
    }
}
