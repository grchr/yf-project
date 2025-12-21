package org.opensource.model.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {

  private static final ObjectMapper MAPPER = createMapper();

  private JsonMapper() {
    // prevent instantiation
  }

  private static ObjectMapper createMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return mapper;
  }

  public static ObjectMapper get() {
    return MAPPER;
  }



}
