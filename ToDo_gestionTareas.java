import java.util.ArrayList;
import java.util.List;

class Tarea {
    private int id;
    private String descripcion;
    private boolean estado;

    public Tarea(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = true;
    }

    public Tarea() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
// PODEMOS MOSTRAR EN CONSOLA LAS TAREAS
    public String ver() {
        return "Tarea: id: " + id + ", Descripcion: " + descripcion + ", Estado: " + (estado ? "Pendiente" : "Completada");
    }
}

class HistoriaTareas {
    private List<Tarea> historiaTareas;

    public HistoriaTareas() {
        this.historiaTareas = new ArrayList<>();
    }

    public List<Tarea> getHistoriaTareas() {
        return historiaTareas;
    }
// AGREGA LAS TAREAS AL HISTORIAL DE LA LISTA
    public void addHistoriaTareas(Tarea tarea) {
        this.historiaTareas.add(tarea);
    }
// VE TODAS LAS TAREAS QUE ESTAN EN EL HISTOIAL DE TAREAS Y SI NO HAY DEVELVE UN MENSAJE INDICADO QUE NO HAN NADA EN LA LISTA
    public void verTodas() {
        if (historiaTareas.isEmpty()) {
            System.out.println("No hay tareas en la lista.");
        } else {
            for (Tarea tarea : historiaTareas) {
                System.out.println(tarea.ver());
            }
        }
    }
// BUSCAR UNA TAREA POR EL ID DE LA MISMA Y LA DEVUELVE PARA PODER SER UTULIZADA
    public Tarea verPorId(int id) {
        for (Tarea tarea : historiaTareas) {
            if (tarea.getId() == id) {
                return tarea;
            }
        }
        return null;
    }
// COMPLETA UNA TAREA  LA PASA DE TRUE A FALSE CUANDO ESTA EN FALSE ES QUE SE COMPLETO Y VALIDA QUE YA AYA ESTADO COMPLETADA
    public void completado(int id) {
        Tarea tarea = verPorId(id);
        if (tarea != null) {
            if (tarea.isEstado()) {
                tarea.setEstado(false);
                System.out.println("✅ La tarea {" + tarea.ver() + "} se completó.");
            } else {
                System.out.println("La tarea ya está completada.");
            }
        } else {
            System.out.println("ID NO EXISTE");
        }
    }
// ELIMINA UNA TAREA QUE EXISTE DENTRO DEL HISTORIAL DE TAREAS
    public void eliminar(int id) {
        Tarea tarea = verPorId(id);
        if (tarea != null) {
            if (!tarea.isEstado()) {
                this.historiaTareas.remove(tarea);
                System.out.println("✅ La tarea {" + tarea.ver() + "} se eliminó con éxito.");
            } else {
                System.out.println("❌ Para eliminar la tarea {" + tarea.ver() + "} primero se debe completar.");
            }
        } else {
            System.out.println("ID NO EXISTE");
        }
    }
}

public class ToDo_gestionTareas {
    public static void main(String[] args) {
        HistoriaTareas modulo1 = new HistoriaTareas();
        Tarea tarea1 = new Tarea(1, "Primera tarea");
        Tarea tarea2 = new Tarea(2, "Segunda tarea");
        Tarea tarea3 = new Tarea(3, "Tercera tarea");
        Tarea tarea4 = new Tarea(4, "Cuarta tarea");
        Tarea tarea5 = new Tarea(5, "Quinta tarea");
        Tarea tarea6 = new Tarea(6, "Sexta tarea");
        Tarea tarea7 = new Tarea(7, "Séptima tarea");
        Tarea tarea8 = new Tarea(8, "Octava tarea");
        Tarea tarea9 = new Tarea(9, "Novena tarea");
        Tarea tarea10 = new Tarea(10, "Décima tarea");

        modulo1.addHistoriaTareas(tarea1);
        modulo1.addHistoriaTareas(tarea2);
        modulo1.addHistoriaTareas(tarea3);
        modulo1.addHistoriaTareas(tarea4);
        modulo1.addHistoriaTareas(tarea5);
        modulo1.addHistoriaTareas(tarea6);
        modulo1.addHistoriaTareas(tarea7);
        modulo1.addHistoriaTareas(tarea8);
        modulo1.addHistoriaTareas(tarea9);
        modulo1.addHistoriaTareas(tarea10);

        System.out.println("--------TODAS LAS TAREAS---------\n");
        modulo1.verTodas();

        System.out.println("\n--------REALIZAR DE TAREA---------\n");

        for (int i = 1; i <= modulo1.getHistoriaTareas().size(); i++) {
            if (i % 2 == 0) {
                int numero = (int) (Math.random() * 10 + 1);
                modulo1.completado(numero);
                System.out.println("---------------------");
            }
        }

        System.out.println("\n------ELIMINAR TAREAS--------");
        System.out.println("---------------------");
        modulo1.eliminar(3);
        System.out.println("---------------------");
        modulo1.eliminar(2);
        System.out.println("---------------------");
        modulo1.eliminar(7);

        System.out.println("\n--------TODAS LAS TAREAS---------");
        modulo1.verTodas();
    }
}

