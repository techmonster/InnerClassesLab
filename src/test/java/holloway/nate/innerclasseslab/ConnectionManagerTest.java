package holloway.nate.innerclasseslab;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nathanielholloway on 9/27/16.
 * This class tests the ConnectionManager class.
 */
public class ConnectionManagerTest {

    @Test
    public void createConnectionTestUsingProtocol(){
        ConnectionManager thisConnectionManager = new ConnectionManager();
        Connection connection = thisConnectionManager.createConnection("123.345.567", ConnectionManager.Protocol.HTTPS);
        Assert.assertNotNull(connection);
    }

    @Test
    public void createConnectionTestUsingPortNumber(){
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.createConnection("345.567.789", 80);
        Assert.assertNotNull(connection);
    }

    @Test
    public void checkConnectionMaxTest(){
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.createConnection("123.345.567", ConnectionManager.Protocol.HTTP);
        Connection connection2 = connectionManager.createConnection("345.567.789", 80);
        Connection connection3 = connectionManager.createConnection("345.567.789", 443);
        Assert.assertNotNull(connection3);



    }
}
