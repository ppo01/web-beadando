package web.beadando.service.impl;

import org.modelmapper.TypeToken;
import web.beadando.persistence.entity.PersonCompany;
import web.beadando.persistence.entitymanager.CompanyDao;
import web.beadando.persistence.entitymanager.PersonCompanyDao;
import web.beadando.persistence.entitymanager.PersonDao;
import web.beadando.service.PersonCompanyService;
import web.beadando.service.domain.PersonCompanyDto;
import web.beadando.service.ModelMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;

@Stateless
public class PersonCompanyServiceImpl implements PersonCompanyService {

    @Inject
    PersonCompanyDao personCompanyDao;
    @Inject
    PersonDao personDao;
    @Inject
    CompanyDao companyDao;
    @Inject
    ModelMapper modelMapper;

    @Override
    public List<PersonCompanyDto> findAll() {
        List<PersonCompany> entities = personCompanyDao.findAll();
        Type listType = new TypeToken<List<PersonCompanyDto>>() {}.getType();
        return modelMapper.map(entities, listType);
    }

    @Override
    public PersonCompanyDto findOne(Long person_company_id) {
        PersonCompany personCompany = personCompanyDao.findOne(person_company_id);
        Type listType = new TypeToken<PersonCompanyDto>() {}.getType();
        return modelMapper.map(personCompany, listType);
    }

    @Override
    public void save(PersonCompanyDto personCompanyDto) {
        PersonCompany personCompany = new PersonCompany();
        personCompany.setCompany_id(companyDao.findOne(personCompanyDto.getCompany_id().getCompanyId()));
        personCompany.setPerson_id(personDao.findOne(personCompanyDto.getPerson_id().getPersonId()));
        personCompany.setDate(personCompanyDto.getDate());
        personCompanyDao.save(personCompany);
    }

    @Override
    public void modify(PersonCompanyDto personCompanyDto) {
        PersonCompany personCompany = personCompanyDao.findOne(personCompanyDto.getPerson_company_id());
        personCompany.setPerson_id(personCompany.getPerson_id());
        personCompany.setDate(personCompanyDto.getDate());
        personCompanyDao.save(personCompany);
    }

}
