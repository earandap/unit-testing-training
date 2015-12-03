package com.globant.training.domain;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;


/**
 * Created by eduardoaranda on 26/11/15.
 */

public class DateSerializerTest {


    private CustomSerializerFactory sf;
    private ObjectMapper mapper;
    private SimpleDateFormat df;

    @Before
    public void setUp() {
        sf = new CustomSerializerFactory();
        sf.addGenericMapping(Date.class, new DateSerializer());
        mapper = new ObjectMapper();
        mapper.setSerializerFactory(sf);
        df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    }

    @Test
    public void serializeTest() throws Exception {
        String date = "2015-11-26T14:49:11";
        Date dt = df.parse(date);
        assertEquals("\"" + date + "\"", mapper.writeValueAsString(dt));
    }



}
