package br.com.patio.projeto.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.TimeZone;

@Component
public class JacksonUtils {

    public static ObjectMapper jacksonObjectMapper;

    public JacksonUtils(@Autowired ObjectMapper jacksonObjectMapper) {
        jacksonObjectMapper.setTimeZone(TimeZone.getDefault());
        JacksonUtils.jacksonObjectMapper = jacksonObjectMapper;
    }

    public static String toJson(Object object) {
        try {
            return jacksonObjectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new JacksonException(e.getMessage(), e);
        }
    }

    public static <T> T parseJson(String json, Class<T> tClass) {
        try {
            return jacksonObjectMapper.readValue(json, tClass);
        } catch (IOException e) {
            throw new JacksonException(e.getMessage(), e);
        }
    }

    public static class JacksonException extends RuntimeException {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JacksonException() {
            super();
        }

        public JacksonException(String message) {
            super(message);
        }

        public JacksonException(String message, Throwable cause) {
            super(message, cause);
        }
    }

}
