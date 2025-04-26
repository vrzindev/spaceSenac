package br.com.joaocarloslima;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tiro extends Asset {
    private int poder;

    public Tiro(int x, int y, int velocidade, Direcao direcao, int poder) {
        super(x, y, velocidade, direcao);
        this.poder = poder;
        String path = "images/laser/laser" + poder + ".png";
        try {
            if (App.class.getResource(path) == null) {
                throw new Exception("Recurso não encontrado: " + path);
            }
            this.imagem = new ImageView(App.class.getResource(path).toString());
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem: " + e.getMessage());
            this.imagem = new ImageView();
        }
    }

    @Override
    public void mover() {
        switch (direcao) {
            case CIMA: y -= velocidade; break;
            case BAIXO: y += velocidade; break;
            case ESQUERDA: x -= velocidade; break;
            case DIREITA: x += velocidade; break;
            default: break;
        }
    }

    @Override
    public int getPoder() {
        return poder;
    }
}
