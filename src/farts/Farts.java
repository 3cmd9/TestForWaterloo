/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author 
 */
public class Farts {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.lang.InterruptedException
     */
    public static void main(String args[]) throws FileNotFoundException, IOException, InterruptedException {
        String path = "music.wav";
        InputStream in = new FileInputStream(path);
        AudioStream audio = new AudioStream(in);
        AudioPlayer.player.start(audio);
        

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FartsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FartsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FartsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FartsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            FartsGui one = new FartsGui();
            FartGuiTwo two = new FartGuiTwo();
            FartGuiThree three = new FartGuiThree();
            FartGuiFour four = new FartGuiFour();
            Timer timer = new Timer();
            timer.schedule(new scheduleOne(one, two, three, four, timer), 0);
            timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    AudioPlayer.player.stop(in);
                    System.exit(0);
                }
            }, 59000);
             
            
        });
    }
    

    private static class scheduleOne extends TimerTask {
        private Timer timer;
        private FartsGui one;
        private FartGuiTwo two;
        private FartGuiThree three;
        private FartGuiFour four;

        public scheduleOne(FartsGui one, FartGuiTwo two, FartGuiThree three, FartGuiFour four, Timer timer) {
            this.one = one;
            this.two = two;
            this.timer = timer;
            this.three = three;
            this.four = four;
        }

        @Override
        public void run() {
            one.setVisible(true);
            four.setVisible(false);
            timer.schedule(new scheduleTwo(one, two, three, four, timer), 2000);
        }

    }

    private static class scheduleTwo extends TimerTask {
        private Timer timer;
        private FartsGui one;
        private FartGuiTwo two;
        private FartGuiThree three;
        private FartGuiFour four;

        public scheduleTwo(FartsGui one, FartGuiTwo two, FartGuiThree three, FartGuiFour four, Timer timer) {
            this.timer = timer;
            this.one = one;
            this.two = two;
            this.three = three;
            this.four = four;
        }

        @Override
        public void run() {
            two.setVisible(true);
            one.setVisible(false);
            timer.schedule(new scheduleThree(one, two, three, four, timer), 2000);
        }

    }
    private static class scheduleThree extends TimerTask {
        private Timer timer;
        private FartsGui one;
        private FartGuiTwo two;
        private FartGuiThree three;
        private FartGuiFour four;

        public scheduleThree(FartsGui one, FartGuiTwo two, FartGuiThree three, FartGuiFour four, Timer timer) {
            this.timer = timer;
            this.one = one;
            this.two = two;
            this.three = three;
            this.four = four;
        }

        @Override
        public void run() {
            three.setVisible(true);
            two.setVisible(false);
            timer.schedule(new scheduleFour(one, two, three, four, timer), 2000);
        }

    }
    private static class scheduleFour extends TimerTask {
        private Timer timer;
        private FartsGui one;
        private FartGuiTwo two;
        private FartGuiThree three;
        private FartGuiFour four;

        public scheduleFour(FartsGui one, FartGuiTwo two, FartGuiThree three, FartGuiFour four, Timer timer) {
            this.timer = timer;
            this.one = one;
            this.two = two;
            this.three = three;
            this.four = four;
        }

        @Override
        public void run() {
            four.setVisible(true);
            three.setVisible(false);
            timer.schedule(new scheduleOne(one, two, three, four, timer), 2000);
        }

    }

}
