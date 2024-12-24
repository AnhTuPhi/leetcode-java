package vn.com.leetcode.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

/**
 * @author: tu.phianh
 * @mail: tu.phianh@ivnd.com.vn
 * @created: 24/12/2024
 */
public class JsonMapper {

    private static final ObjectMapper MAPPER;

    private JsonMapper() {
        throw new IllegalStateException("Utility class");
    }

    static {
        MAPPER = new ObjectMapper();
        MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public static <O> String write(O o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static <O> O read(String string, Class<O> clazz) {
        try {
            return MAPPER.readValue(string, clazz);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static <O> O read(String string, TypeReference<O> typeReference) {
        try {
            return MAPPER.readValue(string, typeReference);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static <O> O readOrElseThrow(String string, TypeReference<O> typeReference)
            throws JsonProcessingException {
        return MAPPER.readValue(string, typeReference);
    }

    public static <O> O read(Reader reader, Class<O> clazz) {
        try {
            return MAPPER.readValue(reader, clazz);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static <O> O convertValue(Object value, Class<O> clazz) {
        try {
            return MAPPER.convertValue(value, clazz);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static <O> byte[] writeAsBytes(O o) {
        try {
            return MAPPER.writeValueAsBytes(o);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new byte[0];
        }
    }

    public static <O> O read(byte[] bytes, TypeReference<O> typeReference) {
        try {
            return MAPPER.readValue(bytes, typeReference);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static <O> Optional<O> read(JsonNode node, Class<O> clazz) {
        try {
            return Optional.ofNullable(MAPPER.treeToValue(node, clazz));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public static <O> JsonNode readTree(O object) {
        try {
            return MAPPER.readTree(writeAsBytes(object));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ObjectNode createObjectNode() {
        return MAPPER.createObjectNode();
    }
}