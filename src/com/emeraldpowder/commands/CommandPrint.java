package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.Machine;
import com.emeraldpowder.MachineState;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandPrint extends Command
{
    @Override
    public void execute(Machine machine)
    {
        String result = "";
        switch (character)
        {
            case ',':
                result = machine.state.popStackChar() + "";
                break;
            case '.':
                result = machine.state.popStack() + " ";
                break;
        }
        System.out.print(result);
    }
}
