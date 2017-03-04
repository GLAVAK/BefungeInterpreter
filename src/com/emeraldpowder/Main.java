package com.emeraldpowder;

import java.util.Random;

public class Main
{
    public static final Random random = new Random();
    public static final String filename = "programs/factorial.txt";

    public static void main(String[] args)
    {
        try
        {
            ConfigCommandRepository repository = new ConfigCommandRepository(new ReflectionCachedClassResolver());
            repository.loadTable(new FileTableLoader("com/emeraldpowder/commands.txt"));

            Machine machine = new Machine(repository);
            machine.loadProgram(new FileProgramLoader(filename));

            while (!machine.state.isStopped())
            {
                machine.step();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
