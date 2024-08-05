
import java.util.*;

class Automovil {
    
    private String nombre;
    private String placa;
    
    public Automovil(String nombre, String placa){
        this.nombre = nombre;
        this.placa = placa;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getPlaca(){
        return this.placa;
    }
    
    public void setPlaca(String p){
        this.placa = p;
    }
    
}


class Carro extends Automovil{
    
    private int modelo;
    private String marca;
    
    public Carro(String nombre, String placa,int modelo,String marca){
        super(nombre, placa);
        this.modelo=modelo;
        this.marca = marca;
    }
    
    public int getModelo(){
        return this.modelo;
    }
    
    public void setModelo(int modelo){
        this.modelo = modelo;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    @Override
   public String toString() {

        return "" + getNombre() + " " + getPlaca() + " - " + getModelo() + " - " + getMarca();

    }
    
}

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
         Carro carro1 = new Carro("Mazda","asd123",2000,"mazda");
         Carro carro2 = new Carro("tiburon","asd123",3000,"kia");
         
        System.out.println(carro1);
        System.out.println(carro2);
    }
}