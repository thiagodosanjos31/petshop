package com.thiago.petshop.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private Integer status;
    private String mensagem;

    public StandardError() {
    }

    public StandardError(Integer status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


}
