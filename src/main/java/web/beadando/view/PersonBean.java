package web.beadando.view;

import web.beadando.service.PersonService;
import web.beadando.service.domain.CompanyDto;
import web.beadando.service.domain.PersonDto;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "personBean")
@ViewScoped
public class PersonBean implements Serializable {
    @Inject
    PersonService personService;

    private List<PersonDto> personDtos;
    private PersonDto selectedDto = new PersonDto();

    private String newName;
    private String newPosition;

    @PostConstruct
    private void init(){
        personDtos = personService.findAll();
        newName = null;
        newPosition = null;
    }

    public void onRowSelect() {
        newName = selectedDto.getPersonName();
        newPosition = selectedDto.getPosition();
    }

    public void save() {
        PersonDto person = new PersonDto();
        person.setPersonName(newName);
        person.setPosition(newPosition);
        personService.save(person);
        init();
    }




    public void modify() {
        selectedDto.setPersonName(newName);
        selectedDto.setPosition(newPosition);
        personService.modify(selectedDto);
        init();
    }

    public void delete() { ;
        personService.delete(selectedDto);
        init();
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public List<PersonDto> getPersonDtos() {
        return personDtos;
    }

    public void setPersonDtos(List<PersonDto> personDtos) {
        this.personDtos = personDtos;
    }

    public PersonDto getSelectedDto() {
        return selectedDto;
    }

    public void setSelectedDto(PersonDto selectedDto) {
        this.selectedDto = selectedDto;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(String newPosition) {
        this.newPosition = newPosition;
    }
}
