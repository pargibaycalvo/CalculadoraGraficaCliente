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
        
        try{
        gc.conectaServer();
        gc.setVisible(true);
        
        }catch(IOException ex){
            System.out.println("Server ináctivo, conecte el servidor: "+ex.getMessage());
        }

    }

}
