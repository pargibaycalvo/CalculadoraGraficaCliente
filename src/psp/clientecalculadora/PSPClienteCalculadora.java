package psp.clientecalculadora;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author pedro argibay
 */
public class PSPClienteCalculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraficoCalculadora gc = new GraficoCalculadora();
        gc.setVisible(true);
        byte[] retorno;
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Creando ClienteSocket");
            Socket clienteSocket = new Socket();
            System.out.println("Estableciendo la conexión");

            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            clienteSocket.connect(addr);

            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();
            String mensaje;
            do {
                System.out.println("Escriba su operación:");
                mensaje = sc.nextLine();
                System.out.println("Enviando mensaje");

                os.write(mensaje.getBytes());

                System.out.println("Mensaje enviado");

                retorno = new byte[25];
                is.read(retorno); //comprobación de la salida de los datos

                String sRetorno = new String(retorno).trim();

                System.out.println("------" + sRetorno);

            } 
            //al escribir end el programa finaliza
            while (mensaje.compareToIgnoreCase("end") != 0);
            System.out.println("Cerrando ClientSocket");

            clienteSocket.close();

            System.out.println("Terminado");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
