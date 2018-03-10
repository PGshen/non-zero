package space.zero.common.jsonLib.module;

import com.fasterxml.jackson.databind.module.SimpleModule;
import space.zero.common.jsonLib.serialize.DateDeserializer;
import space.zero.common.jsonLib.serialize.DateSerializer;

import java.util.Date;

public class DateModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public DateModule() {
        super();
        addSerializer(Date.class, new DateSerializer());
        addDeserializer(Date.class, new DateDeserializer());
    }
}