/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author Jd
 */
public class Modelo {

    private int modeloId;
    private String nomeModelo;
    private String anoModelo;
    private int fkVersaoId;

    /**
     * @return the modeloId
     */
    public int getModeloId() {
        return modeloId;
    }

    /**
     * @param modeloId the modeloId to set
     */
    public void setModeloId(int modeloId) {
        this.modeloId = modeloId;
    }

    /**
     * @return the nomeModelo
     */
    public String getNomeModelo() {
        return nomeModelo;
    }

    /**
     * @param nomeModelo the nomeModelo to set
     */
    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    /**
     * @return the anoModelo
     */
    public String getAnoModelo() {
        return anoModelo;
    }

    /**
     * @param anoModelo the anoModelo to set
     */
    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    /**
     * @return the fkVersaoId
     */
    public int getFkVersaoId() {
        return fkVersaoId;
    }

    /**
     * @param fkVersaoId the fkVersaoId to set
     */
    public void setFkVersaoId(int fkVersaoId) {
        this.fkVersaoId = fkVersaoId;
    }

}
