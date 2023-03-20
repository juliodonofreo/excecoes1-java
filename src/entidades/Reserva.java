package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer numeroQuarto;
    private Date checkin;
    private Date checkout;


    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Reserva() {

    }

    public Reserva(Integer numeroQuarto, Date checkin, Date checkout) {
        this.numeroQuarto = numeroQuarto;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public  Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duracao() {
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }

    public void atualizarDatas(Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Quarto ");
        builder.append(numeroQuarto);
        builder.append(", check-in: ");
        builder.append(sdf.format(checkin));
        builder.append(", check-out: ");
        builder.append(sdf.format(checkout));
        builder.append(", ");
        builder.append(duracao());
        builder.append(" noites. ");
        return builder.toString();
    }
}


