package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.Machine;
import com.emeraldpowder.MachineState;
import com.emeraldpowder.MovingDirection;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandCondition extends Command
{
    @Override
    public void execute(Machine machine)
    {
        boolean value = (machine.state.popStack() != 0);

        switch (character)
        {
            case '|':
                if (value)
                {
                    machine.state.movingDirection = MovingDirection.Up;
                }
                else
                {
                    machine.state.movingDirection = MovingDirection.Down;
                }
                break;
            case '_':
                if (value)
                {
                    machine.state.movingDirection = MovingDirection.Left;
                }
                else
                {
                    machine.state.movingDirection = MovingDirection.Right;
                }
                break;
        }
    }
}
