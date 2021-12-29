import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ftpserver {

    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(9999);
        Socket so = s.accept();
        System.out.println("Socket accepted..");
        FileInputStream f = new FileInputStream("D:\\Vishnu\\vish.txt");
        System.out.println("File found..");
        byte[] b = new byte[2001];
        f.read(b, 0, b.length);
        OutputStream o = so.getOutputStream();
        o.write(b, 0, b.length);
        System.out.println("File sent..");
        s.close();
        f.close();

    }

}
