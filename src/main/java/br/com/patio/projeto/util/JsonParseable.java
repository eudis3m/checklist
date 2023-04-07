package br.com.patio.projeto.util;

public interface JsonParseable {

    default String toJson() {
        return JacksonUtils.toJson(this);
    }

}
