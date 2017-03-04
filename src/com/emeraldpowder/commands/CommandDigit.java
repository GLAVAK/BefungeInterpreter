package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.IMachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandDigit extends Command
{
    @Override
    public void execute(IMachineState machineState)
    {
        machineState.pushStack(character - '0');
    }
}
