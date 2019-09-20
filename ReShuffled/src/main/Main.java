package main;
//other imports

import config.ConfigService;
import gui.Gui;
import logging.LogBackgroundHandler;
import logging.LogOutputStreamHandler;
import logging.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

//logger imports
//exception imports


public class Main
{
    public static String LOGPATH="/home/alois/Schreibtisch/Drive/ReShuffled/ReShuffled/log/reshuffled.log";   ///var/lib/reshuffled/reshuffled.log
    public static String VERSION = "0.1";
    private static final Logger LOGP = Logger.getParentLogger();
    private static final Logger LOG = Logger.getLogger(Main.class.getName());


    static {
        System.setProperty("logging.LogOutputStreamHandler.showRecordHashcode", "false");
        // System.setProperty("logging.LogRecordDataFormattedText.Terminal", "LINUX");

        System.setProperty("logging.Logger.Level", "ALL"); 
        // System.setProperty("logging.Logger.Level", "INFO");
        // System.setProperty("logging.Logger.Level", "WARNING"); 
    }
    
    public static void main (String[] args) throws FileNotFoundException
    {

        LOGP.addHandler(new LogBackgroundHandler(new LogOutputStreamHandler(System.out)));
        LOGP.addHandler(new LogBackgroundHandler(new LogOutputStreamHandler(new FileOutputStream(LOGPATH))));

        ConfigService.deserializeService();

        //ConfigService.serializeService(config);
        VERSION=ConfigService.config.getVersion();
        LOGPATH=ConfigService.config.getLogPath();
        LOG.info("start of programm with V%s", VERSION);
        Gui.main();

    }
    
}
