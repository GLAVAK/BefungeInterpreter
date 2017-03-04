package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.IMachineState;
import com.emeraldpowder.Position;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandGet extends Command
{
    @Override
    public void execute(IMachineState machineState)
    {
        int y = machineState.popStack();
        int x = machineState.popStack();

        char symbol = machineState.getProgramSymbol(new Position(x, y));
        machineState.pushStack(symbol);
    }
}
