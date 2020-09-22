package io.github.rossirui.domain.services.exceptions;

public class LocalObjectNotFoudException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LocalObjectNotFoudException(String mensagem) {
        super(mensagem);
    }

    public LocalObjectNotFoudException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
