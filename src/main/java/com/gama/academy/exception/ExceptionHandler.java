package com.gama.academy.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Campo> campos = new ArrayList<>();

        for(ObjectError error: ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            campos.add(new Campo(nome, mensagem));
        }

        ErroValidacao erroValidacao = new ErroValidacao();
        erroValidacao.setStatus(status.value());
        erroValidacao.setDataHora(OffsetDateTime.now());
        erroValidacao.setTitulo("Um ou mais campos estão inválidos");
        erroValidacao.setCampos(campos);

        return handleExceptionInternal(ex, erroValidacao, headers, status, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontrada(EntidadeNaoEncontradaException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        ErroValidacao erroValidacao = new ErroValidacao();
        erroValidacao.setStatus(status.value());
        erroValidacao.setDataHora(OffsetDateTime.now());
        erroValidacao.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, erroValidacao, new HttpHeaders(), status, request);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<Object> handleEntidadeDuplicada(RegraNegocioException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        ErroValidacao erroValidacao = new ErroValidacao();
        erroValidacao.setStatus(status.value());
        erroValidacao.setDataHora(OffsetDateTime.now());
        erroValidacao.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, erroValidacao, new HttpHeaders(), status, request);

    }

}
