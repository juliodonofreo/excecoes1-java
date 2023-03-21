package aplicacao;

import modelo.entidades.Reserva;
import modelo.excecoes.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int numeroQuarto = sc.nextInt();
            System.out.print("Data de entrada (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("Data de saída (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Digite dados para atualizar a reserva: ");
            System.out.print("Data de entrada (dd/MM/yyyy) ");
            checkin = sdf.parse(sc.next());
            System.out.print("Data de saída (dd/MM/yyyy) ");
            checkout = sdf.parse(sc.next());

            reserva.atualizarDatas(checkin, checkout);
            System.out.println("Reserva: " + reserva);

        }
        catch (ParseException e ){
            System.out.println("Formato de data inválido. ");
        }
        catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Erro inexperado: " + e);
        }
    }
}