package ru.erminson.loggers;

import org.apache.commons.io.FileUtils;
import ru.erminson.beans.Event;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileEventLogger implements EventLogger {
    private String filename;

    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void init() throws IOException {
        this.file = new File(filename);

        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file: " + filename);
        } else if (!file.exists()) {
            this.file.createNewFile();
        }
    }

    @Override
    public void logEvent(Event msg) {
        try {
            FileUtils.writeStringToFile(file, msg.toString(), StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
