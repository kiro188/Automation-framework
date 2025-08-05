package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for logging messages throughout the test framework.
 * Wraps Log4j2 functionality for consistent logging.
 */
public class LoggerUtil {
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    /**
     * Logs an informational message.
     * @param message The message to log (supports parameter placeholders {})
     * @param args Optional arguments to include in the message
     */
    public static void info(String message, Object... args) {
        logger.info(message, args);
    }

    /**
     * Logs a debug message.
     * @param message The message to log (supports parameter placeholders {})
     * @param args Optional arguments to include in the message
     */
    public static void debug(String message, Object... args) {
        logger.debug(message, args);
    }

    /**
     * Logs a warning message.
     * @param message The message to log (supports parameter placeholders {})
     * @param args Optional arguments to include in the message
     */
    public static void warn(String message, Object... args) {
        logger.warn(message, args);
    }

    /**
     * Logs an error message.
     * @param message The message to log (supports parameter placeholders {})
     * @param args Optional arguments to include in the message
     */
    public static void error(String message, Object... args) {
        logger.error(message, args);
    }

    /**
     * Logs an error message with an associated Throwable.
     * @param message The message to log (supports parameter placeholders {})
     * @param throwable The Throwable to log
     * @param args Optional arguments to include in the message
     */
    public static void error(String message, Throwable throwable, Object... args) {
        logger.error(String.format(message, args), throwable);
    }
}
