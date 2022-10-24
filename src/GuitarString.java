
import java.util.LinkedList;
import java.util.Queue;

/**
 * Esta clase implementa . . . (Ponemos una explicacion a grandes
 * rasgos de lo que hace el programa y cuales son las condiciones
 * para que funcione.
 *
 * @autores Gabriel Santiago Robles Robles.
 *          Victor Hugo Ramirez Rios.
 *          Gustavo Gutierrez Navarro.
 */

public class GuitarString {

    Queue<Double> circularBuffer = new LinkedList<>(); // ¿La ponemos privada?
    public final double DECAYCONSTANT = 0.996; 
    
    // ¿Ponemos una descrpcion del constructor? 
    public GuitarString(double frequency){
        if(frequency <= 0){
            throw new IllegalArgumentException("El valor de la frecuencia es invalido, por favor ingrese un numero mayor a 0.");
        }
        int bufferSize = (int) Math.round(StdAudio.SAMPLE_RATE / frequency);
        if(bufferSize < 2){
            throw new IllegalArgumentException("El valor de la frecuencia es muy grande, por favor intente con un numero mas pequeño.");
        }
        for(int i = 0; i < bufferSize; i++){
            circularBuffer.add(0.0);
        }
    }
    
    // ¿Ponemos una descrpcion del constructor? 
    public GuitarString(double[] init){
        if(init.length < 2){
            throw new IllegalArgumentException("El numero de componentes es muy pequeño, por favor asegurese de mandar por lo menos 2 elementos.");
        }
        for(double value : init){ // value representa el desplazamiento de una cuerda con valor entre -0.5 y 0.5.
            circularBuffer.add(value);
        }
    }
    
    public void pluck() {
        double randomValue;
		for(int i = 0; i < circularBuffer.size(); i++){
			randomValue = Math.random() * (1.4999999) - 0.5; // Valor aleatorio entre [-0.5, 0.5) 
			circularBuffer.remove();
			circularBuffer.add(randomValue);
		} 
    }
    
    public void tic(){
        double firstValue = circularBuffer.remove();
        double secondValue = circularBuffer.peek();
        circularBuffer.add((firstValue + secondValue)/2 * DECAYCONSTANT);
    }
    
    public double sample(){
        return circularBuffer.peek();
    }
}
