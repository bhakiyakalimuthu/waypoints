package com.spring.waypoints.lib;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spring.waypoints.model.Points;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JSONFileReader {

    public List<Points> fileReader() throws IOException {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Points>>() {}.getType();
        List<Points> list = gson.fromJson(new JSONFileReader().loadFileFromClasspath("waypoints.json"), listType);
        return list ;
    }

    private   String loadFileFromClasspath(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            // common-io
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }
}
