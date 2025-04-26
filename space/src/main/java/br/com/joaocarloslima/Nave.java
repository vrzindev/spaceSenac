package br.com.joaocarloslima;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Nave extends Asset {
    private int vida = 100; // Vida inicial da nave

    public Nave(double x, double y) {
        super((int)x, (int)y, 0, null);
        this.imagem = new ImageView(new Image(
            Nave.class.getResource("/br/com/joaocarloslima/images/ships/playerShip1_blue.png").toExternalForm()
        ));
    }

    public Nave(int x, int y, int velocidade, Direcao direcao) {
        super(x, y, velocidade, direcao);
        this.imagem = new ImageView(new Image(
            Nave.class.getResource("/br/com/joaocarloslima/images/ships/playerShip1_blue.png").toExternalForm()
        ));
    }
    
    @Override
    public void mover() {
        // Move de acordo com a direção e velocidade atuais
        if (direcao != null) {
            switch (direcao) {
                case CIMA: y -= velocidade; break;
                case BAIXO: y += velocidade; break;
                case ESQUERDA: x -= velocidade; break;
                case DIREITA: x += velocidade; break;
                default: break;
            }
        }
        
        // Evita que a nave saia dos limites da tela
        if (x < 0) x = 0;
        if (x > 640 - 50) x = 640 - 50;
    }

    public Tiro atirar(int poder) {
        // Ajusta a posição do tiro para que saia do centro da nave
        return new Tiro((int)(x + imagem.getFitWidth()/2), y, 10, Direcao.CIMA, poder);
    }
    
    public void moverHorizontal(double deltaX) {
        x += (int)deltaX;
        if (x < 0) x = 0;
        if (x > 640 - 50) x = 640 - 50;
    }
    
    // Novo método para lidar com colisões com meteoros
    public boolean tomarImpacto(Meteoro meteoro) {
        // Reduz a vida da nave baseado no poder do meteoro
        int dano = meteoro.getPoder();
        vida = Math.max(0, vida - dano); // Garante que a vida não fique negativa
        System.out.println("Nave atingida! Dano: " + dano + " | Vida restante: " + vida);
        return vida <= 0; // Retorna true se a nave for destruída
    }
    
    public int getVida() {
        return vida;
    }
    
    public void setVida(int vida) {
        this.vida = vida;
    }
}