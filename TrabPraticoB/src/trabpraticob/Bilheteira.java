/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpraticob;

/**
 *
 * @author ricar
 */
public class Bilheteira {
    private int num;
    private float preco;
    private String modalidade;
    private String eqCasa;
    private String eqVisitante;
    private String nivel;
    private String lugar;

    public Bilheteira(int num, float preco, String modalidade, String eqCasa, String eqVisitante, String nivel, String lugar) {
        this.num = num;
        this.preco = preco;
        this.modalidade = modalidade;
        this.eqCasa = eqCasa;
        this.eqVisitante = eqVisitante;
        this.nivel = nivel;
        this.lugar = lugar;
    }    

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Bilheteira(String lugar) {
        this.lugar = lugar;
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getModalidade(){
        return modalidade;
    }
    
    public void setModalidade(String mod){
        this.modalidade = mod;
    }
    
    public String getEqCasa() {
        return eqCasa;
    }

    public void setEqCasa(String eqCasa) {
        this.eqCasa = eqCasa;
    }

    public String getEqVisitante() {
        return eqVisitante;
    }

    public void setEqVisitante(String eqVisitante) {
        this.eqVisitante = eqVisitante;
    }
    
    
    
}
