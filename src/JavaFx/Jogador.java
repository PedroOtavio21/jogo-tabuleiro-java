package JavaFx;

public abstract class Jogador {

    // Atributos
    protected String nome;
    protected String cor;
    protected String tipo;
    protected int posicao;
    protected int jogadas;
    protected boolean podeJogar = true;
    protected int rodadasSemJogar = 0;
    protected int posicaoEspecial;

    // Métodos
    public Jogador(String nome, String cor, String tipo, int posicao, int jogadas) {
        this.nome = nome;
        this.cor = cor;
        this.tipo = tipo;
        this.posicao = posicao;
        this.jogadas = jogadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getJogadas() {
        return jogadas;
    }

    public void setJogadas(int jogadas) {
        this.jogadas += jogadas;
    }

    public abstract int jogadarDados(Dado dado);

    public boolean verificaDadosIguais(int resultadoDadoUm, int resultadoDadoDois) {
        return resultadoDadoUm == resultadoDadoDois;
    }

    public void mover(int jogada) {
        this.posicao += jogada;
    }

    public boolean ganhou() {
        return this.getPosicao() >= 40;
    }

    public void setPodeJogar(boolean podeJogar) {
        this.podeJogar = podeJogar;
    }

    public boolean getPodeJogar() {
        return podeJogar;
    }

    public void podeJogar() {
        rodadasSemJogar++;
        if (rodadasSemJogar == 2) {
            this.setPodeJogar(true);
        }

    }

    public int getRodadasSemJogar() {
        return rodadasSemJogar;
    }

    public void setRodadasSemJogar(int rodadasSemJogar) {
        this.rodadasSemJogar = rodadasSemJogar;
    }

}
