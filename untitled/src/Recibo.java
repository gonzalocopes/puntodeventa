import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Recibo {
    public static void generarRecibo(List<Producto> carrito) {
        System.out.println("\n---RECIBO---");
        System.out.println("Ésta es una transacción realizada con el POS de la UNAB.");
        System.out.println("Fecha: " + new Date());
        System.out.println("Productos:");

        double total = 0.0;
        for (Producto producto : carrito) {
            double subtotal = producto.getPrecio() * producto.getCantidad();
            System.out.println("- " + producto.getNombre() + " x " + producto.getCantidad() + ": $" + subtotal);
            total += subtotal;
        }

        System.out.println("¿Cómo va a abonar?");
        System.out.println("1. Con débito");
        System.out.println("2. Efectivo");

        Scanner scanner = new Scanner(System.in);
        String formaPago = scanner.nextLine();

        switch (formaPago) {
            case "2":
                MetodoPago efectivo = new Efectivo();
                efectivo.procesarPago(total);
                break;
            case "1":
                System.out.println("Ingrese su número de tarjeta: ");
                int numeroTarjeta = scanner.nextInt();
                scanner.nextLine();
                MetodoPago debito = new Debito(numeroTarjeta);
                debito.procesarPago(total);
                break;
            default:
                System.out.println("Opción incorrecta. Seleccione nuevamente.");
                break;
        }

        System.out.println("Gracias por su compra.");
    }
}
