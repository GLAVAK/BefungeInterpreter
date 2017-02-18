package com.emeraldpowder;

/**
 * Created by glavak on Feb 17, 17.
 */
public class ProgramException extends Exception
{
    public ProgramException(String message)
    {
        super(message);
    }

    public ProgramException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
