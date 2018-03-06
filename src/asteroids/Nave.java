package asteroids;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;


public class Nave {
    
    int turboNaveX=0;
    int turboNaveY=0;
    
    double naveSpeedY = 0;
    double naveSpeedX = 0;
    
    double absoluteSpeed =0;
    
    double naveDireccionY = 0;
    double naveDireccionX = 0;
        
    public int posicionNaveY =300;
    public int posicionNaveX =400;
    
    double naveGiro;
    double giroNaveRadianes;
        
    int centroNave;
    int anchoNave = 15;
    int velocidadGiro = 0;
    
    final int SCENE_TAM_X = 600;
    final int SCENE_TAM_Y = 800;
    
    Group formaNave;
    
    public Nave(){
        
       
        formaNave = new Group();
        Polygon poligono = new Polygon();
        poligono.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -15.0, 20.0,
            15.0, 20.0 
        });
        poligono.setFill(Color.RED);
        
    }
    
    public void VelocidadNave(){
        posicionNaveX+=naveSpeedX + turboNaveX;
        formaNave.setLayoutX(posicionNaveX);
        posicionNaveY+=naveSpeedY + turboNaveY;
        formaNave.setLayoutY(posicionNaveY);
                        
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
        formaNave.setLayoutY(posicionNaveY);

        if(posicionNaveX<=0){
            posicionNaveX = SCENE_TAM_Y;
            }else{
        if(posicionNaveX>=SCENE_TAM_Y){
            posicionNaveX = 0;
            }
        }          
    }
    
    public void acelerar(){
        absoluteSpeed+=1;
        
    }
    public void posicionNave(){
        formaNave.setLayoutX(posicionNaveX);
        formaNave.setLayoutY(posicionNaveY);
        formaNave.getTransforms().add(new Rotate (90,00,0));
    }
    public void naveGiro(){
        formaNave.setRotate(naveGiro);
    }

}