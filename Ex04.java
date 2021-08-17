
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex04 {

    public static void main(String[] args) {
        
        boolean errinho = false;

        Scanner entrada = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataAtual = Calendar.getInstance();

        String strData = "";

        Float preco = 0.0f;
        
        int parcelas = 0;

        do {
            errinho = false;

            if (errinho == false) {
                try {
                    System.out.println("Informe o valor total da compra: ");
                    preco = Float.parseFloat(entrada.nextLine());

                    if (preco <= 0) {
                        throw new Exception("O valor informado precisa ser maior do que 0");
                        
                    }
                    
                } catch (NumberFormatException ne) {
                    
                    System.out.println("Número Inválido: "
                    + ne.getMessage());
                    
                    errinho = true;
                    
                } catch (Exception e) {
                    
                    System.out.println("Ocorreu uma exceção: " + e.getMessage()
                            + "\nClasse do Erro: " + e.getClass());
                    
                    errinho = true;
                }
            }

            
            if (errinho == false) {
                try {
                    
                    System.out.println("Informe a quantidade de parcelas: ");
                    parcelas = Integer.parseInt(entrada.nextLine());

                    if (parcelas <= 0) {
                        throw new Exception("A quantidade de parcelas precisa ser maior do que 0.");

                    }
                    
                } catch (NumberFormatException ne) {
                    
                    System.out.println("Número Inválido: "
                    + ne.getMessage());
                    
                    errinho = true;
                } catch (Exception e) {
                    
                    System.out.println("Ocorreu uma exceção: " + e.getMessage()
                            + "\nClasse do Erro: " + e.getClass());
                    
                    errinho = true;
                }
            }
            
        } while (errinho == true);

        Calendar[] dataParcelas = new Calendar[parcelas];
        float[] parcelaVetor = new float[parcelas];
        float valorParcela = preco / parcelas;
        
        System.out.println("Valor da Compra: " + String.format("%.2f", preco));
        System.out.println("Total de Parcelas: " + parcelas);

        for (int i = 0; i < parcelas; i++) {
            
            parcelaVetor[i] = valorParcela;
            dataAtual.add(Calendar.DATE, 30);
            
            dataParcelas[i] = dataAtual;

            System.out.println("Valor da Parcela: " + String.format("%.2f", parcelaVetor[i]) + " - Data do " + (i + 1) + "º vencimento: " + sdf.format(dataParcelas[i].getTime()));
            
        }

    }

}
