package web.beadando.service.domain;

import java.util.Objects;

public class PersonDto {

    private Long personId;
    private String personName;
    private String position;

    public PersonDto() {
    }

    public PersonDto(Long personId, String personName, String position) {
        this.personId = personId;
        this.personName = personName;
        this.position = position;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(personId, personDto.personId) && Objects.equals(personName, personDto.personName) && Objects.equals(position, personDto.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, personName, position);
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
