package asteroids;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Asteroids extends Application {
    
    int turboNaveX=0;
    int turboNaveY=0;
    
    int posicionBalaY = 50;
    int posicionBalaX = 50;
    
//    double naveSpeedY = 0;
//    double naveSpeedX = 0;
    
    double absoluteSpeed =0;
    double balaVelocidadAbsoluta =1;
    
    double balaVelocidadX = 0;
    double balaVelocidadY = 0;
    
//    double naveDireccionY = 0;
//    double naveDireccionX = 0;
    
    int posicionNaveY =300;
    int posicionNaveX =400;
    
    double giroBala;
    double giroBalaRadianes;
    
    double naveGiro;
    double giroNaveRadianes;
    
//    int centroNave;
//    int anchoNave = 15;
//    int velocidadGiro = 0;
   
    final int SCENE_TAM_X = 600;
    final int SCENE_TAM_Y = 800;
    
    
    
    Circle bala = new Circle();
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        Scene scene = new Scene(root, SCENE_TAM_Y, SCENE_TAM_X);
        primaryStage.setTitle("asteroidspava");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Nave nave1 = new Nave();

//        Polygon grupoAsteroide = new Polygon();
//        grupoAsteroide.getPoints().addAll(new Double[]{
//            0.0, -20.0,
//            -15.0, 20.0,
//            -15.0, 40.0,
//            15.0, 20.0,
//            30.0, 0.0 
//        });
//        grupoAsteroide.setFill(Color.BLACK);
//        grupoAsteroide.setLayoutX(400);
//        grupoAsteroide.setLayoutY(400);
        nave1.posicionNave();
//        Circle propulsor = new Circle();
//        propulsor.setCenterX(10);
//        propulsor.setCenterY(30);
//        propulsor.setRadius(3);
//        propulsor.setFill(Color.RED);
//        root.getChildren().add(propulsor);
//        propulsor.setLayoutX(?);
//        propulsor.setLayoutY(?);
        root.getChildren().add(nave1.formaNave);
//        root.getChildren().add(grupoAsteroide);
//        root.getChildren().add(propulsor);
        
        AnimationTimer animacionAsteroide = new AnimationTimer(){
            @Override
            public void handle(long now) {
                
                nave1.VelocidadNave();

                posicionBalaX+=balaVelocidadX;
                bala.setTranslateX(posicionBalaX);
                posicionBalaY+=balaVelocidadY;
                bala.setTranslateY(posicionBalaY);
            }
            
        };
        animacionAsteroide.start();
        
        scene.setOnKeyPressed((KeyEvent event)-> {
            switch(event.getCode()){
                case W:
                    nave1.acelerar();
                    break;
                case S:
                    nave1.marchaAtras();
                    break;
                case D:
                    nave1.derechaD();
                    break;
                case A:
                    nave1.izquierdaA();
                    break;
                case SPACE:
                    Bala bala = new Bala(nave1.posicionNaveX, posicionNaveY);
                    bala = new Circle();
                    bala.setCenterX(10);
                    bala.setCenterY(30);
                    bala.setRadius(3);
                    bala.setFill(Color.BLACK);
                    root.getChildren().add(bala);
                    posicionBalaX=posicionNaveX;
                    posicionBalaY=posicionNaveY;
                    balaVelocidadAbsoluta=5;
                    balaVelocidadAbsoluta+=1;
                    balaVelocidadX=Math.cos(giroNaveRadianes)*balaVelocidadAbsoluta;
                    balaVelocidadY=Math.sin(giroNaveRadianes)*balaVelocidadAbsoluta;
                    break;
                }
            nave1.naveGiro();
            bala.setRotate(naveGiro);
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch(event.getCode()){
            case W:
                nave1.marchaAtras();
                break;
            }
            
        });
         
    }  
}