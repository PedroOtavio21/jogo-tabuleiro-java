public class JogadorComun extends Jogador {

    // Metodos
    public JogadorComun(String nome, String cor, int posicao, int jogadas) {
        super(nome, cor, "comum", posicao, jogadas);
    }

    @Override
    public int jogadarDados(Dado dado) {
        int dadoUm = dado.rolarDado();
        int dadoDois = dado.rolarDado();
        if (podeJogar == true) {
            System.out.println("Dado 1 (" + dadoUm + ") - Dado 2 (" + dadoDois + ")");
            System.out.println("Soma dos dados: " + (dadoUm + dadoDois));
            return dadoUm + dadoDois;
        } else {
            System.out.println("Jogador não poderá jogar nesta rodada!");
            return 0;
        }

    }

}
