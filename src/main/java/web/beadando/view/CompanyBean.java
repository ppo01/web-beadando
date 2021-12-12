package web.beadando.view;

import web.beadando.service.CompanyService;
import web.beadando.service.domain.CompanyDto;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "companyBean")
@ViewScoped
public class CompanyBean implements Serializable {
    @Inject
    CompanyService companyService;



    private String newCompanyName;
    private String newAddress;
    private String newMainActivity;

    private List<CompanyDto> companyDtos;

    private CompanyDto selectedDto = new CompanyDto();

    @PostConstruct
    private void init(){
        companyDtos = companyService.findAll();
        newCompanyName = null;
        newAddress = null;
        newMainActivity = null;
    }

    public void deleteCompany() { ;
        companyService.delete(selectedDto);
        init();
    }

    public void newCompany() {
        CompanyDto company = new CompanyDto();
        company.setCompanyName(newCompanyName);
        company.setAddress(newAddress);
        company.setMainActivity(newMainActivity);
        companyService.save(company);
        init();
    }

    public void onRowSelect() {
        newCompanyName = selectedDto.getCompanyName();
        newAddress = selectedDto.getAddress();
        newMainActivity = selectedDto.getMainActivity();
    }

    public void modifyCompany() {
        selectedDto.setCompanyName(newCompanyName);
        selectedDto.setAddress(newAddress);
        selectedDto.setMainActivity(newMainActivity);
        companyService.modify(selectedDto);
        init();
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public String getNewCompanyName() {
        return newCompanyName;
    }

    public void setNewCompanyName(String newCompanyName) {
        this.newCompanyName = newCompanyName;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getNewMainActivity() {
        return newMainActivity;
    }

    public void setNewMainActivity(String newMainActivity) {
        this.newMainActivity = newMainActivity;
    }

    public List<CompanyDto> getCompanyDtos() {
        return companyDtos;
    }

    public void setCompanyDtos(List<CompanyDto> companyDtos) {
        this.companyDtos = companyDtos;
    }

    public CompanyDto getSelectedDto() {
        return selectedDto;
    }

    public void setSelectedDto(CompanyDto selectedDto) {
        this.selectedDto = selectedDto;
    }
}
