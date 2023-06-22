package com.ghunteranderson.examples;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@ApplicationPath("/")
@ApplicationScoped
public class JaxrsApplication extends Application {}
