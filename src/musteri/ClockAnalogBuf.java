/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musteri;

// File   : GUI-lowlevel/animation/analogclock/ClockAnalogBuf.java
// Purpose: An applet/application which displays our clock component.
// Tag    : <applet code="ClockAnalogBuf.class" height="300" width="300"/>
// Author : Fred Swartz, 1999-2007, Placed in public domain.

import java.awt.*;
import javax.swing.*;

///////////////////////////////////////////////////////////// ClockAnalogBuf
public class ClockAnalogBuf extends JApplet {
    
    //=============================================================== fields
    private Clock _clock;                        // Our clock component.
    
    //================================================================= main
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Analog Clock");
        window.setContentPane(new ClockAnalogBuf());
        window.pack();                          // Layout components
        window.setLocationRelativeTo(null);     // Center window.
        window.setVisible(true);
    }
    
    //========================================================== constructor
    public ClockAnalogBuf() {
        //... Create an instance of our new clock component.
        _clock = new Clock();
        
        //... Set the applet's layout and add the clock to it.
        setLayout(new BorderLayout());
        add(_clock, BorderLayout.CENTER);
        
        //... Start the clock running.
        start(); 
    }
    
    //=============================================================== start
    @Override public void start() {
        _clock.start();
    }
    
    //================================================================ stop
    @Override public void stop() {
        _clock.stop();
    }
}