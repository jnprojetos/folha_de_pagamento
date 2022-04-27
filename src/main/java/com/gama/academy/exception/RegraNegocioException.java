package com.gama.academy.exception;

public class RegraNegocioException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RegraNegocioException(String message) {
        super(message);
    }
}
