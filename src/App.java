import Controllers.BancoControlador;
import vistas.BancoVista;

public class App {
    public static void main(String[] args) throws Exception {
        var vista = new BancoVista();
        new BancoControlador(vista);
        vista.setVisible(true);
    }
}
