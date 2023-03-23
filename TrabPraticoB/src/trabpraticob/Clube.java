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
public class Clube {
    
    private String nome;
    private String modalidade;
    private String data;
    private String eqVisitante;
    private String resultado;

    public Clube(String nome, String modalidade, String data, String eqVisitante, String resultado) {
        this.nome = nome;
        this.modalidade = modalidade;
        this.data = data;
        this.eqVisitante = eqVisitante;
        this.resultado = resultado;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEqVisitante() {
        return eqVisitante;
    }

    public void setEqVisitante(String eqVisitante) {
        this.eqVisitante = eqVisitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
    
    
}
