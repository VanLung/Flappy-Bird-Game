/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import pkg2dgamesframework.QueueList;

/**
 *
 * @author By Van Lung, IDStudent: SE140193
 */
public class ChimneyGroup {

    private QueueList<Chimney> chimneys;
    private BufferedImage chimneyImage;

    public ChimneyGroup() {
        Chimney cn;
        try {

            chimneyImage = ImageIO.read(new File("Assets/chimney.png"));

        } catch (IOException ex) {
        }
        for (int i = 0; i < 6; i++) {
            cn = new Chimney(830, 350, 74, 400);
            chimneys.push(cn);
            cn = new Chimney(830, -300, 74, 400);
        }
    }

    public void update() {
        for (int i = 0; i < 6; i++) {
            chimneys.get(i).update();
        }
    }

    public void paint(Graphics2D g2) {
        for (int i = 0; i < 6; i++) {
            g2.drawImage(chimneyImage, (int) chimneys.get(i).getPosX(), (int) chimneys.get(i).getPosY(),null);
        }
    }
}
