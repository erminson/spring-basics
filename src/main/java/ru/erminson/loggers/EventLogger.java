package ru.erminson.loggers;

import ru.erminson.beans.Event;

public interface EventLogger {
    void logEvent(Event msg);
}
