package com.trade12.Archangel.lib;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Kieran on 25/08/2014.
 */
public class Log {

    private static Logger logger = LogManager.getLogger(Ref.MOD_ID);




    public static void init(){
        logger.log(Level.INFO, Ref.MOD_NAME + " Starting!");
    }



    public static void info(String message){
        logger.log(Level.INFO, message);
    }



    public static void error(String message){
        logger.log(Level.ERROR, message);
    }



    public static void warning(String message){
        logger.log(Level.WARN, message);
    }
}
