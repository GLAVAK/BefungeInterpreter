package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.Machine;
import com.emeraldpowder.MachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandStackOperations extends Command
{
    @Override
    public void execute(Machine machine)
    {
        switch (character)
        {
            case ':':
                int value = machine.state.popStack();
                machine.state.pushStack(value);
                machine.state.pushStack(value);
                break;
            case '\\':
                int value1 = machine.state.popStack();
                int value2 = machine.state.popStack();
                machine.state.pushStack(value1);
                machine.state.pushStack(value2);
                break;
            case '$':
                machine.state.popStack();
                break;
        }
    }
}
