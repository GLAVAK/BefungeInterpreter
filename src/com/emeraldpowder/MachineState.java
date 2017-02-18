package com.emeraldpowder;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by glavak on Feb 17, 17.
 */
public class MachineState
{
    public MovingDirection movingDirection;
    public boolean isInStringMode;
    public boolean bridgeNextStep;
    private Position currentPosition;
    private Deque<Integer> stack;
    private boolean isStopped;

    public MachineState()
    {
        currentPosition = new Position(0, 0);
        movingDirection = MovingDirection.Right;
        isInStringMode = false;
        stack = new ArrayDeque<>();
    }

    public int popStack()
    {
        if(stack.isEmpty())
            return 0;
        else
            return stack.pop();
    }

    public char popStackChar()
    {
        if(stack.isEmpty())
            return 0;
        else
            return (char) stack.pop().intValue();
    }

    public void pushStack(int value)
    {
        stack.push(value);
    }

    public void pushStack(char value)
    {
        stack.push((int) value);
    }

    public Position getCurrentPosition()
    {
        return currentPosition;
    }

    public void setCurrentPosition(int x, int y)
    {
        this.currentPosition.x = x;
        this.currentPosition.y = y;
    }

    public boolean isStopped()
    {
        return isStopped;
    }

    public void Stop()
    {
        isStopped = true;
    }
}
