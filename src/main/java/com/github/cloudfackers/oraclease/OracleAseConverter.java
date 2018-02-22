package com.github.cloudfackers.oraclease;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class OracleAseConverter extends ClassicConverter
{
    @Override
    public String convert(final ILoggingEvent event)
    {
        String msg = event.getFormattedMessage();
        if (event.getLoggerName().startsWith("com.abiquo.plugin.oraclease"))
        {
            msg = String.format("oracle-ase, %s? O que ase", msg);
        }
        return msg;
    }

}
