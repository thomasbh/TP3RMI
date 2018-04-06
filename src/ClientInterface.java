import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface ClientInterface extends Remote {

    void addProductoToCatalogo(Producto p) throws RemoteException;

    void update(String reason, Producto p) throws RemoteException;
}
