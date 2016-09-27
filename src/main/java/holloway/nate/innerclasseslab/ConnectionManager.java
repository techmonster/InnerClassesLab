package holloway.nate.innerclasseslab;

/**
 * Created by nathanielholloway on 9/27/16.
 * This class keeps track of the connections in this program.
 */
public class ConnectionManager {
    static int count = 0;
    private static final int maxConnections = 3;
    String Ip = "";
    int port;
    boolean isClosed = false;

    public enum Protocol{HTTP,TCP,HTTPS,Closed}
    Protocol protocol;

    public boolean checkConnectionCount(){
        return count <= maxConnections;
    }

    public Connection createConnection(String ipAddress, Protocol protocol)
    {
        count++;
        if(checkConnectionCount()){
        return new ManagedConnection(ipAddress, this.protocol);
        }
        else return null;
    }

    public Connection createConnection(String ipAddress, int portNumber)
    {
        count++;
        if(checkConnectionCount()){
            return new ManagedConnection(ipAddress, portNumber);
            }
        else return null;
    }

    public class ManagedConnection implements Connection{


        public ManagedConnection(String ipAddress, int portNumber){
            this.setIP(ipAddress);
            this.setPort(portNumber);
        }

        public ManagedConnection(String ipAddress, Protocol protocol){
            this.setIP(ipAddress);
            this.setProtocol(protocol);
        }

        public String connect(){
            if(isClosed){
                return "Closed for good";
            }
            return "Succeeded.";
        }
        public String getIP(){
            return Ip;
        }
        public void setIP(String Ip){
            ConnectionManager.this.Ip = Ip;
        }
        public String getProtocol(){
            return protocol.toString();
        }
        public void setProtocol(Protocol protocol){
            ConnectionManager.this.protocol = protocol;
        }
        public int getPort(){
            return port;
        }
        public void setPort(int port){
            ConnectionManager.this.port = port;
        }

        public void close(){
            this.setIP("Closed");
            this.setProtocol(Protocol.Closed);
            this.setPort(-1);
            --ConnectionManager.count;
            isClosed = true;
        }

    }
}
