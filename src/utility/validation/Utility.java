package utility.validation;

import constants.DatabaseConstants;
import messaging.MessageQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

public class Utility
{
    public static class JSONReader
    {
        public StringBuffer buffer = new StringBuffer();

        public JSONReader(BufferedReader reader) throws Exception
        {
            String line = "";

            while((line=reader.readLine())!=null)
            {
                buffer.append(line);
            }

            //

            MessageQueue mqueue;

            mqueue = new MessageQueue();

            mqueue.enqueue(buffer);
        }
    }
}
