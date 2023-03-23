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
public class Socios {
    private int numSocio;
    private String nome;
    private String pass;
    private String morada;
    private int NIF;
    private String nivel;
    private float Cotas=50;
    private boolean estado = false;

    public Socios(int numSocio, String nome, String pass, String morada, int NIF, String nivel) {
        this.numSocio = numSocio;
        this.nome = nome;
        this.pass = pass;
        this.morada = morada;
        this.NIF = NIF;
        this.nivel = nivel;
    }


    public int getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel){
        this.nivel = nivel;
    }
    
    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public float getCotas() {
        return Cotas;
    }

    public void setCotas(float Cotas) {
        this.Cotas = Cotas;
    }

    
}
