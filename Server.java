import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.net.InetSocketAddress;
import java.io.IOException;

class Server{
    public static void main(String[]args)throws IOException{
        
        InetSocketAddress addr=new InetSocketAddress(8080);
        HttpServer server=HttpServer.create(addr,0);
        server.createContext("/", new HttpHandler(){
            @Override
            public void handle(HttpExchange exchange)throws IOException{
                String response="Hello World From Backend";
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.getResponseBody().close();
            }
        });
        server.start();
}
}
    
