package edu.jhu.fcriscu1.javaslang.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import javaslang.collection.List;
import javaslang.jackson.datatype.JavaslangModule;
import lombok.extern.log4j.Log4j;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import javaslang.jackson.datatype.deserialize.JavaslangDeserializers;
import javaslang.jackson.datatype.serialize.JavaslangSerializers;

/**
 * Created by fcriscuolo on 3/23/16.
 */
@Log4j
public class JacksonTest {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaslangModule());

// = [[1]]
        try {
            String json = mapper.writer().writeValueAsString(List.of(List.of(1)));
            Object restored1 = mapper.readValue(json, List.class);
            // = List(java.util.ArrayList(1))
            Object restored2 = mapper.readValue(json, new TypeReference<List<List<?>>>() {});
            log.info(restored1);
// = List(List(1))
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }


    }
}
