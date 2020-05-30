package com.example.konovodov_hw_511_external_storage;


import android.graphics.drawable.Drawable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import java.util.Random;

public class FileUtils {
    private static final String SEPARATOR = ";";

    public static void saveList(List<ItemData> data, File file) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));

            for (int i = 0; i < data.size(); i++) {
                String title = data.get(i).getTitle();
                String subtitleCategory = data.get(i).getSubtitleCategory();
                String subtitle = data.get(i).getSubtitle();
                writer.write(title + SEPARATOR + subtitleCategory + SEPARATOR + subtitle + SEPARATOR + "\n\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<ItemData> loadFromFile(File file, List<Drawable> images) {
        List<ItemData> result = new ArrayList<>();
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            int symbol;
            while ((symbol = reader.read()) != -1) {
                sb.append((char) symbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (sb.length() != 0) {

            String fullFileContent = sb.toString();
            String[] titles = fullFileContent.split("\n\n");
            for (String title : titles) {
                String[] values = title.split(SEPARATOR);
                if (values.length != 3) {
                    throw new RuntimeException("valules length is not 3");
                } else {
                    result.add(new ItemData(images.get(new Random().nextInt(images.size())), values[0], values[1], values[2]));
                }
            }
        }

        return result;
    }
}
