package edu.cmu.hcii.paint;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaintWindow(800, 600);
            }
        });
    }
}
