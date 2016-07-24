package ifpb.dac.domain;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/02/2016, 10:18:57
 */
@Converter(autoApply = true)
public class ConvertLocalDate
        implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        if (attribute == null) {
            return null;
        }
        return Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        if (dbData == null) {
            return null;
        }
        
        return dbData.toLocalDate();
        
    }
    //converter LocalDate to Date
    //converter Date to LocalDate
}
