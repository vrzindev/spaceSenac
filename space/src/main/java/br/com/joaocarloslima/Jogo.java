package br.com.joaocarloslima;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jogo {
    public List<Asset> assets = new ArrayList<>();
    public Nave nave;
    private int pontos = 0;
    private int nivel = 1;
    private int poderLaser = 1; // Poder inicial do laser

    public Jogo() {
        nave = new Nave(280, 400);
        assets.add(nave);
    }
    
    public Tiro atirar(int poder) {
        // Usa o poder do laser baseado no nível atual
        Tiro tiro = nave.atirar(poderLaser);
        assets.add(tiro);
        return tiro;
    }
    
    public Meteoro criarMeteoro() {
        double x = Math.random() * (640 - 50);
        Meteoro meteoro = new Meteoro(x, 0);
        assets.add(meteoro);
        return meteoro;
    }
    
    public void pontuar() {
        pontos++;
        // A cada 10 pontos, aumenta o nível e o poder do laser
        if (pontos % 10 == 0 && nivel < 4) {
            nivel++;
            poderLaser = nivel; // O poder do laser será igual ao nível
            System.out.println("Nível aumentou para: " + nivel + " | Poder do Laser: " + poderLaser);
        }
    }
    
    // Método para perder pontos quando a nave colide com meteoro
    public boolean perderPontos(int pontosPerdidos) {
        pontos = Math.max(0, pontos - pontosPerdidos);
        
        // Ajusta o nível baseado nos pontos atuais
        nivel = 1 + (pontos / 10);
        nivel = Math.min(4, nivel); // Garante que o nível não ultrapasse 4
        poderLaser = nivel; // Atualiza o poder do laser
        
        System.out.println("Nave atingida! Perdeu " + pontosPerdidos + " pontos | Pontos restantes: " + pontos);
        
        return pontos <= 0; // Retorna true se o jogador ficou com 0 pontos
    }
    
    public int getPontos() {
        return pontos;
    }
    
    public int getNivel() {
        return nivel;
    }
    
    public int getPoderLaser() {
        return poderLaser;
    }
}
