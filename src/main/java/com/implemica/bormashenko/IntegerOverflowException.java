package com.implemica.bormashenko;

/**
 * This class describes an Exception caused by overflowing integer value.
 *
 * @author Mykhailo Bormashenko
 */
public class IntegerOverflowException extends RuntimeException {

    /**
     * Constructor of exception with message.
     *
     * @param message message to show in exception.
     */
    IntegerOverflowException(String message) {
        super(message);
    }
}
