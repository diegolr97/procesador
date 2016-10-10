package Controlador;
import Vista.Principal;




//llama a la clase iniciar del controlador 
public class Main {
    
    public static void main(String[] args) {
        //ejecuta el controlador y este la vista
        new controlador( new Principal() ).iniciar(); ;
        System.out.println("arranque programa");
        
    }

}
