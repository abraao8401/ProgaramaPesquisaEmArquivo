import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import enums.Regiao;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a sigla de um estado?");
        String sigla = sc.nextLine();


        try {
            FileReader arquivo = new FileReader("src/resources/UF.csv");
            BufferedReader leitorArq = new BufferedReader(arquivo);

            String linha = leitorArq.readLine();
            while(linha != null) {
                String[] dividida = linha.split(",");

                if(dividida[1].contains(sigla)){

                    System.out.printf("Nome do Estado: %s ", dividida[2]);
                    int codigo = Integer.parseInt(dividida[3]);
                    Regiao regiao = Regiao.fromCodigo(codigo);
                    System.out.printf("Região: %s ", regiao);
                    System.out.printf("País: %s\n", dividida[4]);
                    System.out.println("------------------------------------------------------");
                }

                linha = leitorArq.readLine(); // lê da segunda até a última linha
            }
            arquivo.close();
        }catch(IOException e){
            System.out.println("Impossível abrir o arquivo");
        }



    }
}