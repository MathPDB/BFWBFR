import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vitima> alVit = new ArrayList<Vitima>();
        ArrayList<Previsao> alPrev = new ArrayList<Previsao>();
        int op = 0;

        while (op != 3) { // op 3 = case 4
            String[] options = { "Importar um Arquivo", "Viajar para o Futuro", "Exportar Previsão", "Sair" };
            op = JOptionPane.showOptionDialog(
                    null, // Componente pai (null = janela principal)
                    "Selecione uma opção:", // Mensagem de texto
                    "Futurólogo GAGO", // Título da janela
                    JOptionPane.DEFAULT_OPTION, // Tipo de opções (padrão)
                    JOptionPane.PLAIN_MESSAGE, // Tipo de ícone (nenhum ícone)
                    null, // Ícones customizados (não utilizado)
                    options, // Opções do menu
                    options[0] // Opção selecionada por padrão
            );

            switch (op + 1) {
                case 1:
                    String[] optionsCad = { "Previsões", "Vítimas das Previsões", "Voltar" };
                    op = JOptionPane.showOptionDialog(
                            null, // Componente pai (null = janela principal)
                            "Importar um arquivo de:", // Mensagem de texto
                            "Futurólogo GAGO", // Título da janela
                            JOptionPane.DEFAULT_OPTION, // Tipo de opções (padrão)
                            JOptionPane.PLAIN_MESSAGE, // Tipo de ícone (nenhum ícone)
                            null, // Ícones customizados (não utilizado)
                            optionsCad, // Opções do menu
                            optionsCad[0] // Opção selecionada por padrão
                    );
                    switch (op) {
                        case 0:
                            Previsao.importarPrev(alPrev);
                            break;
                        case 1:
                            Vitima.importarVit(alVit);
                            break;
                        case 2:
                            break;
                    }
                    break;
                case 2:
                    Previsao.sortear(alVit, alPrev);
                    break;
                case 3:

                    break;
                case 4:
                    break;

            }
            // Previsao.listar(alPrev);
            // System.out.println();
            // Vitima.listar(alVit);
        }
    }
}