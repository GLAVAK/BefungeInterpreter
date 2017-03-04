package com.emeraldpowder;

/**
 * Created by glavak on Feb 17, 17.
 */
public interface IMachineState
{
    MovingDirection getMovingDirection();

    void setMovingDirection(MovingDirection movingDirection);

    boolean isBridgeNextStep();

    void setBridgeNextStep(boolean bridgeNextStep);

    boolean isInStringMode();

    void toggleStringMode();

    int popStack();

    char popStackChar();

    void pushStack(int value);

    void pushStack(char value);

    Position getCurrentPosition();

    boolean isStopped();

    void Stop();

    char getProgramSymbol(Position position);

    void setProgramSymbol(Position position, char symbol);

    boolean isPositionInsideBounds(Position position);
}
