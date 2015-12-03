package com.globant.training.domain;

import org.codehaus.jackson.JsonGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.*;

/**
 * Created by eduardoaranda on 03/12/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DateSerializerMockitoTest {

    @Mock
    private JsonGenerator generator;

    private SimpleDateFormat df;

    private String expectedDate;

    private Date  requestedDate;


    @Before
    public void setUp() throws Exception {
        df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        expectedDate = "2015-11-26T14:49:11";
        requestedDate = df.parse(expectedDate);
    }

    @Test
    public void serializeTest() throws Exception {

        DateSerializer serializer = new DateSerializer();
        serializer.serialize(requestedDate,generator, null);

        //Assuring expected result for writeString method
        verify(generator, times(1)).writeString(expectedDate);

    }

    @Test(expected = IOException.class)
    public void serializeForIOExceptionTest() throws Exception {

        //Assuring expected result for writeString method
        doThrow(new IOException()).when(generator).writeString(expectedDate);

        DateSerializer serializer = new DateSerializer();
        serializer.serialize(requestedDate,generator, null);


    }


}
