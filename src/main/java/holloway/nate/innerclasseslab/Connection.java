package holloway.nate.innerclasseslab;

/**
 * Created by nathanielholloway on 9/27/16.
 * This is the interface for connections to be made.
 */
public interface Connection {


    String connect();
    String getIP();
    void setIP(String Ip);
    String getProtocol();
    void setProtocol(ConnectionManager.Protocol protocol);
    int getPort();
    void setPort(int port);
    void close();
}
