import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Envio> listaEnvios = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar envío");
            System.out.println("2. Eliminar envío");
            System.out.println("3. Listar envíos");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarEnvio();
                    break;
                case 2:
                    eliminarEnvio();
                    break;
                case 3:
                    listarEnvios();
                    break;
            }

        } while (opcion != 4);
    }

    public static void agregarEnvio() {
        System.out.print("Cliente: ");
        String cliente = sc.nextLine();

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Peso: ");
        double peso = sc.nextDouble();

        System.out.print("Distancia: ");
        double distancia = sc.nextDouble();

        System.out.println("Tipo (1.Terrestre 2.Aéreo 3.Marítimo): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        Envio envio = null;

        switch (tipo) {
            case 1:
                envio = new EnvioTerrestre(cliente, codigo, peso, distancia);
                break;
            case 2:
                envio = new EnvioAereo(cliente, codigo, peso, distancia);
                break;
            case 3:
                envio = new EnvioMaritimo(cliente, codigo, peso, distancia);
                break;
        }

        listaEnvios.add(envio);
        System.out.println("✅ Envío agregado");
    }

    public static void eliminarEnvio() {
        System.out.print("Ingrese código a eliminar: ");
        String codigo = sc.nextLine();

        listaEnvios.removeIf(e -> e.getCodigo().equals(codigo));

        System.out.println("🗑️ Envío eliminado (si existía)");
    }

    public static void listarEnvios() {
        for (Envio e : listaEnvios) {
            System.out.println(e);
        }
    }
}