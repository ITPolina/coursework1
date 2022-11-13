import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class Abonement {

    private Holder holder;
    LocalDate regDate;
    LocalTime regTime;
    private LocalDate regEndDate;
    private AbonementType abonementType;


    public Abonement(Holder holder, LocalDate regEndDate, AbonementType abonementType){
        this.holder = holder;
        this.regDate = LocalDate.now();
        this.regTime = LocalTime.now();
        this.regEndDate = regEndDate;
        this.abonementType = abonementType;

    }

    public Holder getHolder() {
        return holder;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public LocalTime getRegTime() {
        return regTime;
    }

    public LocalDate getRegEndDate() {
        return regEndDate;
    }

    public AbonementType getAbonementType() {
        return abonementType;
    }

    @Override
    public String toString() {
        return "Abonement{" +
                "holder=" + holder +
                ", regDate=" + regDate +
                ", regEndDate=" + regEndDate +
                ", abonementType=" + abonementType +
                '}';
    }
}

