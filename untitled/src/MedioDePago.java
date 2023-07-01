import java.util.Scanner;

abstract class MetodoPago {
    public abstract void procesarPago(double monto);
}

class Efectivo extends MetodoPago {
    @Override
    public void procesarPago(double monto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el monto entregado: ");
        double montoEntregado = scanner.nextDouble();
        double descuentoAplicado = monto - (monto * 0.05); // Aplica el descuento del 5%
        double vuelto = montoEntregado - descuentoAplicado;

        if (vuelto < 0) {
            System.out.println("El monto entregado es insuficiente.");
        } else {
            System.out.println("Pago en efectivo con 5% de descuento $" + descuentoAplicado + " recibido.");
            System.out.println("El vuelto a entregar es: " + vuelto);
        }
    }
}

class Debito extends MetodoPago {
    private int numeroTarjeta;

    public Debito(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con tarjeta de débito de $" + monto + " realizado.");
        // Aquí puedes agregar la lógica adicional para procesar el pago con tarjeta de débito
    }
}
