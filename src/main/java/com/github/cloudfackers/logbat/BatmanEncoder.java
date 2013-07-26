package com.github.cloudfackers.logbat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;

public class BatmanEncoder<E> extends LayoutWrappingEncoder<ILoggingEvent>
{
    public void doEncode(ILoggingEvent event) throws IOException
    {
        String txt = layout.doLayout(event);
        outputStream.write(txt.getBytes());// no charset // convertToBytes(txt));
        // if (immediateFlush) outputStream.flush();

        batman(event);
    }

    protected void batman(ILoggingEvent event) throws IOException
    {
        if (event.getThrowableProxy() != null && Level.ERROR == event.getLevel())
        {
            InputStream bat =
                Thread.currentThread().getContextClassLoader().getResourceAsStream("bang.ansi");
            copyStream(bat, outputStream);
        }
    }

    public static void copyStream(InputStream input, OutputStream output) throws IOException
    {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1)
        {
            output.write(buffer, 0, bytesRead);
        }
    }
}