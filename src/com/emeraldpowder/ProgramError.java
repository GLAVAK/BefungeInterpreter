package com.emeraldpowder;

/**
 * Created by glavak on Feb 17, 17.
 */
public class ProgramError extends Exception
{
    public ProgramError(String message)
    {
        super(message);
    }

    public ProgramError(String message, Throwable cause)
    {
        super(message, cause);
    }
}
