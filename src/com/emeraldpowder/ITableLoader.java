package com.emeraldpowder;

import java.util.Map;

/**
 * Created by glavak on 28.02.17.
 */
public interface ITableLoader
{
    /**
     * Loads table, that resembles char->string association
     *
     * @return table as Map<Character, String>
     * @throws ConfigException if incorrect config format or reading error
     */
    Map<Character, String> loadTable() throws ConfigException;
}
