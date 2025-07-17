package br.com.dio.exception;

public class EmptyStorageException extends RuntimeException {
    public EmptyStorageException(String s) {
        super(s);
    }
}
