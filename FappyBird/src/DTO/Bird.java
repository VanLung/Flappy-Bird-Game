/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import pkg2dgamesframework.Objects;

/**
 *
 * @author By Van Lung, IDStudent: SE140193
 */
public class Bird extends Objects {

    private float vt = 0;
    private boolean isFlying = false;

    public Bird(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    public void setVt(float vt) {
        this.vt = vt;
    }

    public void update(long deltaTime) {
        vt += FlappyBird.Gavity;

        this.setPosY(this.getPosY() + vt);
        //Vì vận tốc rơi có gia tốc g tốc độ thay đổi theo thời gian
        //Những khoàng di chuyển được thay đổi theo gia tốc.

        if (vt < 0) {
            isFlying = true;
        } else {
            isFlying = false;
        }
    }

    public void fly() {
        vt = -3;
    }

    public boolean isFlying() {
        return isFlying;
    }

}
