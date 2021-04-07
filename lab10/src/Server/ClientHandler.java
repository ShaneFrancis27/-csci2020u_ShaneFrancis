package Server;

import Client.Main;
import javafx.scene.control.TextArea;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

public class ClientHandler extends Thread
{
    protected Socket socket       = null;
    protected PrintWriter out     = null;
    protected BufferedReader in   = null;

    protected String strPasswords = "oursecretchat";

    protected boolean loggedIn   = false;
    protected String UserID    = null;
    protected String Password  = null;
    protected Vector messages     = null;

    public ClientHandler(Socket socket, Vector messages) {
        super();
        this.socket = socket;
        this.messages = messages;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.err.println("IOEXception while opening a read/write connection");
        }
    }

    public void run() {

        boolean endOfSession = false;
        while(!endOfSession) {
            endOfSession = processCommand();
        }
        close();
    }
    public void close()
    {
        try {
            socket.close();
            out.close();
            in.close();
            System.exit(0);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    protected boolean processCommand()
    {
        try
        {
            String message;

            message = in.readLine();
            if(message.equals("Exit"))
            {
                return true;
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return false;
    }

}