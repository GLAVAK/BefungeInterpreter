package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.MachineState;
import com.emeraldpowder.MovingDirection;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandCondition extends Command
{
    @Override
    public void execute(MachineState state)
    {
        boolean value = state.getStack().pop() == 1;
        switch (character)
        {
            case '|':
                if (value)
                {
                    state.movingDirection = MovingDirection.Up;
                }
                else
                {
                    state.movingDirection = MovingDirection.Down;
                }
                break;
            case 'v':
                if (value)
                {
                    state.movingDirection = MovingDirection.Left;
                }
                else
                {
                    state.movingDirection = MovingDirection.Right;
                }
                break;
        }
    }
}
