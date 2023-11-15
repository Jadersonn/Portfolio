/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author Jd
 */
public class Versao {

    private int versaoId;
    private String nomeVersao;
    private String anoVersao;
    private int fkCarroId;

    /**
     * @return the versaoId
     */
    public int getVersaoId() {
        return versaoId;
    }

    /**
     * @param versaoId the versaoId to set
     */
    public void setVersaoId(int versaoId) {
        this.versaoId = versaoId;
    }

    /**
     * @return the nomeVersao
     */
    public String getNomeVersao() {
        return nomeVersao;
    }

    /**
     * @param nomeVersao the nomeVersao to set
     */
    public void setNomeVersao(String nomeVersao) {
        this.nomeVersao = nomeVersao;
    }

    /**
     * @return the anoVersao
     */
    public String getAnoVersao() {
        return anoVersao;
    }

    /**
     * @param anoVersao the anoVersao to set
     */
    public void setAnoVersao(String anoVersao) {
        this.anoVersao = anoVersao;
    }

    /**
     * @return the fkCarroId
     */
    public int getFkCarroId() {
        return fkCarroId;
    }

    /**
     * @param fkCarroId the fkCarroId to set
     */
    public void setFkCarroId(int fkCarroId) {
        this.fkCarroId = fkCarroId;
    }

}
