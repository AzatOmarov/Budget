package de.budget.project.model.dao;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.budget.project.model.types.CategoryType;

import java.io.IOException;

public class CustomDeserializer extends StdDeserializer<CategoryType> {


    public CustomDeserializer(Class<CategoryType> ct) {
        super(ct);
    }

    @Override
    public CategoryType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        long id = 0;
        String name = null;
        JsonToken token = null;
        while ((token = p.nextValue()) != null) {
            switch (token) {
                case VALUE_NUMBER_INT:
                    if (p.getCurrentName().equals("id")) {
                        id = p.getLongValue();
                    }
                    break;
                case VALUE_STRING:
                    switch (p.getCurrentName()) {
                        case "name":
                            name = p.getText();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;

            }
        }
        return CategoryType.valueOf(name);
    }
}
