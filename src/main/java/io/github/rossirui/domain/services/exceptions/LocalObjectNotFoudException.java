package io.github.rossirui.domain.services.exceptions;

public class LocalObjectNotFoudException extends RuntimeException {

    public LocalObjectNotFoudException(String mensagem) {
        super(mensagem);
    }

    public LocalObjectNotFoudException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
