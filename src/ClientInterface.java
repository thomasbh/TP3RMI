import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {

    void update(String reason, Producto p) throws RemoteException;
}
