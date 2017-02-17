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

    public Position getCurrentPosition()
    {
        return currentPosition;
    }

    public void setCurrentPosition(int x, int y)
    {
        this.currentPosition.x = x;
        this.currentPosition.y = y;
    }

    public Deque<Integer> getStack()
    {
        return stack;
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
