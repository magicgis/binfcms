package me.binf.admin.utils;

import org.slf4j.LoggerFactory;

public class Logger {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Logger.class);

    public static void debug(String msg) {
        LOGGER.debug(getMessage(msg));
    }

    public static void debug(String msg, Throwable thr) {
        LOGGER.debug(getMessage(msg), thr);
    }

    public static void info(String msg) {
        LOGGER.info(getMessage(msg));
    }

    public static void info(String msg, Throwable thr) {
        LOGGER.info(getMessage(msg), thr);
    }

    public static void warn(String msg) {
        LOGGER.warn(getMessage(msg));
    }

    public static void warn(String msg, Throwable thr) {
        LOGGER.warn(getMessage(msg), thr);
    }

    public static void error(String msg) {
        LOGGER.error(getMessage(msg));
    }

    public static void error(String msg, Throwable thr) {
        LOGGER.error(getMessage(msg), thr);
    }

    public static boolean isDebugEnabled() {
        return LOGGER.isDebugEnabled();
    }

    public static boolean isInfoEnabled() {
        return LOGGER.isInfoEnabled();
    }
    private static String getMessage(String msg){
        return msg==null?"":msg;

    }

}