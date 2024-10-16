package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class FileReader {

    public Profile getDataFromFile(File file) {

        Map<String, String> dataMap = new HashMap<>();
        Path path = Paths.get(file.getPath());
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(": ");
                dataMap.put(keyValue[0].trim(), keyValue[1].trim());
            }

        } catch (IOException e) {
            Logger.getLogger("IOException : "+ Arrays.toString(e.getStackTrace()));
        }

        return new Profile(dataMap.get("Name"),Integer.parseInt(dataMap.get("Age")),dataMap.get("Email"),Long.parseLong(dataMap.get("Phone")));
    }
}

