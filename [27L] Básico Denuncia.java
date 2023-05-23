

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la persona que va a denunciar y recuerde que este proyecto es con fines Eticos::");
        String denunciado = scanner.nextLine();

        System.out.println("Ingrese el nombre del deudor de Pension:");
        String deudor = scanner.nextLine();

        System.out.println("Ingrese el motivo de la denuncia:");
        String motivo = scanner.nextLine();

        recibirDenuncia(denunciado, deudor, motivo);
    }

    public static void recibirDenuncia(String denunciante, String deudor, String motivo) {
        System.out.println("Denuncia recibida Gracias por la Información:");
        System.out.println("denunciado:");
        System.out.println("Deudor: " + deudor);
        System.out.println("Motivo: " + motivo);
    }
}
