package asteroids;

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
    
    Polygon formaNave = new Polygon();
            
    public Nave(){
               
        formaNave.setFill(Color.RED);
        formaNave.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -15.0, 20.0,
            15.0, 20.0 
        });
        
        
    }
    
    public void VelocidadNave(){
        posicionNaveX+=naveSpeedX + turboNaveX;
        formaNave.setTranslateX(posicionNaveX);
        
        posicionNaveY+=naveSpeedY + turboNaveY;
        formaNave.setTranslateY(posicionNaveY);
                        
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
    
    public void marchaAtras(){
        absoluteSpeed-=1;
    }
    
    public void derechaD(){
        naveGiro+= 10;
    }
    
    public void izquierdaA(){
        naveGiro -= 10;
    }
    
    public void posicionNave(){
        formaNave.setTranslateX(posicionNaveX);
        formaNave.setTranslateY(posicionNaveY);
        formaNave.getTransforms().add(new Rotate (90,00,0));
    }
    
    public void naveGiro(){
        formaNave.setRotate(naveGiro);
    }
    
    public void palabalaX(){
        posicionNaveX+=naveSpeedX + turboNaveX;
        formaNave.setTranslateX(posicionNaveX);
        
        giroNaveRadianes=Math.toRadians(naveGiro);
        naveSpeedX=Math.cos(giroNaveRadianes)*absoluteSpeed;
    }

}