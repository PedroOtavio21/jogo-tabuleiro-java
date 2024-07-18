public class JogadorAzarado extends Jogador {

    // Métodos
    public JogadorAzarado(String nome, String cor, int posicao, int jogadas) {
        super(nome, cor, "azarado", posicao, jogadas);
    }

    @Override
    public int jogadarDados(Dado dado) {
        int dadoUm = dado.rolarDado();
        int dadoDois = dado.rolarDado();
        // verificaDadosIguais(dadoUm, dadoDois);
        boolean podeJogar = PodeJogar((dadoUm + dadoDois));

        if (podeJogar == false) {
            System.out.println("Dado 1 (" + dadoUm + ") - Dado 2 (" + dadoDois + ")");
            System.out.println("Rolando os dados novamente");
            dadoUm = dado.rolarDado();
            dadoDois = dado.rolarDado();
            podeJogar = PodeJogar((dadoUm + dadoDois));
            if (podeJogar == false) {
                System.out.println("Dado 1 (" + dadoUm + ") - Dado 2 (" + dadoDois + ")");
                System.out.println("Passando a vez");
                return -1;
            } else {
                System.out.println("Dado 1 (" + dadoUm + ") - Dado 2 (" + dadoDois + ")");
                System.out.println("Soma dos dados: " + (dadoUm + dadoDois));
                return dadoUm + dadoDois;
            }
        } else {
            System.out.println("Dado 1 (" + dadoUm + ") - Dado 2 (" + dadoDois + ")");
            System.out.println("Soma dos dados: " + (dadoUm + dadoDois));
            return dadoUm + dadoDois;
        }
    }

    public boolean PodeJogar(int somaDosDados) {
        if (podeJogar == true) {
            if (somaDosDados > 6) {
                System.out.println("Soma dos dados: " + somaDosDados);
                System.out.println("Valor dos dados maior que 6");
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("Jogador não pode jogar nessa rodada");
            return false;
        }
    }
}
