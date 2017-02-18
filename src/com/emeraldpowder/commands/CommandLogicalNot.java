package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.Machine;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandLogicalNot extends Command
{
    @Override
    public void execute(Machine machine)
    {
        boolean a = (machine.state.popStack() != 0);

        a = !a;

        machine.state.pushStack(a ? 1 : 0);
    }
}
