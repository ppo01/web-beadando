package web.beadando.service;

import web.beadando.service.domain.CompanyDto;

import java.util.List;


public interface CompanyService {
    List<CompanyDto> findAll();
    void save(CompanyDto companyDto);
    void modify(CompanyDto companyDto);
    void delete(CompanyDto companyDto);

    CompanyDto findOne(Long company_id);
}

