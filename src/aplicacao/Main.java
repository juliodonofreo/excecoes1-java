package aplicacao;

import entidades.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int numeroQuarto = sc.nextInt();
        System.out.print("Data de entrada (dd/MM/yyyy) ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Data de saída (dd/MM/yyyy) ");
        Date checkout = sdf.parse(sc.next());

        if(!checkout.after(checkin)){
            System.out.println("Erro na reserva! a data de saida deve ser posterior à de entrada");
        }
        else {
            Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Digite dados para atualizar a reserva: ");
            System.out.print("Data de entrada (dd/MM/yyyy) ");
            checkin = sdf.parse(sc.next());
            System.out.print("Data de saída (dd/MM/yyyy) ");
            checkout = sdf.parse(sc.next());

            Date agora = new Date();

            String erro = reserva.atualizarDatas(checkin, checkout);

            if (erro != null) {
                System.out.println("Erro na reserva: " + erro);
            }
            else {
                System.out.println("Reserva: " + reserva);

            }
        }
    }
}