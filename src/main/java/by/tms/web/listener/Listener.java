package by.tms.web.listener;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;
import java.util.logging.LogManager;

@WebListener

public class Listener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException exp) {
            exp.printStackTrace();
        }
        try {
            LogManager.getLogManager().readConfiguration();
            System.out.println(System.getProperty("java.util.logging.config.file"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

