package web.beadando.service.impl;

import web.beadando.persistence.entity.Person;
import web.beadando.persistence.entitymanager.PersonDao;
import web.beadando.service.PersonService;
import web.beadando.service.domain.CompanyDto;
import web.beadando.service.domain.PersonDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;


@Stateless
public class PersonServiceImpl implements PersonService {
    @Inject
    PersonDao personDao;
    @Inject
    ModelMapper modelMapper;

    @Override
    public List<PersonDto> findAll() {
        List<Person> entities = personDao.findAll();
        Type listType = new TypeToken<List<PersonDto>>() {}.getType();
        return modelMapper.map(entities, listType);
    }

    @Override
    public PersonDto findOne(Long person_id) {
        Person person = personDao.findOne(person_id);
        Type listType = new TypeToken<CompanyDto>() {
        }.getType();
        return modelMapper.map(person, listType);
    }



    @Override
    public void save(PersonDto personDto) {
        Person person = new Person();
        person.setPersonName(personDto.getPersonName());
        person.setPosition(personDto.getPosition());
        personDao.save(person);

    }

    @Override
    public void modify(PersonDto personDto) {
        Person person = personDao.findOne(personDto.getPersonId());
        person.setPersonName(personDto.getPersonName());
        person.setPosition(personDto.getPosition());
        personDao.save(person);
    }

    @Override
    public void delete(PersonDto personDto) {
        Person person = personDao.findOne(personDto.getPersonId());
        personDao.delete(person);
    }
}
