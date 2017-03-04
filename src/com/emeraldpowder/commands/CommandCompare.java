package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.IMachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandCompare extends Command
{
    @Override
    public void execute(IMachineState machineState)
    {
        int a = machineState.popStack();
        int b = machineState.popStack();

        boolean result = (b > a);

        machineState.pushStack(result ? 1 : 0);
    }
}
