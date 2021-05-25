package ru.erminson;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.erminson.beans.Client;
import ru.erminson.beans.Event;
import ru.erminson.beans.EventType;
import ru.erminson.loggers.EventLogger;

import java.util.Map;

public class App {
    private final Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }

        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        Event event = (Event) ctx.getBean("event");
        app.logEvent(EventType.INFO, event, "Some event for 1");

        event = (Event) ctx.getBean("event");
        app.logEvent(EventType.ERROR, event,"Some event for 2");
        app.logEvent(null, event, "Some event for 3");

        ctx.close();
    }
}
