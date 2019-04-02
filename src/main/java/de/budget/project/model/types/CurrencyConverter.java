package de.budget.project.model.types;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CurrencyConverter implements AttributeConverter<CurrencyType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CurrencyType attribute) {
        return attribute == null ? null : attribute.getId();
    }

    @Override
    public CurrencyType convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : CurrencyType.findCurrencyById(dbData);
    }

}