package com.emeraldpowder;

/**
 * Created by glavak on Feb 17, 17.
 */
public class Machine
{
    public final IMachineState state;
    private final ICommandRepository commandRepository;

    public Machine(ICommandRepository commandRepository, IProgramLoader programLoader) throws ConfigException
    {
        this.commandRepository = commandRepository;
        state = new MachineState(programLoader.loadProgram());
    }

    /**
     * Executes command, on which machine currently is, and moves to next position
     *
     * @throws ConfigException If error loading command from config
     */
    public void step()
            throws ConfigException, ProgramException
    {
        char symbol = state.getProgramSymbol(state.getCurrentPosition());

        if (!state.isInStringMode() || symbol == '"')
        {
            Command command = commandRepository.getCommandForSymbol(symbol);
            command.execute(state);
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
        if (state.isBridgeNextStep())
        {
            speed++;
            state.setBridgeNextStep(false);
        }

        switch (state.getMovingDirection())
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

        if (!state.isPositionInsideBounds(position))
        {
            throw new ProgramException(String.format(
                    "Machine moved out of program, position (%d, %d)", position.x, position.y));
        }
    }
}
