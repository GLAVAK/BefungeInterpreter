package com.emeraldpowder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by glavak on Feb 17, 17.
 */
public class Machine
{
    public final MachineState state;
    private CommandManager manager;
    private ArrayList<String> program;

    public Machine()
            throws IOException
    {
        this.state = new MachineState();
        this.manager = new CommandManager();
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
     * Reads contents of file with given filename, and loads it as program for execution
     *
     * @param filename
     * @throws IOException
     */
    public void loadProgram(String filename)
            throws IOException
    {
        program = new ArrayList<>();

        BufferedReader programReader = new BufferedReader(new FileReader(filename));

        String line = programReader.readLine();
        while (line != null)
        {
            program.add(line);

            line = programReader.readLine();
        }
    }

    /**
     * Executes command, on which machine currently is, and moves to next position
     *
     * @throws ConfigError If error loading command from config
     */
    public void step()
            throws ConfigError, ProgramError
    {
        char symbol = getProgramSymbol(state.getCurrentPosition());

        if (!state.isInStringMode || symbol == '"')
        {
            Command command = manager.getCommandForSymbol(symbol);
            command.execute(state);
        }
        else
        {
            state.getStack().push((int) symbol);
        }

        moveOneStep();
    }

    /**
     * Moves machine one step in current facing direction
     *
     * @throws ProgramError If machine moved out of program
     */
    public void moveOneStep()
            throws ProgramError
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
            throw new ProgramError(String.format(
                    "Machine moved out of program, position (%d, %d)", position.x, position.y));
        }
    }
}
