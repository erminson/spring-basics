package ru.erminson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.erminson.beans.Client;
import ru.erminson.beans.Event;
import ru.erminson.loggers.EventLogger;

public class App {
    final private Client client;
    final private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        Event event = (Event) ctx.getBean("event");
        app.logEvent(event, "Some event for 1");

        event = (Event) ctx.getBean("event");
        app.logEvent(event,"Some event for 2");
    }
}
