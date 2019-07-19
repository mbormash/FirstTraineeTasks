package com.implemica.bormashenko;

/**
 * This class describes an Exception caused by overflowing integer value.
 *
 * @author Mykhailo Bormashenko
 */
public class IntegerOverflowException extends RuntimeException {

    IntegerOverflowException(String message) {
        super(message);
    }
}
