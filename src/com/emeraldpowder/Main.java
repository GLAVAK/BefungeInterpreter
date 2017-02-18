package com.emeraldpowder;

import java.util.Random;

public class Main
{
    public static final Random random = new Random();

    public static void main(String[] args)
    {
        try
        {
            Machine machine = new Machine();
            machine.loadProgram("programs/factorial.txt");
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
