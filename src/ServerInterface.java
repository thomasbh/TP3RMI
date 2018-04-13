import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {

    // =================
    // USER REGISTRATION
    // =================

    boolean registrarUsuario(Usuario user) throws RemoteException;

    // ======
    // GETTER
    // ======

    Producto getThisProduct(String name) throws RemoteException;

    // ===================
    // VENDER + MIS VENTAS
    // ===================

    boolean ventaPermitida(Producto producto) throws RemoteException;

    // =====================
    // COMPRAS + MIS COMPRAS
    // =====================

    boolean ofertaAceptada(Oferta oferta) throws RemoteException;

}
