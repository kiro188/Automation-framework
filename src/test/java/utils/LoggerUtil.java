package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for parameterized logging throughout the test framework.
 * Uses Log4j2 for logging with parameterized messages.
 */
public class LoggerUtil {
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);
    
    private LoggerUtil() {
        // Private constructor to prevent instantiation
    }
    
    /**
     * Logs a debug message with parameters.
     * @param message The message with {} placeholders for parameters
     * @param params The parameters to insert into the message
     */
    public static void debug(String message, Object... params) {
        logger.debug(message, params);
    }
    
    /**
     * Logs an info message with parameters.
     * @param message The message with {} placeholders for parameters
     * @param params The parameters to insert into the message
     */
    public static void info(String message, Object... params) {
        logger.info(message, params);
    }
    
    /**
     * Logs a warning message with parameters.
     * @param message The message with {} placeholders for parameters
     * @param params The parameters to insert into the message
     */
    public static void warn(String message, Object... params) {
        logger.warn(message, params);
    }
    
    /**
     * Logs an error message with parameters and throwable.
     * @param message The message with {} placeholders for parameters
     * @param throwable The throwable to log
     * @param params The parameters to insert into the message
     */
    public static void error(String message, Throwable throwable, Object... params) {
        logger.error(message, params, throwable);
    }
    
    /**
     * Creates a formatted error message for test assertions.
     * @param message The base error message with {} placeholders
     * @param params The parameters to insert into the message
     * @return Formatted error message
     */
    public static String formatErrorMessage(String message, Object... params) {
        return String.format(message.replace("{}", "%s"), params);
    }
}
