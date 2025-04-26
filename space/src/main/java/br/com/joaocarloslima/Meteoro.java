package br.com.joaocarloslima;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Meteoro extends Asset {
    private int tamanho;
    private int poder;
    public static final int TIPO_PEQUENO = 1;
    public static final int TIPO_MEDIO = 2;
    public static final int TIPO_GRANDE = 3;
    public static final int TIPO_GIGANTE = 4;

    // Construtor atual - define tamanho aleatório
    public Meteoro(double x, double y) {
        super((int)x, (int)y, 2, Direcao.BAIXO);
        this.tamanho = 1 + (int)(Math.random() * 4); // Agora limita a 4 tipos (1-4)
        this.poder = tamanho * 5; // O poder será proporcional ao tamanho
        carregarImagem();
    }
    
    // Novo construtor para criar meteoro com tipo específico
    public Meteoro(int x, int y, int velocidade, Direcao direcao, int tipo) {
        super(x, y, velocidade, direcao);
        this.tamanho = Math.min(Math.max(tipo, 1), 4); // Garante que o tipo esteja entre 1 e 4
        this.poder = tamanho * 5; // O poder será proporcional ao tamanho
        carregarImagem();
    }
    
    private void carregarImagem() {
        try {
            String path = "/br/com/joaocarloslima/images/meteoro/meteoro" + tamanho + ".png";
            this.imagem = new ImageView(new Image(
                Meteoro.class.getResource(path).toExternalForm()
            ));
            
            // Define o tamanho baseado no tipo de meteoro
            switch(tamanho) {
                case TIPO_PEQUENO: // Pequeno
                    imagem.setFitWidth(30);
                    imagem.setFitHeight(30);
                    break;
                case TIPO_MEDIO: // Médio
                    imagem.setFitWidth(40);
                    imagem.setFitHeight(40);
                    break;
                case TIPO_GRANDE: // Grande
                    imagem.setFitWidth(50);
                    imagem.setFitHeight(50);
                    break;
                case TIPO_GIGANTE: // Gigante
                    imagem.setFitWidth(60);
                    imagem.setFitHeight(60);
                    break;
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem do meteoro: " + e.getMessage());
            this.imagem = new ImageView(); // Fallback para uma imagem vazia
        }
    }

    @Override
    public void mover() {
        y += velocidade;
    }

    public void tomarTiro(Tiro tiro) {
        poder -= tiro.getPoder();
    }
    
    @Override
    public int getPoder() {
        return poder;
    }
    
    public int getTamanho() {
        return tamanho;
    }
}
