import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.net.InetSocketAddress;
import java.io.IOException;
import com.sun.net.httpserver.Headers;

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
        server.createContext("/info", new HttpHandler(){
        @Override
        public void handle(HttpExchange exchange)throws IOException{
           String method=exchange.getRequestMethod();
           String path =exchange.getRequestURI().getPath();
           Headers header=exchange.getRequestHeaders();
           String response1="Method:"+ method+"\n"+
           "Path :"+path +"\n"+
            "Headers:\n";
           for(String key:header.keySet()){
            response1+=key+ ":" +header.get(key)+"\n";
           }
           exchange.sendResponseHeaders(200, response1.length());
           exchange.getResponseBody().write(response1.getBytes());
           exchange.getResponseBody().close();
                                        
        }});
        server.start();
}
}
    
