# Space Game

## Descrição
Space Game é um jogo de nave espacial desenvolvido em JavaFX onde o jogador controla uma nave para destruir meteoros e acumular pontos. À medida que o jogador avança, o nível aumenta e o poder do laser da nave também se intensifica.

## Como Jogar
- Use as setas **← →** para mover a nave horizontalmente
- Pressione **Espaço** para atirar
- Destrua meteoros para ganhar pontos
- Evite colisões com meteoros para não perder pontos

## Características
- **4 níveis de dificuldade** - o jogo fica mais desafiador à medida que você avança
- **4 tipos de meteoros** com diferentes tamanhos e poderes
- **Laser progressivo** - o poder do seu laser aumenta com o seu nível
- **Sistema de pontuação** dinâmico

## Regras
1. A cada meteoro destruído, você ganha 1 ponto
2. A cada 10 pontos, seu nível aumenta (até o máximo de 4)
3. Se um meteoro colidir com sua nave, você perde pontos baseado no poder do meteoro
4. Seu nível diminui se você perder pontos suficientes
5. O jogo termina quando sua pontuação chega a zero

## Classes Principais
- **Asset**: Classe abstrata base para todos os elementos visuais do jogo
- **Nave**: Elemento controlado pelo jogador
- **Meteoro**: Obstáculos que caem do céu em 4 tamanhos diferentes
- **Tiro**: Projéteis disparados pela nave
- **Jogo**: Controla as regras e estado do jogo
- **Controller**: Gerencia a interface gráfica e interações do usuário

## Requisitos do Sistema
- Java 11 ou superior
- JavaFX 13 ou superior
- Maven

## Como Executar
1. Clone o repositório:
   ```
   git clone https://github.com/seu-usuario/space-game.git
   ```
2. Navegue até a pasta do projeto:
   ```
   cd space-game
   ```
3. Execute o jogo:
   ```
   mvn clean javafx:run
   ```

## Controles
- **←**: Move a nave para a esquerda
- **→**: Move a nave para a direita
- **Espaço**: Dispara o laser

## Estrutura do Código
```
src/
├── main/
│   ├── java/
│   │   └── br/
│   │       └── com/
│   │           └── joaocarloslima/
│   │               ├── App.java
│   │               ├── Asset.java
│   │               ├── Controller.java
│   │               ├── Direcao.java
│   │               ├── Jogo.java
│   │               ├── Meteoro.java
│   │               ├── Nave.java
│   │               └── Tiro.java
│   └── resources/
│       └── br/
│           └── com/
│               └── joaocarloslima/
│                   ├── images/
│                   │   ├── laser/
│                   │   ├── meteoro/
│                   │   └── ships/
│                   └── primary.fxml
```

## Créditos
Desenvolvido como projeto educacional para praticar conceitos de programação orientada a objetos e desenvolvimento de jogos com JavaFX.

## Licença
Este projeto é disponibilizado sob a licença MIT.
