package com.crianca.atividades.portal.gateway.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity(name = "arquivos_pdf")
public class AtividadePdfModel {

    @Id
    private Integer id;

    @Lob
    private byte[] arquivo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }
}
