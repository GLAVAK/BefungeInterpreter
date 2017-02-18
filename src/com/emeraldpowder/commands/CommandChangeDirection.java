package com.emeraldpowder.commands;

import com.emeraldpowder.*;

/**
 * Created by glavak on Feb 17, 17.
 */
public class CommandChangeDirection extends Command
{
    @Override
    public void execute(Machine machine)
    {
        switch (character)
        {
            case '^':
                machine.state.movingDirection = MovingDirection.Up;
                break;
            case '>':
                machine.state.movingDirection = MovingDirection.Right;
                break;
            case 'v':
                machine.state.movingDirection = MovingDirection.Down;
                break;
            case '<':
                machine.state.movingDirection = MovingDirection.Left;
                break;
            case '?':
                machine.state.movingDirection = getRandomDirection();
                break;
        }
    }

    private MovingDirection getRandomDirection()
    {
        switch (Main.random.nextInt(4))
        {
            case 0:
                return MovingDirection.Up;
            case 1:
                return MovingDirection.Right;
            case 2:
                return MovingDirection.Down;
            default:
                return MovingDirection.Left;
        }
    }
}
