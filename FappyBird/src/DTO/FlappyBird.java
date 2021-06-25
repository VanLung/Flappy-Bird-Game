/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import pkg2dgamesframework.AFrameOnImage;
import pkg2dgamesframework.Animation;
import pkg2dgamesframework.GameScreen;

/**
 *
 * @author By Van Lung, IDStudent: SE140193
 */
public class FlappyBird extends GameScreen {

    private BufferedImage bird;
    private Animation birdAnimation;

    private BufferedImage chimney;
    private Chimney cnObject;

    private Bird birds;
    private Ground ground;

    private int BEGIN_SCREEN = 0;
    private int GAMEPLAY_SCREEN = 1;
    private int GAMEOVER_SCREEN = 2;

    private int currentScreen = BEGIN_SCREEN;

    public static float Gavity = 0.1f; //biến gia tốc (g=9,8m/s2)

    public FlappyBird() { //contructor
        super(800, 600); //khoi tao kich thuoc cua cua so
        try {
            bird = ImageIO.read(new File("Assets/bird_sprite.png"));
            chimney = ImageIO.read(new File("Assets/chimney.png"));
        } catch (IOException ex) {
        }

        birdAnimation = new Animation(100);

        AFrameOnImage f;
        f = new AFrameOnImage(0, 0, 60, 60); //từ 0 lên 60 lên 120 xuống 60 giúp hiệu ứng chân thật hơn
        birdAnimation.AddFrame(f);
        f = new AFrameOnImage(60, 0, 60, 60);
        birdAnimation.AddFrame(f);
        f = new AFrameOnImage(120, 0, 60, 60);
        birdAnimation.AddFrame(f);
        f = new AFrameOnImage(60, 0, 60, 60);
        birdAnimation.AddFrame(f);

        birds = new Bird(350, 250, 50, 50);

        ground = new Ground();
        cnObject = new Chimney(700, 300, 74, 400);

        BeginGame();
    }

    @Override
    public void GAME_UPDATE(long deltaTime) {

        if (currentScreen == BEGIN_SCREEN) {
            resetGame();
        } else if (currentScreen == GAMEPLAY_SCREEN) {

            birdAnimation.Update_Me(deltaTime);
            birds.update(deltaTime);
            ground.update();
            cnObject.update();

            if (birds.getPosY() + birds.getH() > ground.getYGround()) {
                currentScreen = GAMEOVER_SCREEN;
            }

        } else {

        }

    }

    @Override
    public void GAME_PAINT(Graphics2D g2) {
        g2.drawImage(chimney, (int) cnObject.getPosX(), (int) cnObject.getPosY(), this);

        ground.paint(g2);

        if (birds.isFlying()) {
            birdAnimation.PaintAnims((int) birds.getPosX(), (int) birds.getPosY(), bird, g2, 0, -1);
        } else {
            birdAnimation.PaintAnims((int) birds.getPosX(), (int) birds.getPosY(), bird, g2, 0, 0);
        }

        if (currentScreen == BEGIN_SCREEN) {
            g2.setColor(Color.red);
            g2.drawString("Press space to play game", 200, 300);
        }
        if (currentScreen == GAMEOVER_SCREEN) {
            g2.setColor(Color.red);
            g2.drawString("Press space to turn back begin screen", 200, 300);
        }
    }

    @Override
    public void KEY_ACTION(KeyEvent e, int Event
    ) {
        if (Event == KEY_PRESSED) {
            if (currentScreen == BEGIN_SCREEN) {
                currentScreen = GAMEPLAY_SCREEN;
            } else if (currentScreen == GAMEPLAY_SCREEN) {
                birds.fly();

            } else if (currentScreen == GAMEOVER_SCREEN) {
                currentScreen = BEGIN_SCREEN;
            }

        }

    }

    public static void main(String[] args) {
        new FlappyBird();
    }

    private void resetGame() {
        birds.setPos(350, 250);
    }

}
