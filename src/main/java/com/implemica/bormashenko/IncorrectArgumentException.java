package com.implemica.bormashenko;

/**
 * This class describes an Exception for incorrect args.
 *
 * @author Mykhailo Bormashenko
 */
public class IncorrectArgumentException extends RuntimeException {

    IncorrectArgumentException(String message) {
        super(message);
    }
}
