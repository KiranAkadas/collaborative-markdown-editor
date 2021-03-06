package org.dhbw.mosbach.ai.cmd.services.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.dhbw.mosbach.ai.cmd.util.CmdConfig;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author 6694964
 * @version 1.1
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private static final long serialVersionUID = -7292425596342149264L;

    /**
     * Method that can be called to ask implementation to serialize
     * values of type this serializer handles.
     *
     * @param date        Value to serialize; can <b>not</b> be null.
     * @param gen         Generator used to output resulting Json content
     * @param serializers Provider that can be used to get serializers for
     */
    @Override
    public void serialize(LocalDateTime date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(date.format(CmdConfig.API_DATE_FORMATTER));
    }
}
