package com.emeraldpowder.commands;

import com.emeraldpowder.Command;
import com.emeraldpowder.MachineState;
import com.emeraldpowder.Main;
import com.emeraldpowder.MovingDirection;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandChangeDirection extends Command
{
    @Override
    public void execute(MachineState state)
    {
        switch (character)
        {
            case '^': state.movingDirection = MovingDirection.Up; break;
            case '>': state.movingDirection = MovingDirection.Right; break;
            case 'v': state.movingDirection = MovingDirection.Down; break;
            case '<': state.movingDirection = MovingDirection.Left; break;
            case '?':state.movingDirection = getRandomDirection(); break;
        }
    }

    private MovingDirection getRandomDirection()
    {
        switch (Main.random.nextInt(4))
        {
            case 0: return MovingDirection.Up;
            case 1: return MovingDirection.Right;
            case 2: return MovingDirection.Down;
            default: return MovingDirection.Left;
        }
    }
}
