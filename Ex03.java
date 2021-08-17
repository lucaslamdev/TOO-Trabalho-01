
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Ex03 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        boolean erro = false;

        String strData = "";
        Calendar calendario = Calendar.getInstance();

        do {
            erro = false;

            if (erro == false) {
                try {
                    System.out.println("Informe a primeira data de pagamento (dd/MM/aaaa): ");
                    strData = entrada.nextLine();

                    calendario.setTime(sdf.parse(strData));

                } catch (Exception e) {

                    System.out.println("Ocorreu uma exceção: " + e.getMessage()
                            + "\nClasse do Erro: " + e.getClass());

                    erro = true;
                }
                
            }
            
        } while (erro == true);

        System.out.println("Data Informada: " + sdf.format(calendario.getTime()));

        for (int i = 0; i < 5; i++) {
            calendario.add(Calendar.DATE, 7);
            System.out.println("Data de Pagamento: " + sdf.format(calendario.getTime()));
        }
        
    }
    
}

