package com.fernandopaniagua.psp_ejercicio2;

import javax.swing.JLabel;
import javax.swing.JSlider;

public class Cargador extends Thread {

    private JSlider slider;
    private JLabel label;
    private Cargador prioritario=null;

    public Cargador(JSlider _slider, JLabel _label) {
        this.slider = _slider;
        this.label = _label;
    }

    @Override
    public void run() {
        while (this.slider.getValue() < this.slider.getMaximum()) {
            int valorActual = this.slider.getValue();
            valorActual++;
            this.slider.setValue(valorActual);
            this.label.setText(String.valueOf(valorActual));
            try {
                sleep(16);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            if (prioritario!=null) {
                try {
                    prioritario.join();
                    prioritario=null;
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public void setHiloAEsperar(Cargador _prioritario) {
        this.prioritario = _prioritario;
    }
}
