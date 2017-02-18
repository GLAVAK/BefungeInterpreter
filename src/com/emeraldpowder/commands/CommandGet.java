package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.Machine;
import com.emeraldpowder.MachineState;
import com.emeraldpowder.Position;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandGet extends Command
{
    @Override
    public void execute(Machine machine)
    {
        int y = machine.state.popStack();
        int x = machine.state.popStack();

        char symbol = machine.getProgramSymbol(new Position(x, y));
        machine.state.pushStack(symbol);
    }
}
