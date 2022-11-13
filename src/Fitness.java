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

    /*public Abonement[] getGymAbonements() {
        return gymAbonements;
    }


    public Abonement[] getPoolAbonements() {
        return poolAbonements;
    }

    public Abonement[] getGroupAbonements() {
        return groupAbonements;
    }*/


    public void addFitness (Abonement abonement, Zone desiredZone) {
        if (abonement.getRegEndDate().isBefore(abonement.getRegDate())) {
            System.out.println("Ваш абонемент просрочен, Вы не можете посетить фитнес клуб");
            return;
        }
        if (abonement.getRegTime().isBefore(abonement.getAbonementType().getTimeStart()) || abonement.getRegTime().isAfter(abonement.getAbonementType().getTimeEnd())) {
            System.out.println("Время посещение фитнес клуба не соответствует Вашему абонементу");
            return;
        }
        // должен быть отсортированный массив
        Arrays.sort(abonement.getAbonementType().getZones()); // лучше бы это сделать в AbonementType, как???
        if (Arrays.binarySearch(abonement.getAbonementType().getZones(),desiredZone ) < 0) {
            System.out.println("Ваш абонемент не позволяет посетить выбранную зону " + desiredZone);
            return;
        }
        if (desiredZone == Zone.GYM) {
            abonement.addAbonement(abonement, gymAbonements, desiredZone);
        }
        if (desiredZone == Zone.POOL) {
            abonement.addAbonement(abonement, poolAbonements, desiredZone);
        }
        if (desiredZone == Zone.GROUP_TRAINING) {
            abonement.addAbonement(abonement, groupAbonements, desiredZone);
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
