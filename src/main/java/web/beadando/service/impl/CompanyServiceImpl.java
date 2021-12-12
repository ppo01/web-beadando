package web.beadando.service.impl;


import web.beadando.persistence.entity.Company;
import web.beadando.persistence.entitymanager.CompanyDao;
import web.beadando.service.CompanyService;
import web.beadando.service.domain.CompanyDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;

@Stateless
public class CompanyServiceImpl implements CompanyService {

    @Inject
    CompanyDao companyDao;
    @Inject
    ModelMapper modelMapper;

    @Override
    public List<CompanyDto> findAll() {
        List<Company> entities = companyDao.findAll();
        Type listType = new TypeToken<List<CompanyDto>>() {}.getType();
        return modelMapper.map(entities, listType);
    }

    @Override
    public CompanyDto findOne(Long company_id) {
        Company company = companyDao.findOne(company_id);
        Type listType = new TypeToken<CompanyDto>() {}.getType();
        return modelMapper.map(company, listType);
    }


    @Override
    public void save(CompanyDto companyDto) {
        Company company = new Company();
        company.setCompanyName(companyDto.getCompanyName());
        company.setAddress(companyDto.getAddress());
        company.setMainActivity(companyDto.getMainActivity());
        companyDao.save(company);

    }

    @Override
    public void modify(CompanyDto companyDto) {
        Company company = companyDao.findOne(companyDto.getCompanyId());
        company.setCompanyName(companyDto.getCompanyName());
        company.setAddress(companyDto.getAddress());
        company.setMainActivity(companyDto.getMainActivity());
        companyDao.save(company);
    }

    @Override
    public void delete(CompanyDto companyDto) {
        Company company = companyDao.findOne(companyDto.getCompanyId());
        companyDao.delete(company);
    }

}
