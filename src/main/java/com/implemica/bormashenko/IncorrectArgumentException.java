package com.implemica.bormashenko;

/**
 * This class describes an Exception for incorrect args.
 *
 * @author Mykhailo Bormashenko
 */
public class IncorrectArgumentException extends RuntimeException {

    /**
     * Constructor of exception with message.
     * @param message message to show in exception.
     */
    IncorrectArgumentException(String message) {
        super(message);
    }
}
