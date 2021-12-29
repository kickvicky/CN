import java.io.FileOutputStream;
import java.net.Socket;
public class ftpclient{
    public static void main(String[] args) throws Exception{
       Socket s = new Socket("localhost",9999);
       FileOutputStream f = new FileOutputStream("D:\\Vishnu\\vish.txt");
       System.out.println("File created..");
       byte [] by=new byte[2001];
       String str1="hello world";
       by=str1.getBytes();
       f.write(by,0,by.length);
       System.out.println("Contents written into file..");
       s.close();
       f.close();
}

}