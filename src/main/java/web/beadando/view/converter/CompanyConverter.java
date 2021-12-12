package web.beadando.view.converter;


import web.beadando.service.CompanyService;
import web.beadando.service.domain.CompanyDto;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@FacesConverter(value = "companyTConverter", managed = true)
public class CompanyConverter implements Converter {

    @Inject
    CompanyService companyService;


    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return findOneById(companyService.findAll(),Long.valueOf(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    public CompanyDto findOneById(List<CompanyDto> list, Long id){
        for(CompanyDto dto: list){
            if(dto.getCompanyId().equals(id))
                return dto;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((CompanyDto) object).getCompanyId());
        }
        else {
            return null;
        }
    }
}
