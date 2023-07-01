///Clase iniciarSesion. Se encarga de validar los datos del empleado para poder ingresar el programa.

import java.util.Scanner;

public class iniciarSesion {
    private Empleado Empleado;

    ///Validamos legajo, buscandolo dentro de la clase baseDatosEmpleado
    public void validarLegajo() {
        Scanner scanner = new Scanner(System.in);
        baseDatosEmpleado database = new baseDatosEmpleado();

        while (true) {
            System.out.println("¡Hola! Ingresá tu legajo: ");
            int legajo = scanner.nextInt();
            Empleado = database.encontrarEmpleado(legajo);

            ///Si se encuentra el legajo, el programa sigue y da un mensaje de bienvenida
            if (Empleado != null) {
                System.out.println("Bienvenido " + Empleado.getnombre() + "!");
                break;
                ///En caso contrario, le pedirá al usuario ingresar los datos nuevamente
            } else {
                System.out.println("Legajo invalido. Intente nuevamente.");
            }
        }


        ///Si la validación es correcta, llamamos al menu para que se visualice
        Menu menu = new Menu();
        menu.mostrarMenu();
    }
}
