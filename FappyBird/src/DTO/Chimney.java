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
public class Chimney extends Objects {
    
    public Chimney(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void update() {
        setPosX(getPosX() - 2);
    }
    
}
