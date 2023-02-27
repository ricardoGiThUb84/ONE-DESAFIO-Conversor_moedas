import br.dominio.CONVERSORES;
import br.entrada.JOPrompt;
import br.entrada.Prompt;
import br.entrada.Tela;
import br.exceptions.ConversorNaoInformadoException;
import br.exceptions.ValorInvalidoException;

public class SistemaConversor {

    public static void main(String[] args) {


        Prompt prompt = new JOPrompt();
        Tela tela = new Tela(prompt);

        String retornoPrompt = "";

        while (retornoPrompt != null) {

            retornoPrompt = tela.escolherConversor
                    (CONVERSORES.values(), "Conversor Universal", "Escolha um Conversor");

            if (encerramentoPrograma(tela, retornoPrompt, "Obrigado por usar o conversor universal!")) break;

            try {
                int desejaContinuar = 0;
                do {
                    final String resultadoConversao = tela.escolherConversao(retornoPrompt);

                    tela.mensagem(resultadoConversao);

                    desejaContinuar = tela.desejaContinuar("Deseja continuar?");

                    if (desejaContinuar == 1) {
                        retornoPrompt = null;
                        encerramentoPrograma(tela, retornoPrompt, "Programa cancelado!");
                    } else if (desejaContinuar == 2) {
                        retornoPrompt = null;
                        encerramentoPrograma(tela, retornoPrompt, "Programa finalizado!");
                    }

                } while (desejaContinuar == 0);

            } catch (ValorInvalidoException | ConversorNaoInformadoException e) {

                tela.mensagem(e.getMessage());
            }

        }
    }

    private static boolean encerramentoPrograma(Tela tela, String retornoPrompt, String mensagem) {
        if (retornoPrompt == null) {
            tela.mensagem(mensagem);
            return true;
        }
        return false;
    }


}
