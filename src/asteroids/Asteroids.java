package asteroids;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Asteroids extends Application {
    
    int turboNaveX=0;
    int turboNaveY=0;
    
    int posicionBalaY = 50;
    int posicionBalaX = 50;
    
    double naveSpeedY = 0;
    double naveSpeedX = 0;
    
    double absoluteSpeed =0;
    double balaVelocidadAbsoluta =1;
    
    double balaVelocidadX = 0;
    double balaVelocidadY = 0;
    
    double naveDireccionY = 0;
    double naveDireccionX = 0;
    
    int posicionNaveY =300;
    int posicionNaveX =400;
    
    double giroBala;
    double giroBalaRadianes;
    
    double naveGiro;
    double giroNaveRadianes;
    
    int centroNave;
    int anchoNave = 15;
    int velocidadGiro = 0;
    
    final int SCENE_TAM_X = 600;
    final int SCENE_TAM_Y = 800;
    
    
    Group nave;
    Circle bala = new Circle();
   
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        Scene scene = new Scene(root, SCENE_TAM_Y, SCENE_TAM_X);
        primaryStage.setTitle("asteroidspava");
        primaryStage.setScene(scene);
        primaryStage.show();
        nave = new Group();
        Polygon poligono = new Polygon();
        poligono.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -15.0, 20.0,
            15.0, 20.0 
        });
        poligono.setFill(Color.RED);
        Polygon grupoAsteroide = new Polygon();
        grupoAsteroide.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -15.0, 20.0,
            -15.0, 40.0,
            15.0, 20.0,
            30.0, 0.0 
        });
        grupoAsteroide.setFill(Color.BLACK);
        grupoAsteroide.setLayoutX(30);
        grupoAsteroide.setLayoutY(30);
        nave.setLayoutX(posicionNaveX);
        nave.setLayoutY(posicionNaveY);
        nave.getTransforms().add(new Rotate (90,00,0));
//        Circle propulsor = new Circle();
//        propulsor.setCenterX(10);
//        propulsor.setCenterY(30);
//        propulsor.setRadius(3);
//        propulsor.setFill(Color.RED);
//        root.getChildren().add(propulsor);
//        propulsor.setLayoutX(?);
//        propulsor.setLayoutY(?);
        nave.getChildren().addAll(poligono);
        root.getChildren().add(nave);
        root.getChildren().add(grupoAsteroide);
//        root.getChildren().add(propulsor);
        
        
        
        
        AnimationTimer animacionAsteroide = new AnimationTimer(){
            @Override
            public void handle(long now) {
                
                posicionNaveX+=naveSpeedX + turboNaveX;
                nave.setLayoutX(posicionNaveX);
                posicionNaveY+=naveSpeedY + turboNaveY;
                nave.setLayoutY(posicionNaveY);
                
                posicionBalaX+=balaVelocidadX;
                bala.setLayoutX(posicionBalaX);
                posicionBalaY+=balaVelocidadY;
                bala.setLayoutY(posicionBalaY);
                
                
                giroNaveRadianes=Math.toRadians(naveGiro);
                naveSpeedX=Math.cos(giroNaveRadianes)*absoluteSpeed;
                naveSpeedY=Math.sin(giroNaveRadianes)*absoluteSpeed;

                
                
                if(posicionNaveY<=0){
                    posicionNaveY = SCENE_TAM_X;
                }else{
                    if(posicionNaveY>=SCENE_TAM_X){
                        posicionNaveY = 0;
                    }
                }
                nave.setLayoutY(posicionNaveY);
                
                if(posicionNaveX<=0){
                    posicionNaveX = SCENE_TAM_Y;
                }else{
                    if(posicionNaveX>=SCENE_TAM_Y){
                        posicionNaveX = 0;
                    }
                }  
            }
            private void calculateBallSpeed(int collisionZone) {
                throw new UnsupportedOperationException(".");
            }
            
        };
        animacionAsteroide.start();
        
        scene.setOnKeyPressed((KeyEvent event)-> {
            switch(event.getCode()){
                case W:
                    absoluteSpeed+=1;
                    break;
                case S:
                    absoluteSpeed-=1;
                    break;
                case D:
                    naveGiro = naveGiro+5;
                    break;
                case A:
                    naveGiro = naveGiro-5;
                    break;
                case SPACE:
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
            nave.setRotate(naveGiro);
            bala.setRotate(naveGiro);
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch(event.getCode()){
            case W:
                absoluteSpeed-= 1;
                break;
            }
            
        });
         
    }  
}