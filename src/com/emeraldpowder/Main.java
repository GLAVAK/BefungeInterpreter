package com.emeraldpowder;

import org.apache.log4j.Logger;

public class Main
{
    private static final String filename = "programs/factorial.txt";
    //private static final String filename = "programs/less_more.txt";
    //private static final String filename = "programs/quine.txt";

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args)
    {
        try
        {
            ConfigCommandRepository repository = new ConfigCommandRepository(new ReflectionCachedClassResolver());
            repository.loadTable(new FileTableLoader("com/emeraldpowder/commands.txt"));

            Machine machine = new Machine(repository, new FileProgramLoader(filename));

            System.out.println("==== program started ====");
            while (!machine.state.isStopped())
            {
                machine.step();
            }
            System.out.println();
            System.out.println("==== program exited ====");
        }
        catch (ProgramException e)
        {
            logger.error("Program Exception: " + e.getMessage());
            e.printStackTrace();
        }
        catch (ConfigException e)
        {
            logger.error("Config Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
