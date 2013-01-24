package com.lancktele.rest;

import com.lancktele.rest.utils.Parser;
import com.lancktele.rest.utils.PropertyLoader;
import com.lanctele.rest.HttpRestApiPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: azee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class CallsTest {
    @Autowired
    private Parser parser;

    @Autowired
    private PropertyLoader propertyLoader;

    private final static String CALL_ID = "289324324892374982374";
    private final static String SRC_ID = "ce853612f64d9668ccf8e04037e41514";
    private final static String DIST_ID = "5314b51de7a0590fffce57f5090ca6b6";

    /**
     *
     * Test for a Get Call handler
     * @throws Exception
     */
    @Test
    public void getCallTo() throws Exception {
        HttpRestApiPath.Call.CallIdFromSrcUidToDstUid proxy = new HttpRestApiPath.Call.CallIdFromSrcUidToDstUid(propertyLoader.getEndpoint(), CALL_ID, SRC_ID, DIST_ID);
        String response = proxy.getAsApplicationText(String.class);
        assertNotNull(response, "Can't get a response from Get Call handler");

        Call call = parser.unmarshal(response, "", Call.class);
        assertNotNull("Call is null", call);
        assertEquals("79643613021", call.getToPhoneNumber());
    }
}
