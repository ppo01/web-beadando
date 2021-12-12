package web.beadando.view.converter;


import web.beadando.service.PersonService;
import web.beadando.service.domain.PersonDto;

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
@FacesConverter(value = "personTConverter", managed = true)
public class PersonConverter implements Converter {

    @Inject
    PersonService personService;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return findOneById(personService.findAll(),Long.valueOf(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    public PersonDto findOneById(List<PersonDto> list, Long id){
        for(PersonDto dto: list){
            if(dto.getPersonId().equals(id))
                return dto;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((PersonDto) object).getPersonId());
        }
        else {
            return null;
        }
    }

}
