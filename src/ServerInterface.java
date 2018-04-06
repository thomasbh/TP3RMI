import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface ServerInterface extends Remote {

    // ================
    // CLIENT STUB REG°
    // ================

    void register(ClientInterface cltint) throws RemoteException;

    // =================
    // USER REGISTRATION
    // =================

    boolean registrarUsuario(Usuario user) throws RemoteException;

    // =======
    // GETTERS
    // =======

    Producto getThisProduct(String name) throws RemoteException;

    Usuario getThisUser(String nickname) throws RemoteException;

    // ===================
    // VENDER + MIS VENTAS
    // ===================

    boolean ventaPermitida(Producto producto) throws RemoteException;

    // =====================
    // COMPRAS + MIS COMPRAS
    // =====================

    boolean ofertaAceptada(Oferta oferta) throws RemoteException;

    void sendThisNewProduct(Producto p) throws RemoteException;

    ArrayList<Producto> obtieneCatalogoActivo() throws RemoteException;

    ArrayList<Producto> obtieneProductosExpirados() throws RemoteException;

    boolean sigueGanando(Usuario u, String prodAComprobar) throws RemoteException;

    List<Producto> getProductosGanados(Usuario user) throws RemoteException;

    List<Producto> getProductosPerdidos(Usuario user) throws RemoteException;


}
