package psp.clientecalculadora;

import java.io.IOException;

/**
 *
 * @author pedro argibay
 */
public class PSPClienteCalculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        GraficoCalculadora gc = new GraficoCalculadora();
        gc.conectaServer();
        gc.setVisible(true);
    }

}
