package fr.pitrouflette.ariamamc.utils;

import java.io.*;

public class FileUtils {
    public FileUtils() {
    }

    public static void createFile(File file) throws IOException {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

    }

    public static void saveFile(File file, String content) {
        try {
            createFile(file);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public static String readFile(File file) {
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder builder = new StringBuilder();

                String line;
                while((line = reader.readLine()) != null) {
                    builder.append(line);
                }

                reader.close();
                return builder.toString();
            } catch (IOException var4) {
                var4.printStackTrace();
            }
        }

        return "";
    }
}
