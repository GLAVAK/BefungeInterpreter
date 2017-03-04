package com.emeraldpowder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by glavak on Feb 17, 17.
 */
public class Machine
{
    public final MachineState state;
    private List<String> program;

    private final ICommandRepository commandRepository;

    public Machine(ICommandRepository commandRepository)
    {
        this.state = new MachineState();
        this.commandRepository = commandRepository;
    }

    public void loadProgram(IProgramLoader programLoader) throws IOException
    {
        program = programLoader.loadProgram();
    }

    public char getProgramSymbol(Position position)
    {
        return program.get(position.y).charAt(position.x);
    }

    public void setProgramSymbol(Position position, char symbol)
    {
        String line = program.get(position.y);
        line = line.substring(0, position.x) +
                symbol +
                line.substring(position.x + 1, line.length());
        program.set(position.y, line);
    }

    /**
     * Executes command, on which machine currently is, and moves to next position
     *
     * @throws ConfigException If error loading command from config
     */
    public void step()
            throws ConfigException, ProgramException
    {
        char symbol = getProgramSymbol(state.getCurrentPosition());

        if (!state.isInStringMode || symbol == '"')
        {
            Command command = commandRepository.getCommandForSymbol(symbol);
            command.execute(this);
        }
        else
        {
            state.pushStack(symbol);
        }

        moveOneStep();
    }

    /**
     * Moves machine one step in current facing direction
     *
     * @throws ProgramException If machine moved out of program
     */
    public void moveOneStep()
            throws ProgramException
    {
        Position position = state.getCurrentPosition();


        int speed = 1;
        if (state.bridgeNextStep)
        {
            speed++;
            state.bridgeNextStep = false;
        }

        switch (state.movingDirection)
        {
            case Up:
                position.y -= speed;
                break;
            case Right:
                position.x += speed;
                break;
            case Down:
                position.y += speed;
                break;
            case Left:
                position.x -= speed;
                break;
        }

        if (position.x < 0 ||
                position.y < 0 ||
                position.x > program.get(position.y).length() ||
                position.y > program.size())
        {
            throw new ProgramException(String.format(
                    "Machine moved out of program, position (%d, %d)", position.x, position.y));
        }
    }
}
