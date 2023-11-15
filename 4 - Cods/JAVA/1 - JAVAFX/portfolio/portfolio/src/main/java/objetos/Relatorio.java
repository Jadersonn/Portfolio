/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.Date;

/**
 *
 * @author Jd
 */
public class Relatorio {

    private int registroId;
    private String acao;
    private Date data;
    private String descricao;
    private int fkUserId;

    /**
     * @return the registroId
     */
    public int getRegistroId() {
        return registroId;
    }

    /**
     * @param registroId the registroId to set
     */
    public void setRegistroId(int registroId) {
        this.registroId = registroId;
    }

    /**
     * @return the acao
     */
    public String getAcao() {
        return acao;
    }

    /**
     * @param acao the acao to set
     */
    public void setAcao(String acao) {
        this.acao = acao;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the fkUserId
     */
    public int getFkUserId() {
        return fkUserId;
    }

    /**
     * @param fkUserId the fkUserId to set
     */
    public void setFkUserId(int fkUserId) {
        this.fkUserId = fkUserId;
    }

}
