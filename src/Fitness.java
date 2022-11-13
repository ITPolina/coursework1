import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Fitness {
    private Abonement [] gymAbonements ;//= new Abonement[20];
    private Abonement [] poolAbonements ;
    private Abonement [] groupAbonements ;

    int capacity = 5;

    public Fitness() {
        this.gymAbonements = new Abonement[capacity];
        this.poolAbonements = new Abonement[capacity];
        this.groupAbonements = new Abonement[capacity];
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

    public void addFitness (Abonement abonement, Zone desiredZone) {
        if (abonement.getRegEndDate().isBefore(abonement.getRegDate())) {
            System.out.println("Ваш абонемент просрочен, Вы не можете посетить фитнес клуб");
            return;
        }
        if (abonement.getRegTime().isBefore(abonement.getAbonementType().getTimeStart()) || abonement.getRegTime().isAfter(abonement.getAbonementType().getTimeEnd())) {
            System.out.println("Время посещение фитнес клуба не соответствует Вашему абонементу");
            return;
        }

        //Arrays.sort(abonement.getAbonementType().getZones()); // сделано в AbonementType
        //if (Arrays.binarySearch(abonement.getAbonementType().getZones(),desiredZone ) < 0) {
        if (!abonement.getAbonementType().isZoneValid(desiredZone)) {
            System.out.println("Ваш абонемент не позволяет посетить выбранную зону " + desiredZone);
            return;
        }
        if (desiredZone == Zone.GYM) {
            addAbonement(abonement, gymAbonements, desiredZone);
        }
        if (desiredZone == Zone.POOL) {
            addAbonement(abonement, poolAbonements, desiredZone);
        }
        if (desiredZone == Zone.GROUP_TRAINING) {
            addAbonement(abonement, groupAbonements, desiredZone);
        }

    }
    public void printFitness(){
        System.out.println("Посетители спортзала: ");
        for (Abonement gymAbonement : gymAbonements) {
            if (gymAbonement != null) System.out.println(gymAbonement.getHolder());
            else break;
        }
        System.out.println("Посетители бассейна: ");
        for (Abonement poolAbonement : poolAbonements) {
            if (poolAbonement != null) System.out.println(poolAbonement.getHolder());
            else break;
        }
        System.out.println("Посетители групповых занятий: ");
        for (Abonement groupAbonement : groupAbonements) {
            if (groupAbonement != null) System.out.println(groupAbonement.getHolder());
            else break;
        }
    }

    public void closeFitness (){
        Arrays.fill(gymAbonements, null);
        Arrays.fill(poolAbonements, null);
        Arrays.fill(groupAbonements, null);
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "gymAbonements=" + Arrays.toString(gymAbonements) +
                ", poolAbonements=" + Arrays.toString(poolAbonements) +
                ", groupAbonements=" + Arrays.toString(groupAbonements) +
                '}';
    }
}
