package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.Machine;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandCompare extends Command
{
    @Override
    public void execute(Machine machine)
    {
        int a = machine.state.popStack();
        int b = machine.state.popStack();

        boolean result = (b > a);

        machine.state.pushStack(result ? 1 : 0);
    }
}
