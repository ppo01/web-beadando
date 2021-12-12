package web.beadando.view;


import web.beadando.service.PersonCompanyService;
import web.beadando.service.domain.CompanyDto;
import web.beadando.service.domain.PersonCompanyDto;
import web.beadando.service.domain.PersonDto;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Named(value = "personCompanyBean")
@ViewScoped
public class PersonCompanyBean implements Serializable {

    @Inject
    PersonCompanyService personCompanyService;

    private List<PersonCompanyDto> personCompanyDtos;

    private PersonCompanyDto selectedDto = new PersonCompanyDto();

    private CompanyDto newCompanyId;
    private PersonDto newPersonId;

    @PostConstruct
    private void init(){
        personCompanyDtos = personCompanyService.findAll();
        newCompanyId= null;
        newPersonId = null;
    }

    public void addPersonCompany() {
        PersonCompanyDto personCompanyDto = new PersonCompanyDto();
        personCompanyDto.setCompany_id(newCompanyId);
        personCompanyDto.setPerson_id(newPersonId);
        personCompanyDto.setDate(new Date((System.currentTimeMillis())));
        personCompanyService.save(personCompanyDto);
        init();
    }

    public void onRowSelect() {
        newCompanyId = selectedDto.getCompany_id();
        newPersonId = selectedDto.getPerson_id();
    }

    public PersonCompanyBean() {
    }

    public PersonCompanyBean(PersonCompanyService personCompanyService, List<PersonCompanyDto> personCompanyDtos, PersonCompanyDto selectedDto, CompanyDto newCompanyId, PersonDto newPersonId) {
        this.personCompanyService = personCompanyService;
        this.personCompanyDtos = personCompanyDtos;
        this.selectedDto = selectedDto;
        this.newCompanyId = newCompanyId;
        this.newPersonId = newPersonId;
    }

    public PersonCompanyService getPersonCompanyService() {
        return personCompanyService;
    }

    public void setPersonCompanyService(PersonCompanyService personCompanyService) {
        this.personCompanyService = personCompanyService;
    }

    public List<PersonCompanyDto> getPersonCompanyDtos() {
        return personCompanyDtos;
    }

    public void setPersonCompanyDtos(List<PersonCompanyDto> personCompanyDtos) {
        this.personCompanyDtos = personCompanyDtos;
    }

    public PersonCompanyDto getSelectedDto() {
        return selectedDto;
    }

    public void setSelectedDto(PersonCompanyDto selectedDto) {
        this.selectedDto = selectedDto;
    }

    public CompanyDto getNewCompanyId() {
        return newCompanyId;
    }

    public void setNewCompanyId(CompanyDto newCompanyId) {
        this.newCompanyId = newCompanyId;
    }

    public PersonDto getNewPersonId() {
        return newPersonId;
    }

    public void setNewPersonId(PersonDto newPersonId) {
        this.newPersonId = newPersonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonCompanyBean that = (PersonCompanyBean) o;
        return Objects.equals(personCompanyService, that.personCompanyService) && Objects.equals(personCompanyDtos, that.personCompanyDtos) && Objects.equals(selectedDto, that.selectedDto) && Objects.equals(newCompanyId, that.newCompanyId) && Objects.equals(newPersonId, that.newPersonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personCompanyService, personCompanyDtos, selectedDto, newCompanyId, newPersonId);
    }

    @Override
    public String toString() {
        return "PersonCompanyBean{" +
                "personCompanyService=" + personCompanyService +
                ", personCompanyDtos=" + personCompanyDtos +
                ", selectedDto=" + selectedDto +
                ", newCompanyId=" + newCompanyId +
                ", newPersonId=" + newPersonId +
                '}';
    }
}
