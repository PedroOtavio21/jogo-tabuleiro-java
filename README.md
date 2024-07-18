# jogo-tabuleiro-maven-npc
Projeto destinado à primeira nota do npc1, pela disciplina de POO na Universidade Estadual do Ceará

## Equipe
- Pedro Otávio
- Victor Farias

## Descrição do Projeto
Crie um jogo de computador que simule um jogo de tabuleiro. Seu jogo deve permitir até 6 participantes ao mesmo tempo. 
O tabuleiro tem 40 casas. Cada jogador possui uma cor que o identifica e sabe qual sua posição no tabuleiro. 
Cada movimento de um competidor é determinado por dois dados: o competidor andará o número de casas igual à soma dos 
valores dos dois dados.

Existem 3 tipos de jogador:
- Jogador com sorte, cuja soma dos valores dos dados é sempre maior ou igual à 7;
- Jogador azarado, cuja soma dos valores dos dados é sempre menor ou igual a 6;
- Jogador normal, que pode obter tanto valores altos como baixos para a soma dos dados.

### O tabuleiro tem algumas casas especiais:
- Casas 10, 25, 38: se o competidor parar em uma dessas casas, ele não joga a próxima rodada;
- Casa 13: casa surpresa, o jogador deve tirar uma carta aleatória que o fará mudar de tipo de jogador conforme a carta.
- Casas 5, 15 e 30: casas da sorte: ande 3 casas para frente desde que ele não seja um jogador azarado;
- Casas 17 e 27: se o competidor parar em uma dessas casas, ele escolhe um competidor para voltar para o início do jogo.
- Casas 20 e 35: casas mágicas: se o competidor parar em uma delas, ele troca de lugar com o jogador que está mais atrás 
no jogo. Caso ele seja o último, ele não sai do lugar.
- Caso o competidor tire dois resultados iguais nos dados, ele anda a quantidade de casas correspondentes e ganha o 
direito de jogar novamente (respeitando as regras acima).

### Requisitos:
- Cada competidor começa da casa 0.
- O jogo tem que ter pelo menos dois jogadores de tipos diferentes, mas pode haver dois ou mais jogadores do mesmo tipo.
- Permita que o usuário escolha os jogadores da rodada.
- Ganha o competidor que chegar primeiro na casa 40 (ou passar dela).
- A cada rodada você deve mostrar a posição de cada jogador no tabuleiro 
(ex: azul na casa 2, verde na casa 6, amarelo na casa 15, branco na casa 18) e de quem é a vez para jogar.
- Após jogar os dados, você deve mostrar o valor da soma dos dados.
- Se um jogador cair em uma das casas ou condições acima, mostrar uma mensagem indicando.
- Você tem que mostrar o vencedor.
- Você deve mostrar a quantidade de jogadas de cada jogador ao final do jogo e a posição de cada um.
- Você deve usar herança e polimorfismo no seu jogo.

### Desafio:
- Use a interface gráfica (Swing ou JavaFX) para tornar seu jogo mais agradável!

## Todo
- [x] Implementar classes base do jogo (Jogador, Tabuleiro, Dado).
- [x] Implementar lógica para tipos de jogadores (sorte, azarado, normal).
- [x] Implementar lógica de movimento dos jogadores no tabuleiro.
- [x] Implementar casas especiais com suas respectivas regras.
- [x] Implementar interação de jogadas (rolar dados, movimentar jogador).
- [x] Implementar exibição do estado do jogo (posições dos jogadores, jogadas).
- [x] Implementar condição de vitória e exibição do vencedor.
- [x] Implementar contagem e exibição de jogadas por jogador ao final do jogo.
- [ ] Implementar interface gráfica (Swing ou JavaFX).

## Boas Práticas de Uso do Git para Colaboração
1. **Criar Branches para Cada Tarefa:**
  - Crie uma nova branch para cada funcionalidade ou correção de bug (`git checkout -b nome-da-branch`).

2. **Commits Pequenos e Frequentes:**
  - Faça commits pequenos e frequentes com mensagens descritivas do que foi feito (`git commit -m "Mensagem descritiva"`).

3. **Mensagens de Commit Claras:**
  - Utilize mensagens de commit claras e objetivas. Exemplo: `git commit -m "Implementa lógica de movimento dos jogadores"`.

4. **Pull Requests:**
  - Abra pull requests para revisões de código antes de mesclar as mudanças na branch principal (`main`). Utilize a funcionalidade de pull request do GitHub para facilitar a revisão.

5. **Revisão de Código:**
  - Revise o código dos colegas antes de aprovar o pull request. Procure por bugs, melhorias e conformidade com os padrões de código.

6. **Manter o Repositório Atualizado:**
  - Sempre puxe as mudanças mais recentes da branch principal antes de iniciar uma nova tarefa (`git pull origin main`).

7. **Resolução de Conflitos:**
  - Resolva conflitos de merge de forma colaborativa, discutindo com os colegas para entender o contexto das mudanças.

8. **Documentação:**
  - Atualize a documentação do projeto conforme necessário. Isso inclui o README, comentários no código e qualquer outra documentação relevante.
