package de.budget.project.model.currency;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CurrencyConverter implements AttributeConverter<Currency, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Currency attribute) {
        return attribute == null ? null : attribute.getId();
    }

    @Override
    public Currency convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : Currency.findCurrencyById(dbData);
    }
}