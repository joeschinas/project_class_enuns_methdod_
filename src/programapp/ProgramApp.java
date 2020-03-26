
package programapp;

import entidades.Departamento;
import entidades.HoraContrato;
import entidades.Trabalho;
import entidades_enums.NivelTrabalho;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramApp {


    public static void main(String[] args) throws ParseException { 
        Locale.setDefault(Locale.US);
        Scanner read = new Scanner (System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.printf("Entre com o nome do Departamento:");
        String departamentoNome = read.nextLine();
        System.out.println("Entre com os dados do trabalhador...");
        System.out.printf("NOME:");
        String nomeTrabalhador= read.nextLine();
        System.out.printf("Nivel:");
        String nivelTrabalhador= read.nextLine();
        System.out.printf("Qual o salario base:");
        Double baseSalario = read.nextDouble();
        Trabalho Trabalhador = new Trabalho(nomeTrabalhador, NivelTrabalho.valueOf(nivelTrabalhador),baseSalario,new Departamento(departamentoNome));
        
        
        
        System.out.printf("Quantos contratos ele trabalhou:");
        Integer n = read.nextInt();
        
        for(int i=1; i<=n; i++)
        {
        System.out.println("Entre com data do #" + i + " contrato");
        Date dataContrato = sdf.parse(read.next());
        System.out.println("Valor de horas trabalhado");
        double valorPorHora= read.nextDouble();
        System.out.println("horas trabalhada");
        Integer horas = read.nextInt();
        
        
        HoraContrato valorContrato = new HoraContrato(dataContrato, valorPorHora, horas);
         Trabalhador.addContrato(valorContrato);
        }
       
        System.out.println("Entre com o mes e o ano para calcular a renda:");
        String mesEano = read.next();
        int mes = Integer.parseInt(mesEano.substring(0,2));
        
        int ano = Integer.parseInt(mesEano.substring(3));
      
        System.out.print("Nome:"+Trabalhador.getNome());
        System.out.println("Departamento"+ Trabalhador.getDepart().getNome());
        System.out.println("Renda do "+mesEano+":"+ Trabalhador.renda(ano, mes));
        
        
         /*conversão de string para numero
        System.out.println("digite a data de nascimento mes e ano");
        String monthAndYears = read.nextLine();
        int month = Integer.parseInt(monthAndYears.substring(0, 2));
        int year = Integer.parseInt(monthAndYears.substring(0, 4));
        */
        read.close();
    }
    
}
