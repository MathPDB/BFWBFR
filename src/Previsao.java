import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Previsao extends Cadastro {
    protected static int lcod = 0;

    public static void importarPrev(ArrayList<Previsao> alPrev) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("futuredb.txt"));
            String linhaArquivo;
            while ((linhaArquivo = reader.readLine()) != null) {
                Previsao item = new Previsao();
                item.setCod(lcod++);
                item.setConteudo(linhaArquivo);

                alPrev.add(item);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }

    }

    public static void sortear(ArrayList<Vitima> alVit, ArrayList<Previsao> alPrev) {
        // Sorteio da vítima
        Random rVit = new Random(System.currentTimeMillis());
        int codVit = rVit.nextInt(alVit.size());
        String[] options = { " Sim ", " Não " };

        // Impressão da previsão para a vítima
        for (Vitima vitima : alVit) {
            if (vitima.getCod() == codVit) {
                int confirmacao = JOptionPane.showOptionDialog(
                        null,
                        "                   ***** -- ATENÇÃO -- *****\n\n" + vitima.getConteudo() + "\nDeseja saber o que o futuro lhe guarda?",
                        "Futurólogo GAGO",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (confirmacao == JOptionPane.NO_OPTION) {
                    return;
                }
            }
        }

        // Sorteio da Previsão
        Random rPrev = new Random(System.currentTimeMillis());
        int codPrev = rPrev.nextInt(alPrev.size());

        // Exibir caixa de diálogo de confirmação para a previsão
        for (Previsao previsao : alPrev) {
            if (previsao.getCod() == codPrev) {
                int confirmacao = JOptionPane.showOptionDialog(
                        null,
                        previsao.getConteudo() + "\nDeseja exportar esta previsão ?",
                        "Futurólogo GAGO",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (confirmacao == JOptionPane.NO_OPTION) {
                    return;
                }
                }
            }
        }
    

    public static void listar(ArrayList<Previsao> al) {

        System.out.print("\n");
        for (Cadastro lista : al) {
            System.out.print(lista.getCod());
            System.out.println(" " + lista.getConteudo());
        }
    }

}
