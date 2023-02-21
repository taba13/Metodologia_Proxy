import java. util. Scanner;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

interface CuentaBancaria {
    public void consultarSaldo();
    public void retirarSaldo(double cantidad);
    public void depositarSaldo(double cantidad);
}
class CuentaBancariaImpl implements CuentaBancaria {
    private String nombre;
    private double saldo;

    public CuentaBancariaImpl(String nombre) {
        this.nombre = nombre;
        this.saldo = 0.0;
    }

    @Override
    public void consultarSaldo() {
        System.out.println("El saldo actual de la cuenta de " + nombre + " es de " + saldo + " pesos.");
    }

    @Override
    public void retirarSaldo(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("No se puede retirar " + cantidad + " pesos, ya que la cuenta solo tiene " + saldo + " pesos.");
        } else {
            saldo -= cantidad;
            System.out.println("Se han retirado " + cantidad + " pesos de la cuenta de " + nombre + ", y ahora tiene " + saldo + " pesos.");
        }
    }

    @Override
    public void depositarSaldo(double cantidad) {
        saldo += cantidad;
        System.out.println("Se han depositado " + cantidad + " pesos en la cuenta de " + nombre + ", y ahora tiene " + saldo + " pesos.");
    }
}

// Clase Proxy para la cuenta bancaria
class ProxyCuentaBancaria implements CuentaBancaria {
    private String nombre;
    private CuentaBancaria cuentaBancaria;

    public ProxyCuentaBancaria(String nombre) {
        this.nombre = nombre;
        this.cuentaBancaria = new CuentaBancariaImpl(nombre);
    }

    @Override
    public void consultarSaldo() {
        cuentaBancaria.consultarSaldo();
    }

    @Override
    public void retirarSaldo(double cantidad) {
        System.out.println("Se esta retirando " + cantidad + " pesos de la cuenta de " + nombre + "...");
        cuentaBancaria.retirarSaldo(cantidad);
    }

    @Override
    public void depositarSaldo(double cantidad) {
        System.out.println("Se esta depositando " + cantidad + " pesos en la cuenta de " + nombre + "...");
        cuentaBancaria.depositarSaldo(cantidad);
    }
}

// Ejemplo de uso
class Test {
    public static void main(String[] args) {    
       
        
        CuentaBancaria cuentaBancaria = new ProxyCuentaBancaria("Juan Osorio");
        cuentaBancaria.depositarSaldo( 1000);
        cuentaBancaria.consultarSaldo();
        cuentaBancaria.retirarSaldo(500);
        cuentaBancaria.consultarSaldo();
    
           
    }
}


