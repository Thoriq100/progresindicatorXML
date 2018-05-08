/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progressbar;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Toriq
 */
public class Progressbar extends Application {
    int progress=0;
    @Override
    public void start(Stage stage) throws Exception {
        RingProgressIndicator ring = new RingProgressIndicator();
        ring.setRingWidth(200);
        ring.makeIndeterminate();
       StackPane root = new StackPane(); 
        root.getChildren().add(ring);
        Scene scene = new Scene(root,300,250);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        new workThread(ring).start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
     class workThread extends Thread{
        RingProgressIndicator rpi;
        public workThread(RingProgressIndicator rpi){
            this.rpi=rpi;
        }
        @Override
        public void run(){
            while(true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                   
                }
                
                
                Platform.runLater(()->{
                
                rpi.setProgress(progress);
                
                });
                
                
                progress+=1;
                if(progress>100){
                    break;
                }
            }
        }
    
}
}
