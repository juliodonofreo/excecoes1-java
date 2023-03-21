package modelo.entidades;

import modelo.excecoes.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva{

    private Integer numeroQuarto;
    private Date checkin;
    private Date checkout;


    private final static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    public Reserva() {

    }

    public Reserva(Integer numeroQuarto, Date checkin, Date checkout) throws DomainException{
        if(!checkout.after(checkin)) {
            throw new DomainException("A data de saída deve ser posterior à de entrada ");
        }

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

    public void atualizarDatas(Date checkin, Date checkout) throws DomainException{
        Date agora = new Date();

        if (checkin.before(agora) || checkout.before(agora)) {
            throw new DomainException("As datas atualizadas devem ser datas futuras");
        }
        if (!checkout.after(checkin)) {
           throw new DomainException("A data de saida deve ser posterior à de entrada");
        }

        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return  "Quarto " +
                numeroQuarto +
                ", check-in: " +
                SDF.format(checkin) +
                ", check-out: " +
                SDF.format(checkout) +
                ", " +
                duracao() +
                " noites. ";
    }
}


