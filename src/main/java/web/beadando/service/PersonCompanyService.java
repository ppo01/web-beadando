package web.beadando.service;

import web.beadando.service.domain.PersonCompanyDto;

import java.util.List;

public interface PersonCompanyService {

    List<PersonCompanyDto> findAll();
    void save(PersonCompanyDto personCompanyDto);
    void modify(PersonCompanyDto personCompanyDto);

    /*

    void delete(PersonCompanyDto personCompanyDto);
    void saveStatuszId(Jegy jegy);
     */

    PersonCompanyDto findOne(Long person_company_id);

}
