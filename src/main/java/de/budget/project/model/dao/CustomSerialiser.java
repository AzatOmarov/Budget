package de.budget.project.model.dao;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import de.budget.project.model.types.CategoryType;

import java.io.IOException;

public class CustomSerialiser extends StdSerializer<CategoryType> {

    public CustomSerialiser(Class<CategoryType> cTypeSerialiser){
        super(cTypeSerialiser);
    }
    @Override
    public void serialize(CategoryType categoryType, JsonGenerator gen, SerializerProvider provider) throws IOException {


        gen.writeStartObject();
            gen.writeFieldId(categoryType.getId());
            gen.writeFieldName(categoryType.getName());
        gen.writeEndObject();
    }
}
