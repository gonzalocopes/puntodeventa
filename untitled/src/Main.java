//Acá tenemos el Main que le da arranque a nuestro programa
//Inicia pidiendo que el usuario ingrese un legajo que, de encontrarse, da inicio al Menu
//En caso contrario, se pedirá que se ingrese nuevamente

//Modifiqué el codigo de tal manera para que sea más fácil de comprender

//La idea de este proyecto es darle funcionalidad a un POS de un pequeño almacen

public class Main {
    public static void main(String[] args) {
    	
    	iniciarSesion iniciarSesion = new iniciarSesion();
        iniciarSesion.validarLegajo();
       
    }
}