import java.util.HashMap;
import java.util.Map;

class Ropa {

    private int id;
    private String nombre;
    private double precio;
    private String descripcion;

    public Ropa(int id, String nombre, double precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String mostrarPrenda() {
        return "Prenda: ID: " + id + " Nombre: " + nombre + " Descripción: " + descripcion + " Precio: " + precio;
    }
}

class Tienda {

    private Map<Integer, Ropa> inventario;

    public Tienda() {
        this.inventario = new HashMap<>();
    }

    public Ropa buscarId(Integer id) {
        return inventario.get(id);
    }

    public void agregarPrenda(Ropa ropa) {
        inventario.put(ropa.getId(), ropa);
    }

    public void eliminarPrenda(Integer id) {
        inventario.remove(id);
    }

    public void todasPrendas() {
        for (var entrada : inventario.entrySet()) {
            Ropa prenda = entrada.getValue();
            System.out.println(prenda.mostrarPrenda());
        }
    }
}

public class TiendaRopaMap {
    public static void main(String[] args) {
        Tienda tienda1 = new Tienda();

        Ropa prenda1 = new Ropa(1, "pantalones", 20000, "Pantalones de bota ancha");
        Ropa prenda2 = new Ropa(2, "camisas", 30000, "Camisa cuello toruga");

        tienda1.agregarPrenda(prenda1);
        tienda1.agregarPrenda(prenda2);

        System.out.println("Prendas en la tienda:");
        tienda1.todasPrendas();

        Ropa prendaEncontrada = tienda1.buscarId(1);
        if (prendaEncontrada != null) {
            System.out.println("Prenda encontrada: " + prendaEncontrada.mostrarPrenda());
        } else {
            System.out.println("Prenda no encontrada");
        }

        tienda1.eliminarPrenda(1);

        System.out.println("Prendas en la tienda después de eliminar una:");
        tienda1.todasPrendas();
    }
}