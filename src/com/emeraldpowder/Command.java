package com.emeraldpowder;

/**
 * Created by glavak on Feb 17, 17.
 */
public abstract class Command
{
    public char character;

    public abstract void execute(MachineState state);
}
