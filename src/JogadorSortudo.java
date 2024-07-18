public class JogadorSortudo extends Jogador {

    // Métodos
    public JogadorSortudo(String nome, String cor, int posicao, int jogadas) {
        super(nome, cor, "sortudo", posicao, jogadas);
    }

    @Override
    public int jogadarDados(Dado dado) {
        int dadoUm = dado.rolarDado();
        int dadoDois = dado.rolarDado();
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
            if (somaDosDados < 7) {
                System.out.println("Soma dos dados: " + somaDosDados);
                System.out.println("Valor dos dados menor que 7");
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("Jogador não poderá jogar nesta rodada!");
            return false;
        }
    }
}
