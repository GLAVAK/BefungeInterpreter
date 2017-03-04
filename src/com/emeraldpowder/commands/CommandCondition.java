package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.IMachineState;
import com.emeraldpowder.MovingDirection;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandCondition extends Command
{
    @Override
    public void execute(IMachineState machineState)
    {
        boolean value = (machineState.popStack() != 0);

        switch (character)
        {
            case '|':
                if (value)
                {
                    machineState.setMovingDirection(MovingDirection.Up);
                }
                else
                {
                    machineState.setMovingDirection(MovingDirection.Down);
                }
                break;
            case '_':
                if (value)
                {
                    machineState.setMovingDirection(MovingDirection.Left);
                }
                else
                {
                    machineState.setMovingDirection(MovingDirection.Right);
                }
                break;
        }
    }
}
