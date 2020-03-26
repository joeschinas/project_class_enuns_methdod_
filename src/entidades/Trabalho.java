
package entidades;

import entidades_enums.NivelTrabalho;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Trabalho {
    private String nome;
    private NivelTrabalho nivel;
    private Double baseSalario;
    private Departamento depart;
    private List<HoraContrato> contratos = new ArrayList<>();

    public Trabalho() {
    }

    public Trabalho(String nome, NivelTrabalho nivel, Double baseSalario, Departamento depart) {
        this.nome = nome;
        this.nivel = nivel;
        this.baseSalario = baseSalario;
        this.depart = depart;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalho getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalho nivel) {
        this.nivel = nivel;
    }

    public Double getBaseSalario() {
        return baseSalario;
    }

    public void setBaseSalario(Double baseSalario) {
        this.baseSalario = baseSalario;
    }

    public Departamento getDepart() {
        return depart;
    }

    public void setDepart(Departamento depart) {
        this.depart = depart;
    }

    public List<HoraContrato> getContratos() {
        return contratos;
    }
    public void addContrato(HoraContrato contrato){
    
    contratos.add(contrato);
    }
    public void removeContratos(HoraContrato contrato){
    
        contratos.remove(contrato);    
    }
    public Double renda(int ano, int mes){
        
        Double sum = baseSalario;
        Calendar cal = Calendar.getInstance();
        
        for (HoraContrato c : contratos){
        cal.setTime(c.getDate());
        int c_ano = cal.get(Calendar.YEAR);
        int c_mes = 1+cal.get(Calendar.MONTH);
        if(mes == c_mes && ano == c_ano){
          
           sum +=c.valorTotal();
          }
       
        }
       
        return sum;
 
    }
    }


    

