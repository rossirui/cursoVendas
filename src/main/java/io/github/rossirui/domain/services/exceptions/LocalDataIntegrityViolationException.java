package io.github.rossirui.domain.services.exceptions;

public class LocalDataIntegrityViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LocalDataIntegrityViolationException(String mensagem) {
        super(mensagem);
    }

    public LocalDataIntegrityViolationException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
