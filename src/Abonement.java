import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class Abonement {

    private Holder holder;
    private LocalDate regDate;
    private LocalTime regTime;
    private LocalDate regEndDate;
    private AbonementType abonementType;


    public Abonement(Holder holder, LocalDate regEndDate, AbonementType abonementType){
        this.holder = holder;
        this.regDate = LocalDate.now();
        this.regTime = LocalTime.now();
        this.regEndDate = regEndDate;
        this.abonementType = abonementType;

    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("в H ч. и mm мин.");

    public void addAbonement (Abonement abonement, Abonement[] abonements, Zone zone ) {
        for (int i = 0; i < abonements.length; i ++) {
            if (abonements[i] == null) {
                abonements[i] = abonement;
                System.out.println("Зарегистрирован " + (i+1) + "й абонемент в зону " + zone);
                System.out.println("1."+ abonement.getHolder().getSurname() +" " + abonement.getHolder().getName() + " Посещаемая зона: " + zone);
                String timeToStr = formatter.format(abonement.regTime);
                System.out.println("2. Дата и время посещения: " + abonement.regDate + "  " + timeToStr);
                return;
            }
        }
        System.out.println("В выбранной зоне нет свободных мест ");
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

