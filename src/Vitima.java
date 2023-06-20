import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Vitima extends Cadastro {
    protected static int lcod = 0;
    
    public static void importarVit(ArrayList<Vitima> alVit) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("vitdb.txt"));
            String linhaArquivo;
            while ((linhaArquivo = reader.readLine()) != null) {
                Vitima item = new Vitima();
                item.setCod(lcod++);
                item.setConteudo(linhaArquivo);

                alVit.add(item);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }

    }

    public static void listar(ArrayList<Vitima> al) {

        System.out.print("\n");
        for (Cadastro lista : al) {
            System.out.print(lista.getCod());
            System.out.println(" " + lista.getConteudo());
        }
    }
}
