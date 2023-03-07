import java.net.*;
import java.io.*;
public class HttpClient{
public static void main(String[] argv)throws Exception{
try {
String hostname = "example.com";
String requestHeaders = "Host: example.com\r\n";
int port = 80;
Socket socket = new Socket(hostname, port);
PrintWriter out =
new PrintWriter(socket.getOutputStream(), true);
String data = "GET / HTTP/1.0\r\n";
data += requestHeaders+"\r\n";
System.out.println("------Request sent:-----\n");
System.out.println(data);
out.println(data);
out.flush();
System.out.println("\n------Response received:-----\n");
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
String inputLine;
StringBuffer content = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
content.append(inputLine);
}
System.out.println(content);
}
catch (Exception e) {
System.out.println(e);
}
}
}
