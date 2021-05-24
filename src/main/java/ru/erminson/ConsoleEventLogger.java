package ru.erminson;

import ru.erminson.beans.Event;

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event msg) {
        System.out.println(msg);
    }
}
