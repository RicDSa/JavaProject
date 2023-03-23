/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpraticob;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;


/**
 *
 * @author ricar
 */
public class TrabPraticoB {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Socios socio[] = new Socios[10];
        Bilheteira bilhetes[] = new Bilheteira[10];
        Clube clube[] = new Clube[10];
        
        int opcao = -1;
        int op = -1;
        int opc = -1;
        
        Scanner scan = new Scanner(System.in);
        
        while(opcao != 0){
            
            System.out.println("1 - Socio");
            System.out.println("2 - Gestor");
            System.out.println("0 - Sair.");
            opcao = scan.nextInt();
            
            switch(opcao){
                case 1:
                    do{
                        System.out.println("1 - Comprar Bilhete.");
                        System.out.println("2 - Inscrever Socio.");
                        System.out.println("3 - Pagar Cotas.");
                        System.out.println("4 - Ver informação.");
                        System.out.println("5 - Ver jogos.");
                        System.out.println("6 - Mudar Nivel de Socio.");
                        System.out.println("7 - Remover Socio.");
                        System.out.println("0 - Menu Pincipal.");
                        op = scan.nextInt();
                        
                        switch(op){
                            case 1:
                                pagar_bilhete(socio,bilhetes);
                                break;
                            case 2:
                                insere_socios(socio);
                                break;
                            case 3:
                                pagar_cotas(socio);
                                break;
                            case 4:
                                ver_informacao_socio(socio);
                                break;
                            case 5:
                                ver_modalidade(clube);
                                break;
                            case 6:
                                mudar_nivel_socio(socio);
                                break;
                            case 7:
                                remover_socio(socio);
                                break;
                            case 0:
                                break;
                        }
                    }while(op!=0);
                    break;
                case 2:
                    do{
                        System.out.println("1 - Validar Bilhetes.");
                        System.out.println("2 - Ver Socios.");
                        System.out.println("3 - Criar Modalidade.");
                        System.out.println("4 - Remover Modalidade.");
                        System.out.println("5 - Ver Modalidade.");
                        System.out.println("6 - Guardar Registos.");
                        System.out.println("0 - Menu Pincipal.");
                        opc = scan.nextInt();
                        
                        switch(opc){
                            case 1:
                                insere_bilhete(bilhetes);
                                break;
                            case 2:
                                ver_informacao_socios(socio);
                                break;
                            case 3:
                                inserir_modalidade(clube);
                                break;
                            case 4:
                                remover_modalidade(clube);
                                break;
                            case 5:
                                ver_modalidade(clube);
                                break;
                            case 6:
                                ficheiros(socio,clube);
                                break;
                            case 0:
                                break;
                        }
                    }while(opc!=0);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
        
    }
    
    public static void insere_socios(Socios array[]){
        Scanner scanner = new Scanner(System.in);
        int codigo = 0;
        String nome;
        String pass;    
        String morada;        
        int nif=0;
        String nivel;
        
        do{
            System.out.println("Introduza o numero de socio: ");
            codigo = scanner.nextInt();
            scanner.nextLine();
            
            if(codigo < 0){
                System.out.println("O código deve ser positivo!");
                continue;
            }
            
            for(Socios mTemp : array){
                if(mTemp != null){
                    if(mTemp.getNumSocio() == codigo){
                        System.out.println("O código não deve ser repetido!");
                        codigo = -1;
                        break;
                    }
                }
            }
            
        } while(codigo < 0);
        
        
        
        System.out.println("Introduza o nome: ");
        nome = scanner.nextLine();
       
        System.out.println("Introduza a palavra-passe que deseja: ");
        pass = scanner.nextLine();
        
        System.out.println("Introduza a morada: ");
        morada = scanner.nextLine();
        
        System.out.println("Introduza o NIF: ");
        nif = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Introduza o Nivel(normal,intermedio,premium) de socio que pretende: ");
        nivel = scanner.nextLine();
        
        
        
        for(int x=0;x < array.length; x++){
            if(array[x] == null){
                array[x] = new Socios(codigo,nome,pass, morada, nif, nivel);
                System.out.println("Inserido!");
                return;
            }
        }
        System.out.println("Erro a inserir");
    }
    
    public static void ver_informacao_socio(Socios array[]){
        Scanner scanner = new Scanner(System.in);
        int cod = 0;
        String pass;
        
        System.out.println("Introduza o seu numero de Socio: ");
        cod = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Introduza a palavra-passe: ");
        pass = scanner.nextLine();
        
        
        for(int i=0;i<array.length;i++){
            if(array[i] != null ){
                if(array[i].getNumSocio() == cod && array[i].getPass().equals(pass) == true){
                    System.out.println("Num Socio: " + array[i].getNumSocio() + "\nNome: " + array[i].getNome() + "\nMorada: " + array[i].getMorada() + "\nNIF: " + array[i].getNIF() + "\nNivel: " + array[i].getNivel() + "\nEstado cotas: " + array[i].isEstado());
                    return;
                }
            }
        }
        System.out.println("Não existe esse Sócio.");
    }
    
    public static void remover_socio(Socios array[]){
        Scanner scanner = new Scanner(System.in);
        int cod = 0;
        
        
        System.out.println("Introduza o seu numero de Socio: ");
        cod = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Introduza a palavra-passe: ");
        String pass = scanner.next();
        scanner.nextLine();
        
        for(int i = 0; i < array.length; i++){
            if(array[i] != null && array[i].getNumSocio() == cod && array[i].getPass().equals(pass) == true){
                array[i]= null;
                System.out.println("Removido!");
            }
            else{
                System.out.println("Não existe esse Sócio.");
            }
        }
    }
    
    public static void mudar_nivel_socio(Socios array[]){
        Scanner scanner = new Scanner(System.in);
        int cod = 0;
        
        
        System.out.println("Introduza o seu numero de Socio: ");
        cod = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Introduza a palavra-passe: ");
        String pass = scanner.nextLine();
        
        
        for(int i = 0; i < array.length; i++){
            if(array[i] != null && array[i].getNumSocio() == cod && array[i].getPass().equals(pass) == true){
                System.out.println("Introduza o Nivel(normal,intermedio,premium) de socio que pretende: ");
                String nivel = scanner.nextLine();
                array[i].setNivel(nivel);
                System.out.println("Mudança feita com sucesso!");
            }
            else{
                System.out.println("Não existe esse Sócio.");
            }
        }
    }
    
    public static void ver_informacao_socios(Socios array[]){
        for(int i = 0; i < array.length; i++){
            if(array[i] != null){
                System.out.println("Num Socio: " + array[i].getNumSocio() + "\nNome: " + array[i].getNome() + "\nMorada: " + array[i].getMorada() + "\nNIF: " + array[i].getNIF() + "\nNivel: " + array[i].getNivel() + "\nEstado cotas: " + array[i].isEstado() + "\n-------------------------\n");
            }
            else{
                System.out.println("Não existe mais Sócios.");
            }
        }
    }
    
    public static void insere_bilhete(Bilheteira array[]){
        Scanner scanner = new Scanner(System.in);
        int codigo = 0;
        float pre = 0;
        String n = "normal";
        String ni = "intermedio";
        String niv = "premium";
        
        do{
            System.out.println("Introduza o código para o material: ");
            codigo = scanner.nextInt();
            scanner.nextLine();
            
            if(codigo < 0){
                System.out.println("O código deve ser positivo!");
                continue;
            }
            
            for(Bilheteira mTemp : array){
                if(mTemp != null){
                    if(mTemp.getNum() == codigo){
                        System.out.println("O código não deve ser repetido!");
                        codigo = -1;
                        break;
                    }
                }
            }
            
        } while(codigo < 0);
        
        
        System.out.println("Introduza a modalidade: ");
        String mod = scanner.nextLine();
        
        
        System.out.println("Introduza a equipa da casa: ");
        String casa = scanner.nextLine();
        
        
        System.out.println("Introduza a equipa visitante: ");
        String vist = scanner.nextLine();
        
        
        System.out.println("Introduza o lugar no estadio: ");
        String lugar = scanner.nextLine();
        
        
        System.out.println("Introduza o Nivel(normal,intermedio,premium) de socio que pretende: ");
        String nivel = scanner.nextLine();
        
        
        if(nivel.equals(n)){
           System.out.println("Introduza o Preço(8,5): ");
            float preco = scanner.nextFloat(); 
            pre = preco;
        }
        if(nivel.equals(ni)){
            System.out.println("Introduza o Preço(8): ");
            float preco = scanner.nextFloat();
            pre = preco;
        }
        if(nivel.equals(niv)){
            System.out.println("Introduza o Preço(5): ");
            float preco = scanner.nextFloat();
            pre = preco;
        }
        
        for(int x=0;x < array.length; x++){
            if(array[x] == null){
                array[x] = new Bilheteira(codigo, pre, mod, casa, vist,nivel,lugar);
                System.out.println("Inserido!");
                return;
            }
        }
        System.out.println("Erro a inserir");
    }
    
    public static void pagar_cotas(Socios array[]) {
        Scanner scanner = new Scanner(System.in);
        int cod = 0;
        float total = 0;
        float saldo = 0;
        boolean estado = true;
        
        
        System.out.println("Introduza o seu numero de Socio: ");
        cod = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Introduza a palavra-passe: ");
        String pass = scanner.nextLine();
        
        
        System.out.println("Introduza o valor para pagar as cotas(50): ");
        saldo = scanner.nextFloat();
        scanner.nextLine();
        
        for(int i = 0; i < array.length; i++){
            if(array[i] != null && array[i].getNumSocio() == cod && array[i].getPass().equals(pass)){
                if(array[i].getCotas() == saldo){
                    total=array[i].getCotas();
                    total-=saldo;
                    total=array[i].getCotas();
                    estado=array[i].isEstado();
                    System.out.println("As cotas estão pagas.");
                }
                else{
                    System.out.println("As cotas não estão pagas.");
                }
            }
            else{
                System.out.println("Não existe esse Sócio.");
            }
        }
        
    }
    
    public static void pagar_bilhete(Socios array[],Bilheteira arr[]){
        Scanner scanner = new Scanner(System.in);
        int cod = 0;
        float total = 0;
        float saldo = 0;
        String nivel = null;
        
        
        System.out.println("Introduza o seu numero de Socio: ");
        cod = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Introduza a palavra-passe: ");
        String pass = scanner.nextLine();
        
        
        for(int i = 0; i < array.length; i++){
            if(array[i] != null && array[i].getNumSocio() == cod && array[i].getPass().equals(pass)){
                nivel = array[i].getNivel();
                System.out.println("O seu nivel de socio é: " + nivel);
            }
            else{
                System.out.println("Não existe esse Sócio.");
            }
        }
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i].getNivel().equals(nivel) == true && arr[i].getPreco() != 0 && array[i] != null){
                System.out.println("Introduza o valor para pagar o bilhete (normal: 8,5;intermedio: 8;premium: 5): ");
                saldo = scanner.nextFloat();
                total=arr[i].getPreco();
                total-=saldo;
                total=arr[i].getPreco();
                System.out.println("O bilhete está pago e o seu numero é: " + arr[i].getNum());
            }
            else{
                System.out.println("Este bilhete já tem dono.");
            }
        }
    }
    
    public static void inserir_modalidade(Clube array[]){
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Introduza o nome do clube: ");
        String nome = scanner.nextLine();
        
        
        System.out.println("Introduza o nome da modalidade: ");
        String mod = scanner.nextLine();
        
        
        System.out.println("Introduza a equipa adversaria a jogar: ");
        String eq = scanner.nextLine();
        
        
        System.out.println("Introduza a data de cada jogo(formato dd/mm/yy): ");
        String dat = scanner.nextLine();
        
        
        System.out.println("Introduza o resultado do jogo(caso não tenha jogado ponha indefinido): ");
        String res = scanner.nextLine();
        
        
        for(int x=0;x < array.length; x++){
            if(array[x] == null){
                array[x] = new Clube(nome,mod,dat,eq,res);
                System.out.println("Inserido!");
                return;
            }
        }
        System.out.println("Erro a inserir");
    }
    
    public static void remover_modalidade(Clube array[]){
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.println("Introduza a modalidade que quer remover: ");
        String mod = scanner.nextLine();
        
        
        for(int i = 0; i < array.length; i++){
            if(array[i] != null && array[i].getModalidade().equals(mod) == true){
                array[i]= null;
                System.out.println("Removido!");
            }
            else{
                System.out.println("Não existe essa modalidade.");
            }
        }
    }
    
    public static void ver_modalidade(Clube array[]){
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Introduza a modalidade que quer ver: ");
        String mod = scanner.next();
        scanner.nextLine();
        
        //Imprime a modalidade que deseja
        for(int i = 0; i < array.length; i++){
            if(array[i] != null && array[i].getModalidade().equals(mod) == true){
                System.out.println("Nome do Clube: " + array[i].getNome() + "\nModalidade: " + array[i].getModalidade() + "\nEq Adversaria: " + array[i].getEqVisitante() + "\nData: " + array[i].getData() + "\nResultado: " + array[i].getResultado());
            }
            else{
                System.out.println("Não existe essa modalidade.");
            }
        }
    }
    
    public static void ficheiros(Socios array[],Clube arr[]) throws IOException{
        Scanner scanner = new Scanner(System.in);
        
        //Criação do ficheiro
        System.out.print("Insira o nome do Ficheiro: ");
        String fName = scanner.nextLine();
        
        File file = new File(fName+".txt");
        if(file.createNewFile())
            System.out.print("\n\nCriou um Ficheiro novo\n\n");
        else {
            System.out.print("\n\nO Ficheiro foi alterado\n\n");
            file.delete();
            file.createNewFile();
        }
        
        //Inserir conteudo ao ficheiro
        BufferedWriter writer = new BufferedWriter(new FileWriter(file,false));
        
        writer.write("Lista de Sócios\n");
        for(int i = 0;i<array.length;i++){
            writer.append("Num Socio: " + array[i].getNumSocio() + "\nNome: " + array[i].getNome() + "\nMorada: " + array[i].getMorada() + "\nNIF: " + array[i].getNIF() + "\nNivel: " + array[i].getNivel() + "\nEstado cotas: " + array[i].isEstado() + "\n-------------------------\n");
            
        }
        writer.append("\nLista de Modalidades");
        for(int i = 0;i<arr.length;i++){
            writer.append("Nome do Clube: " + arr[i].getNome() + "\nModalidade: " + arr[i].getModalidade() + "\nEq Adversaria: " + arr[i].getEqVisitante() + "\nData: " + arr[i].getData() + "\nResultado: " + arr[i].getResultado() + "\n-------------------------\n");
            
        }
        writer.flush();
        writer.close();
    }
    
}
