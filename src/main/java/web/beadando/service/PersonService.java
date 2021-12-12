package web.beadando.service;

import web.beadando.service.domain.PersonDto;

import java.util.List;

public interface PersonService {
    List<PersonDto> findAll();
    void save(PersonDto personDto);
    void modify(PersonDto personDto);
    void delete(PersonDto personDto);

    PersonDto findOne(Long id);
}
