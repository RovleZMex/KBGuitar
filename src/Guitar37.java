// skeleton version of the class

public class Guitar37 implements Guitar {
    public static final String KEYBOARD_US =
            "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // US keyboard layout
    private static final String KEYBOARD_SP =
            "q2we4r5ty7u8i9op'`¡zxdcfvgbnjmk,.ñ-´ ";  // SP keyboard layout

    private final GuitarString[] guitarStrings = new GuitarString[37];

    public Guitar37(){
        for(int i = 0; i < 37; i++){
            double frequency = 440 * Math.pow(2,((double)i-24)/12);
            guitarStrings[i] = new GuitarString(frequency);
        }
    }

    public void playNote(int pitch){
        try {
            guitarStrings[pitch+24].pluck();
        }catch(Exception e){
            System.out.println("Pitch out of bounds");
        }
    }

    public boolean hasString(char key){
        return true;
    }

    public void pluck(char key){

    }

    public double sample(){
        return 37.0;
    }

    public void tic(){

    }

    public int time(){
        return 1;
    }
}