package ru.erminson.loggers;

import ru.erminson.beans.Event;

import java.util.Collection;

public class CombineEventLogger implements EventLogger {

    private final Collection<EventLogger> loggers;

    public CombineEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event msg) {
        for (EventLogger eventLogger: loggers) {
            eventLogger.logEvent(msg);
        }
    }
}
