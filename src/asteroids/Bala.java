package asteroids;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Bala {
    int posicionBalaY = 50;
    int posicionBalaX = 50;
    
    double balaVelocidadX = 0;
    double balaVelocidadY = 0;
    
    double giroBala;
    double giroBalaRadianes;
    
    double absoluteSpeed =0;
    double balaVelocidadAbsoluta =1;
    
    Circle bala = new Circle();
    
    
    public Bala(){
        bala = new Circle();
        bala.setCenterX(10);
        bala.setCenterY(30);
        bala.setRadius(3);
        bala.setFill(Color.BLACK);
    }
    
    public void velocidadBala(){
        
        posicionBalaX+=balaVelocidadX;
        bala.setTranslateX(posicionBalaX);
        posicionBalaY+=balaVelocidadY;
        bala.setTranslateY(posicionBalaY);
    }

    
    
}