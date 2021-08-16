
import java.util.Scanner;
import java.text.DecimalFormat;

public class Ex01 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        boolean erro = false;
        
        String nomeCompleto = "";
        
        Float salario = 0.0f;
        Float salario_liquido = 0.0f;
        Float inss = 0.0f;
        Float inss_maximo = 0.0f;

        do {
            erro = false;

            if (erro == false) {
                try {
                    System.out.println("Informe o Nome Completo: ");
                    nomeCompleto = entrada.nextLine();

                    if (nomeCompleto.length() <= 0) {
                        throw new Exception("O nome não pode estar vazio!");
                    }
                } catch (Exception e) {
                    
                    System.out.println("Ocorreu uma exceção: " + e.getMessage()
                    + "\nClasse do Erro: " + e.getClass());
                    
                    erro = true;
                }
            }

            
            if (erro == false) {
                try {
                    System.out.println("Informe o Salário: ");
                    salario = Float.parseFloat(entrada.nextLine());

                    if (salario <= 0) {
                        throw new Exception("O salário não pode ser 0 ou menor que 0.");
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
        } while (erro == true);

        
        if (salario > 6433.57) {
            inss_maximo = 6433.57f;
        } else {
            inss_maximo = salario;
        }

        
        if (inss_maximo <= 1100) {
            inss = (inss_maximo * 7.5f) / 100;
        } else if (inss_maximo > 1100 && inss_maximo <= 2203.48f) {
            inss = (inss_maximo * 9.0f) / 100;
        } else if (inss_maximo > 2203.48f && inss_maximo <= 3305.22f) {
            inss = (inss_maximo * 12.0f) / 100;
        } else if (inss_maximo > 3305.23f && inss_maximo <= 6433.57f) {
            inss = (inss_maximo * 14.0f) / 100;
        }

        
        salario_liquido = salario - inss;

        System.out.println("Nome Completo: " + nomeCompleto);
        System.out.println("Salário bruto: " + String.format("%.2f", salario));
        System.out.println("INSS: " + String.format("%.2f", inss));
        System.out.println("Salário líquido: " + String.format("%.2f", salario_liquido));
    }

}
