package com.clientSocket.Client;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

@Service
public class ClientService {
    PrintWriter writer;

    BufferedReader reader;
    Socket socket;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    @PostConstruct
    public void init(){


        String hostname = "localhost";
        int port = 8090;

        try {
            socket = new Socket(hostname, port);
            OutputStream output = socket.getOutputStream();
           objectOutputStream=new ObjectOutputStream(output);
           //objectInputStream=new ObjectInputStream(socket.getInputStream());

             writer = new PrintWriter(output, true);

        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }

    }
    public String getRequest(String firstArg) {
        String domainName = firstArg;
        writer.println(domainName);
        String line = null;
        try {
            int i = 0;
            InputStream input = socket.getInputStream();

            reader = new BufferedReader(new InputStreamReader(input));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

                i++;
                if (i == 1)
                    break;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return line;
    }


    public PrintWriter getWriter(){
        return writer;
    }


    public BufferedReader getReader(){
        return reader;
    }

    public ObjectOutputStream getWriterObject(){
        return objectOutputStream;
    }

    public ObjectInputStream getReaderObject(){
        try {
            objectInputStream=new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectInputStream;
    }

}
