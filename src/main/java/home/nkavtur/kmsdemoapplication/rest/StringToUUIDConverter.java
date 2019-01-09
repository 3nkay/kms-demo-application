package home.nkavtur.kmsdemoapplication.rest;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringToUUIDConverter implements Converter<String, UUID> {

    @Override
    public UUID convert(String uuid) {
        return UUID.fromString(uuid);
    }
}
