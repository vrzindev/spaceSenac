package br.com.joaocarloslima;

import javafx.scene.image.ImageView;

public abstract class Asset {
    // Alterado para int
    protected int x, y, velocidade;
    protected Direcao direcao;
    protected ImageView imagem;
    
    // Construtor atualizado para int
    public Asset(int x, int y, int velocidade, Direcao direcao) {
        this.x = x;
        this.y = y;
        this.velocidade = velocidade;
        this.direcao = direcao;
    }

    public abstract void mover();

    // Retorna a largura do asset. Se a imagem estiver definida, utiliza seu valor; caso contrário, usa 50.
    public double getLargura() {
        return imagem != null && imagem.getFitWidth() > 0 ? imagem.getFitWidth() : 50;
    }
    
    // Retorna a altura do asset. Se a imagem estiver definida, utiliza seu valor; caso contrário, usa 50.
    public double getAltura() {
        return imagem != null && imagem.getFitHeight() > 0 ? imagem.getFitHeight() : 50;
    }

    // Método colidiuCom utilizando hitbox fixa 50x50 e verificação asset nulo
    public boolean colidiuCom(Asset asset) {
        if (asset == null) return false;
        return x < asset.getX() + 50 &&
               x + 50 > asset.getX() &&
               y < asset.getY() + 50 &&
               y + 50 > asset.getY();

               
    }
    
    // Getters e Setters para todos os atributos
    public int getX() { return x; }
    public int getY() { return y; }
    public int getVelocidade() { return velocidade; }
    public Direcao getDirecao() { return direcao; }
    public ImageView getImagem() { return imagem; }
    
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setVelocidade(int velocidade) { this.velocidade = velocidade; }
    public void setDirecao(Direcao direcao) { this.direcao = direcao; }
    public void setImagem(ImageView imagem) { this.imagem = imagem; }
    
    public int getPoder() {
        return 0; // Para ser sobrescrito se necessário
    }
}
