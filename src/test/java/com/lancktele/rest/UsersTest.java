package com.lancktele.rest;

import com.lancktele.rest.utils.NetService;
import com.lancktele.rest.utils.Parser;
import com.lancktele.rest.utils.PropertyLoader;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.ws.rs.core.MediaType;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: azee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class UsersTest {

    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    @Autowired
    private Parser parser;

    @Autowired
    NetService netService;

    @Autowired
    private PropertyLoader propertyLoader;

    private final static String UUID = "ce853612f64d9668ccf8e04037e41514";

    @Before
    public void restoreBalance() throws Exception{
        //Get a user
        String url = String.format(propertyLoader.getEndpoint() + "/users/%s", UUID);

        //Getting response as string
        WebResource webResource = Client.create().resource(url);
        String response = webResource.accept(MediaType.TEXT_PLAIN).get(String.class);

        //Getting response as string
        assertNotNull(response, "Can't get a response from Get User handler");

        //Getting user
        User user = parser.unmarshal(response, "", User.class);

        user.setBalance("1000.000000");

        //Update a user
        netService.doPutRequest(url, "user", user, "");
    }


     /**
     *
     * Test for a getting user details handler
     * @throws Exception
     */
    @Test
    public void getUserTest() throws Exception {
        String url = String.format(propertyLoader.getEndpoint() + "/users/%s", UUID);

        //Getting response as string
        WebResource webResource = Client.create().resource(url);
        String response = webResource.accept(MediaType.TEXT_PLAIN).get(String.class);

        //Getting response as string
        assertNotNull(response, "Can't get a response from Get User handler");

        //Getting user
        User user = parser.unmarshal(response, "", User.class);
        assertNotNull("User is null", user);

        //Validating user's fields
        assertEquals("1000.000000", user.getBalance());
        assertEquals(63438328, user.getExternalId(), 0);
        assertEquals("fotostrana", user.getExternalService());
        assertEquals( "m", user.getGender());
        assertEquals("Anatoly Shuvalov", user.getNameFull());
        assertEquals("79118360863", user.getPhoneNumber());
        assertEquals("http://www.blogcdn.com/www.engadget.com/media/2008/04/johnny-videophone.jpg", user.getPhoto());
        assertEquals("79052256685", user.getPhoneNumberDraft());
        assertTrue(user.isAcceptCalls());
    }


    /**
     *
     * Test for a getting wrong user details - 404 answer expected
     * @throws Exception
     */
    @Test
    public void getWrongUserTest() throws Exception {
        WebResource webResource = Client.create().resource(propertyLoader.getEndpoint() + "/users/WrOngUUid");
        ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class);
        assertEquals(404, response.getStatus());
    }


    /**
     *
     * Test for a Get Balance handler
     * @throws Exception
     */
    @Test
    public void getBalanceTest() throws Exception {
        //Create a URI string
        String url = String.format(propertyLoader.getEndpoint() + "/users/%s/balance", UUID);

        //Getting response as string
        WebResource webResource = Client.create().resource(url);
        String response = webResource.accept(MediaType.TEXT_PLAIN).get(String.class);
        assertNotNull(response, "Can't get a response from Get User Balance handler");

        //Getting balace
        Balance balance = parser.unmarshal(response, "", Balance.class);
        assertNotNull("Balance is null", balance);

        //Validating user's fields
        assertEquals("1000.000000", balance.getBalance());
    }

    /**
     *
     * Test for a Post Balance handler
     * @throws Exception
     */
    @Test
    public void postBalanceTest() throws Exception {
        //Create a URI string for post
        String url = String.format(propertyLoader.getEndpoint() + "/users/%s/deposit", UUID);

        //Creapte an ammount object
        Amount amount = new Amount();
        amount.setAmount("22.000000");

        //Get a response
        HttpResponse response = netService.doPostRequest(url, "deposit", amount, "");
        assertTrue("Couldn't change a user's balance", response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 204);

        String getUrl = String.format(propertyLoader.getEndpoint() + "/users/%s/balance", UUID);
        WebResource getWebResource = Client.create().resource(getUrl);
        String getResponse = getWebResource.accept(MediaType.TEXT_PLAIN).get(String.class);
        Balance newBalance = parser.unmarshal(getResponse, "", Balance.class);

        assertNotNull("Balance is null", newBalance);
        assertEquals("Ballance is not incremented on expected amount", "1022.000000", newBalance.getBalance());
    }

    /**
     * Test for a get Contacts handler
     * @throws Exception
     */
    @Test
    public void getContactsTest() throws Exception {
        //Create a URI string
        String url = String.format(propertyLoader.getEndpoint() + "/users/%s/contacts/application/uid", UUID);

        //Get data as string to parse list without root element
        WebResource webResource = Client.create().resource(url);
        String response = webResource.accept(MediaType.TEXT_PLAIN).get(String.class);

        //Getting contacts
        Contacts contacts = parser.unmarshal(response, "contacts", Contacts.class);
        assertNotNull("Contacts list is null", contacts);
        assertTrue("Contacts list is empty", contacts.getContacts().size() > 0);

        //Validate contacts list
        for (String contact : contacts.getContacts()){
            assertNotNull("One of the contacts is empty", contact);
            assertFalse("One of the contacts is empty", "".equals(contact));
        }
    }

    /**
     * Test for a get Contacts Extended handler
     * @throws Exception
     */
    @PerfTest(invocations = 2, threads = 2)
    @Required(max = 2500, average = 1900)
    @Test
    public void getExtendedContactsTest() throws Exception {
        //Create a URI string
        String url = String.format(propertyLoader.getEndpoint() + "/users/%s/contacts/uid/extended", UUID);

        //Get data as string to parse list without root element
        WebResource webResource = Client.create().resource(url);
        String response = webResource.accept(MediaType.TEXT_PLAIN).get(String.class);
        assertNotNull(response, "Can't get a response from Get User Extended Contacts handler");

        //Getting contacts
        ExtendedContacts extendedContacts = parser.unmarshal(response, "", ExtendedContacts.class);
        assertNotNull("Extended Contacts list is null", extendedContacts);
        assertTrue("Extended Contacts list is empty", extendedContacts.getContactsUids().size() > 0);

        //Validate contacts list
        for (String contact : extendedContacts.getContactsUids()){
            assertNotNull("One of the contacts UID is empty", contact);
            assertFalse("One of the contacts UID is empty", "".equals(contact));
        }

        //Validating extenal fields
        assertEquals(63438328, extendedContacts.getExternalId(), 0);
        assertEquals("fotostrana", extendedContacts.getExternalService());
        assertEquals("m", extendedContacts.getGender());
        assertTrue(extendedContacts.isAcceptCalls());
    }
}
