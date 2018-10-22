package com.fernandopaniagua.psp_ejercicio2;

import javax.swing.JLabel;
import javax.swing.JSlider;

public class Cargador extends Thread {
    private JSlider slider;
    private JLabel label;
    
    public Cargador(JSlider _slider, JLabel _label){
        this.slider=_slider;
        this.label = _label;
    }
    
    @Override
    public void run() {
        while(this.slider.getValue()<this.slider.getMaximum()){
            int valorActual = this.slider.getValue();
            valorActual++;
            this.slider.setValue(valorActual);
            this.label.setText(String.valueOf(valorActual));
            try {
                sleep(16);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void esperaHilo(Cargador prioritario){
        try {
            prioritario.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
