/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author Jd
 */
public class Vendedor {

    private int vendedorId;
    private String nomeVendedor;
    private double preco;
    private String link;
    private int fkUserId;

    /**
     * @return the vendedorId
     */
    public int getVendedorId() {
        return vendedorId;
    }

    /**
     * @param vendedorId the vendedorId to set
     */
    public void setVendedorId(int vendedorId) {
        this.vendedorId = vendedorId;
    }

    /**
     * @return the nomeVendedor
     */
    public String getNomeVendedor() {
        return nomeVendedor;
    }

    /**
     * @param nomeVendedor the nomeVendedor to set
     */
    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
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
