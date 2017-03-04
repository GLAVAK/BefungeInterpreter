package com.emeraldpowder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by glavak on 28.02.17.
 */
public class FileTableLoader implements ITableLoader
{
    private final String filepath;

    public FileTableLoader(String filepath)
    {
        this.filepath = filepath;
    }

    @Override
    public Map<Character, String> loadTable() throws IOException
    {
        Map<Character, String> result = new HashMap<>();

        InputStream stream = ClassLoader.getSystemResourceAsStream(filepath);
        BufferedReader commandsReader = new BufferedReader(new InputStreamReader(stream));

        String line = commandsReader.readLine();
        while (line != null)
        {
            String[] splited = line.split("=");
            result.put(splited[0].charAt(0), splited[1]);

            line = commandsReader.readLine();
        }

        return result;
    }
}
