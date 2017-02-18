package com.emeraldpowder;

/**
 * Created by glavak on Feb 17, 17.
 */
public class ConfigException extends Exception
{
    public ConfigException(String message)
    {
        super(message);
    }

    public ConfigException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
