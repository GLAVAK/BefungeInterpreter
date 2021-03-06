package com.emeraldpowder;

import java.io.IOException;
import java.util.List;

/**
 * Created by glavak on 28.02.17.
 */
public interface IProgramLoader
{
    /**
     * Loads rectangular program
     *
     * @return List, representing lines in loaded program. Length of all lines are equal
     * @throws ConfigException if reading error
     */
    List<char[]> loadProgram() throws ConfigException;
}
