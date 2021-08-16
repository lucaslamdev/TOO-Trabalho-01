
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;


public class Ex02 {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        Calendar calendario = Calendar.getInstance();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        boolean erro = false;
        
        Float diaria = 0.0f;
        
        String strDataLocacao = "";
        String strDataDevolucao = ""; 
        
        int intDataLocacao = 0;
        int intDataDevolucao = 0;
        int diasUsados = 0;
        
        do {
            erro = false;
            
            if(!erro) {
                try {     
                    System.out.println("Informe o valor da diária: ");
                    diaria = Float.parseFloat(entrada.nextLine());
                    
                    if(diaria <= 0) 
                    {
                        throw new Exception("A diária precisa ser maior que 0");
                    }
                } catch (NumberFormatException ne) {
                    
                    System.out.println("Número Inválido: "
                    + ne.getMessage());
                    
                    erro = true;
                } catch (Exception e) {
                    
                    System.out.println("Ocorreu uma exceção: " + e.getMessage()
                    + "\nClasse do Erro: " + e.getClass());
                    
                    erro = true;
                }
            }
            
            if(!erro) {
                try {
                    
                    System.out.println("Informe a data de locação no formato dd/mm/aaaa: ");
                    strDataLocacao = entrada.nextLine();
                    
                } catch (Exception e) {
                    
                    System.out.println("Ocorreu uma exceção: " + e.getMessage()
                    + "\nClasse do Erro: " + e.getClass());
                    
                    erro = true;
                }
            }
            
            if(!erro) {
                try {
                    System.out.println("Informe uma data de devolução no formato dd/mm/aaaa: ");
                    strDataDevolucao = entrada.nextLine();
                    

                } catch (Exception e) {
                    
                    System.out.println("Ocorreu uma exceção: " + e.getMessage()
                    + "\nClasse do Erro: " + e.getClass());
                    
                    erro = true;
                }
            } 
            
            if(!erro) {
                try {              
                    sdf.setLenient(false);
                    
                    Date dateDataLocacao = sdf.parse(strDataLocacao);
                    calendario.setTime(dateDataLocacao);
                    intDataLocacao = calendario.get(Calendar.DAY_OF_YEAR);
                    
                    Date dateDataDevolucao = sdf.parse(strDataDevolucao);
                    calendario.setTime(dateDataDevolucao);
                    intDataDevolucao = calendario.get(Calendar.DAY_OF_YEAR);
                    
                    diasUsados =  intDataDevolucao - intDataLocacao;
                    
                } catch (Exception e) {
                    System.out.println("Ocorreu uma exceção: " + e.getMessage()
                    + "\nClasse do Erro: " + e.getClass());
                    erro = true;
                }
            }
        } while(erro == true);
        
        Float valorTotal = diaria * diasUsados;
        
        System.out.println("Valor da diária: " + String.format("%.2f", diaria));
        System.out.println("Data de locação: " + strDataLocacao);
        System.out.println("Data de devolução: " + strDataDevolucao);
        System.out.println("Dias de locação: " + diasUsados);
        System.out.println("Valor total da locação: " + String.format("%.2f", valorTotal));
    }
}

