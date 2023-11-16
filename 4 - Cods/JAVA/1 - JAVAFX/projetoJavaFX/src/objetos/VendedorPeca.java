/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author Jd
 */
public class VendedorPeca {

    private int fkVendedorId; // Chave estrangeira referente a vendedorId na tabela Vendedor
    private int fkPecaId; // Chave estrangeira referente a pecaId na tabela Peca
    private String fkIdGeralPeca; // Chave estrangeira referente a idGeralPeca na tabela Peca

    /**
     * @return the fkVendedorId
     */
    public int getFkVendedorId() {
        return fkVendedorId;
    }

    /**
     * @param fkVendedorId the fkVendedorId to set
     */
    public void setFkVendedorId(int fkVendedorId) {
        this.fkVendedorId = fkVendedorId;
    }

    /**
     * @return the fkPecaId
     */
    public int getFkPecaId() {
        return fkPecaId;
    }

    /**
     * @param fkPecaId the fkPecaId to set
     */
    public void setFkPecaId(int fkPecaId) {
        this.fkPecaId = fkPecaId;
    }

    /**
     * @return the fkIdGeralPeca
     */
    public String getFkIdGeralPeca() {
        return fkIdGeralPeca;
    }

    /**
     * @param fkIdGeralPeca the fkIdGeralPeca to set
     */
    public void setFkIdGeralPeca(String fkIdGeralPeca) {
        this.fkIdGeralPeca = fkIdGeralPeca;
    }

}
