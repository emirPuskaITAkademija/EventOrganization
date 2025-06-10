package com.itakademija.event.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

//http://localhost:8080/event-1.0-SNAPSHOT   +   REST /api
@ApplicationPath("/api")
public class EventRestConfig extends Application {
}
