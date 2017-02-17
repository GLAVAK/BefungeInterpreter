package com.emeraldpowder;

/**
 * Created by glavak on Feb 17, 17.
 */
public class ConfigError extends Exception
{
    public ConfigError(String message)
    {
        super(message);
    }

    public ConfigError(String message, Throwable cause)
    {
        super(message, cause);
    }
}
