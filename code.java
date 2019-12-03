// ./tortuga.sh 256 256 0 code.java

static final int ANG = 1; //Cambiar angulo de distancia entre las líneas, siempre un valor
                          //divisible entre 90. [1, 2, 3, 5, 9, 10, 18, 30, 45, 90] 
static final double LONG = 100; //Longitud del radio del centro

public void vuelta(double dis){
    rotate(180);
    advance(dis);
    rotate(180);
}

public void pintaAngulo(double ang, double ad){
    rotate(ang);
    advanceAndPaint(ad);
    vuelta(ad);
}

public void recursiva(double ad, double tot, int ang){
    
    if(ad < 1){
        return;
    } else {
        
        
        /*Dibujo*/
        pintaAngulo(-90, ad); //90º


        /*CUADRANTE ARRIBA IZQUIERDA*/
        for(int i = 0; i < (90 / ang); i++){
            pintaAngulo(-ang, ad); 
        }
        
        pintaAngulo((90 + ang), ad); //Pinta angulo 85º
        

        /*CUADRANTE ARRIBA DERECHA*/
        for(int i = 0; i < (90 / ang) - 1; i++){
            pintaAngulo(ang, ad); 
        }
        
        /*Con el primer dibujo hecho apunta abajo*/
        rotate(90);

        /*Avanza la distancia del palo central para dibujar la parte de abajo*/
        advance(tot);
        advanceAndPaint(ad);
        vuelta(ad);
        
        /*CUADRANTE ABAJO IZQUIERDA*/
        for(int i = 0; i < (90 / ang); i++){
            pintaAngulo(ang, ad);  
        } 
        
        pintaAngulo(-(90 + ang), ad); //Pinta angulo -85º
        

        /*CUADRANTE ABAJO DERECHA*/
        for(int i = 0; i < (90 / ang) - 1; i++){
            pintaAngulo(-ang, ad); 
        } 
       
        /*Vuelta arriba*/
        rotate(-90);
        advance(tot + ad);
        rotate(90);           

        /*Longitud del palo central*/
        tot = tot + (ad * 2);
        recursiva(ad/2, tot, ang);
    }   
}

public void paint(){
    
    double sum = 0;

    recursiva(LONG, sum, ANG);
	
}
