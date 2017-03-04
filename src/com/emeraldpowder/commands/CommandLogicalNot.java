package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.IMachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandLogicalNot extends Command
{
    @Override
    public void execute(IMachineState machineState)
    {
        boolean a = (machineState.popStack() != 0);

        a = !a;

        machineState.pushStack(a ? 1 : 0);
    }
}
