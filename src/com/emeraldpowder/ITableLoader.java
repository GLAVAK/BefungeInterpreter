package com.emeraldpowder;

import java.io.IOException;
import java.util.Map;

/**
 * Created by glavak on 28.02.17.
 */
public interface ITableLoader
{
    /**
     * Loads table, that resembles char->string association
     * @return
     */
    Map<Character, String> loadTable() throws IOException;
}
