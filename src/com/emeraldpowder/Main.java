package com.emeraldpowder;

public class Main
{
    private static final String filename = "programs/factorial.txt";

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
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
