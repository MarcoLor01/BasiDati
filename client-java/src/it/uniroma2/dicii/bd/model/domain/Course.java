package it.uniroma2.dicii.bd.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Course{
    private Integer ID_Corso;
    private String Nome;
    private Integer minPart;
    private Integer maxPart;
    private Integer idVasca;
    private Date dataInizioCorso;
    private BigDecimal prezzo;

    public Course(String nome, Integer minPart, Integer maxPart, Integer idVasca, Date dataInizioCorso, BigDecimal prezzo) {
        this.Nome = nome;
        this.minPart = minPart;
        this.maxPart = maxPart;
        this.idVasca = idVasca;
        this.prezzo = prezzo;
    }



    public Integer getID_Corso() {
        return ID_Corso;
    }

    public String getNome() {
        return Nome;
    }

    public Integer getMinPart() {
        return minPart;
    }

    public Integer getMaxPart() {
        return maxPart;
    }

    public Integer getIdVasca() {
        return idVasca;
    }

    public Date getDataInizioCorso() {
        return dataInizioCorso;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setID_Corso(Integer ID_Corso) {
        this.ID_Corso = ID_Corso;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setMinPart(Integer minPart) {
        this.minPart = minPart;
    }

    public void setMaxPart(Integer maxPart) {
        this.maxPart = maxPart;
    }

    public void setIdVasca(Integer idVasca) {
        this.idVasca = idVasca;
    }

    public void setDataInizioCorso(Date dataInizioCorso) {
        this.dataInizioCorso = dataInizioCorso;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
}
