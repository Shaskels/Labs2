package org.example;
import Factory.Config;
import Input.Program;
import Commands.Handler;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    public static final Logger logger = Logger.getLogger(
            Main.class.getName());
    public static void main(String[] args) {
        try {
            //System.out.println(System.getProperty("java.util.logging.config.file"));
            LogManager.getLogManager().readConfiguration();
            logger.info("Beginning of program work");
            Config config = new Config("Config.txt");
            logger.info("The configuration file has been read");
            Program cp = new Program();
            cp.Parse(args);
            logger.info("The user's program has been received");
            Handler h = new Handler();
            h.Processing(cp, config);
            logger.info("End of the program");
        }
        catch(IOException error){
            System.out.println(error);
        }
    }
}