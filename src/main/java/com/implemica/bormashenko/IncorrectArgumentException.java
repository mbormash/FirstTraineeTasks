package com.implemica.bormashenko;

/**
 * This class describes an Exception for incorrect args.
 *
 * @author Mykhailo Bormashenko
 * @since 1.8
 */
public class IncorrectArgumentException extends RuntimeException {

    /**
     * Constructor of exception with message.
     *
     * @param message message to show in exception.
     */
    IncorrectArgumentException(String message) {
        super(message);
    }
}
