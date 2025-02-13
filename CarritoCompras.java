import java.util.ArrayList;
import java.util.List;

public interface iBuilder<T> {

    public T builder();
}

enum Ram {
    RAM_8GB(8), RAM_16GB(16), RAM_32GB(32);

    private final int numeroRam;

    Ram(int i) {
        this.numeroRam = i;
    }

    public int getNumeroRam() {
        return this.numeroRam;
    }
}

class  Components{
    private  String procesador;
    private  Ram ram;
    private int almacenamiendo;
    private String targetaGrafica;


    public Components(String procesador, Ram ram, int almacenamiendo, String targetaGrafica) {
        this.procesador = procesador;
        this.ram = ram;
        this.almacenamiendo = almacenamiendo;
        this.targetaGrafica = targetaGrafica;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public int getAlmacenamiendo() {
        return almacenamiendo;
    }

    public void setAlmacenamiendo(int almacenamiendo) {
        this.almacenamiendo = almacenamiendo;
    }

    public String getTargetaGrafica() {
        return targetaGrafica;
    }

    public void setTargetaGrafica(String targetaGrafica) {
        this.targetaGrafica = targetaGrafica;
    }

    public static class Armador implements iBuilder<Components> {

        private  String procesador;
        private  Ram ram;
        private int almacenamiendo;
        private String targetaGrafica;

        public Armador setProcesador(String procesador) {
            this.procesador = procesador ;
                    return this;
        }

        public Armador setRam(Ram ram) {
            this.ram = ram;
            return this;
        }

        public Armador setAlmacenamiendo(int almacenamiendo) {
            this.almacenamiendo = almacenamiendo;
            return this;
        }

        public Armador setTargetaGrafica(String targetaGrafica) {
            this.targetaGrafica = targetaGrafica;
         return this;
        }

        @Override
        public Components builder() {
            return new Components(procesador,ram,almacenamiendo,targetaGrafica);

        }
    }

    @Override
    public String toString() {
        return "Components{" +
                "procesador='" + procesador + '\'' +
                ", ram=" + ram.getNumeroRam()+  "GB" +
                ", almacenamiendo=" + almacenamiendo +
                ", targetaGrafica='" + targetaGrafica + '\'' +
                '}';
    }
}


class ListaComputadores{
    List<Components> listacomputadoresArmados = new ArrayList<>();

    public ListaComputadores(List<Components> listacomputadoresArmados) {
        this.listacomputadoresArmados = listacomputadoresArmados;
    }

    public ListaComputadores() {
    }

    public List<Components> getListacomputadoresArmados() {
        return listacomputadoresArmados;
    }

    public ListaComputadores setListacomputadoresArmados(Components computador) {
        this.listacomputadoresArmados.add(computador);
        return this;
    }

    public void verLista(){
        this.listacomputadoresArmados.forEach(System.out::println);
    }

}


public class CreateCumputer {
    public static void main(String[] args) {
        Components computer1 = new Components.Armador()
                .setProcesador("Intel i9")
                .setRam(Ram.RAM_8GB)
                .setAlmacenamiendo(10000000)
                .setTargetaGrafica("Nvidia 4090")
                .builder();

        Components computer2 = new Components.Armador()
                .setProcesador("Intel i7")
                .setRam(Ram.RAM_16GB)
                .setAlmacenamiendo(20000000)
                .setTargetaGrafica("Nvidia 3060")
                .builder();


        Components computer3 = new Components.Armador()
                .setProcesador("AMD Ryzen 9")
                .setRam(Ram.RAM_32GB)
                .setAlmacenamiendo(50000000)
                .setTargetaGrafica("Nvidia 1080")
                .builder();

        System.out.println(computer1);
        System.out.println(computer2);
        System.out.println(computer3);

        ListaComputadores lista1 = new ListaComputadores()
                .setListacomputadoresArmados(computer1)
                .setListacomputadoresArmados(computer2)
                .setListacomputadoresArmados(computer3);
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ver equipos pero recorriendo la lista");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        lista1.verLista();

    }


}
