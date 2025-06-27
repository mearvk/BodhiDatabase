package bodhi.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class BodhiClient extends Thread
{
    public static final String HOST = "mearvk.us";

    public static final Integer PORT = 39001;

    public Socket socket;

    public OutputListener outputListener;

    public InputListener inputListener;

    public BodhiClient()
    {
        try
        {
            this.outputListener = new OutputListener(this);

            this.inputListener = new InputListener(this);

            this.socket = new Socket(BodhiClient.HOST, BodhiClient.PORT);
        }
        catch (Exception e)
        {
            return;
        }
    }

    @Override
    public void run()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Connected to Remote Bodhi Server: [ "+BodhiClient.HOST+":"+BodhiClient.PORT+" ]");

        StringBuffer inputBuffer = new StringBuffer();

        while(!inputBuffer.toString().equalsIgnoreCase("exit"))
        {
            inputBuffer = new StringBuffer(scanner.next().strip());

            this.outputListener.copyBuffer(inputBuffer);
        }
    }


    public static class OutputListener extends Thread
    {
        public BodhiClient client;

        public ArrayList<String> buffer = new ArrayList<>(100);

        public OutputListener(BodhiClient client)
        {
            this.client = client;
        }

        @Override
        public void run()
        {
            while(true)
            {
                String line = this.buffer.remove(0);

                if(line==null) return;

                try
                {
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(this.client.socket.getOutputStream()));

                    writer.write(line);

                    writer.flush();
                }
                catch (IOException e)
                {
                    return;
                }
            }
        }

        public void copyBuffer(StringBuffer buffer)
        {
            this.buffer.add(buffer.toString().strip());
        }
    }

    public static class InputListener extends Thread
    {
        public BodhiClient client;

        public InputListener(BodhiClient client)
        {
            this.client = client;
        }

        @Override
        public void run()
        {

        }

        public boolean hasInput()
        {
            return true;
        }
    }
}