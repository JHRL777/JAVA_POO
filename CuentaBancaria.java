import java.util.*;

class Cuenta {

    private String nombre;
    private int cuenta;
    private float dineroCuenta;

    public Cuenta(String nombre, int cuenta, float dineroCuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.dineroCuenta = dineroCuenta;
    }

    public Cuenta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public float getDineroCuenta() {
        return dineroCuenta;
    }

    public void setDineroCuenta(float dineroCuenta) {
        this.dineroCuenta = dineroCuenta;
    }

    public String getInformacion() {
        return "Nombre: " + nombre + ", Número de Cuenta: " + cuenta + ", Saldo: " + dineroCuenta;
    }

    // Métodos para manejar transacciones
    public void depositar(float cantidad) {
        if (cantidad > 0) {
            dineroCuenta += cantidad;
            System.out.println("Depósito de " + cantidad + " exitoso. Saldo actual: " + dineroCuenta);
        } else {
            System.out.println("Cantidad de depósito inválida.");
        }
    }

    public void retirar(float cantidad) {
        if (cantidad > 0 && cantidad <= dineroCuenta) {
            dineroCuenta -= cantidad;
            System.out.println("Retiro de " + cantidad + " exitoso. Saldo actual: " + dineroCuenta);
        } else {
            System.out.println("Cantidad de retiro inválida o saldo insuficiente.");
        }
    }

    public void transferir(Cuenta cuentaDestino, float cantidad) {
        if (cantidad > 0 && cantidad <= dineroCuenta) {
            retirar(cantidad);
            cuentaDestino.depositar(cantidad);
            System.out.println("Transferencia de " + cantidad + " a la cuenta " + cuentaDestino.getCuenta() + " exitosa.");
        } else {
            System.out.println("Cantidad de transferencia inválida o saldo insuficiente.");
        }
    }
}

class Banco {

    private String nombreBanco;
    private List<Cuenta> cuentas;

    public Banco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
        this.cuentas = new ArrayList<>();
    }

    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }

    public void todasCuentas() {
        for (int i = 0; i < this.cuentas.size(); i++) {
            Cuenta cuenta = this.cuentas.get(i);
            System.out.println("Cuenta " + (i + 1) + ": " + cuenta.getInformacion());
        }
    }

    public Cuenta buscarCuenta(int numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getCuenta() == numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }
}

class Cajero {

    private String ubicacion;
    private float dineroCajero;
    private List<Banco> transacciones;

    public Cajero() {
        this.transacciones = new ArrayList<>();
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getDineroCajero() {
        return dineroCajero;
    }

    public void setDineroCajero(float dineroCajero) {
        this.dineroCajero = dineroCajero;
    }

    public List<Banco> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Banco transacciones) {
        this.transacciones.add(transacciones);
    }
}

public class CuentaBancaria {
    public static void main(String[] args) throws Exception {

        // Inicializamos el objeto donde se van a guardar las cuentas
        Banco bancolombia = new Banco();

        Cajero cajero1 = new Cajero();
        cajero1.setUbicacion("Bogotá");
        cajero1.setDineroCajero(100000000);

        // Se crean las cuentas
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setNombre("Pacho");
        cuenta1.setCuenta(1111);
        cuenta1.setDineroCuenta(1000000);
        bancolombia.setCuentas(cuenta1);

        Cuenta cuenta2 = new Cuenta();
        cuenta2.setNombre("Jesus");
        cuenta2.setCuenta(2222);
        cuenta2.setDineroCuenta(2300000);
        bancolombia.setCuentas(cuenta2);

        Cuenta cuenta3 = new Cuenta();
        cuenta3.setNombre("Sergio");
        cuenta3.setCuenta(3333);
        cuenta3.setDineroCuenta(1850000);
        bancolombia.setCuentas(cuenta3);

        // Mostrar todas las cuentas
        bancolombia.todasCuentas();

        // Realizar transacciones
        System.out.println("\nRealizando transacciones:");

        // Depósito en la cuenta1
        cuenta1.depositar(50000);

        // Retiro de la cuenta2
        cuenta2.retirar(100000);

        // Transferencia de cuenta1 a cuenta3
        cuenta1.transferir(cuenta3, 200000);

        // Mostrar todas las cuentas después de las transacciones
        bancolombia.todasCuentas();
    }
}
