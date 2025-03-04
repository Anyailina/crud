package org.annill.crud.exception;

public class EntityNotFoundException extends RuntimeException{
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public EntityNotFoundException() {
        super("Entity Not Found");
    }
}
