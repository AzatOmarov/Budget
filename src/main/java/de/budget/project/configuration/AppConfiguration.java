package de.budget.project.configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.budget.project.model.dao.CustomDeserializer;
import de.budget.project.model.dao.CustomSerialiser;
import de.budget.project.model.types.CategoryType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public Module module(){
//        ObjectMapper objectMapper = new ObjectMapper();
//        SimpleModule module = new SimpleModule();
//        module.addSerializer(new CustomSerialiser(CategoryType.class));
//        module.addDeserializer(CategoryType.class, new CustomDeserializer(CategoryType.class));
//        objectMapper.registerModule(module);
//        return module;
//    }
}