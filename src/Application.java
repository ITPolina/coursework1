import java.time.LocalDate;
import java.time.LocalTime;

public class Application {
    public static void main(String[] args) {
        Holder holder01 = new Holder("Kir", "Naumov", LocalDate.of(1974, 6, 16));
        Holder holder02 = new Holder("Kirill", "Petrov",LocalDate.of(1980, 3, 13));
        Holder holder03 = new Holder("Stanislav", "Koshkin",LocalDate.of(1980, 4, 15));
        Holder holder04 = new Holder("Ekaterina", "Vol'naya",LocalDate.of(1980, 2, 20));
        Holder holder05 = new Holder("Maxim", "Pratusevich", LocalDate.of(1972, 12, 18));
        Holder holder06 = new Holder("David", "Pevzner", LocalDate.of(2008, 5, 10));
        Holder holder07 = new Holder("Misha", "Kasatonov", LocalDate.of(2002, 4, 27));
        Holder holder08 = new Holder("Kseniya", "Smirnova", LocalDate.of(1985, 8, 25));
        Holder holder09 = new Holder("Natalia", "Mokhrova", LocalDate.of(1975, 7, 7));
        Holder holder10 = new Holder("Sergei", "Fomin", LocalDate.of(1980, 2, 12));


        Abonement abonement01 = new Abonement(holder01, LocalDate.of(2022, 11, 10), AbonementType.DAYVISIT);
        Abonement abonement02 = new Abonement(holder01, LocalDate.now(), AbonementType.ONETIME);
        Abonement abonement03 = new Abonement(holder02, LocalDate.of(2022, 12, 10), AbonementType.FULL);
        Abonement abonement04 = new Abonement(holder03, LocalDate.of(2023, 6, 30), AbonementType.ONETIME);
        Abonement abonement05 = new Abonement(holder04, LocalDate.now(), AbonementType.DAYVISIT);
        Abonement abonement06 = new Abonement(holder05, LocalDate.of(2023, 1, 31), AbonementType.FULL);
        Abonement abonement07 = new Abonement(holder06, LocalDate.of(2023, 5, 25), AbonementType.DAYVISIT);
        Abonement abonement08 = new Abonement(holder07, LocalDate.of(2024, 11, 17), AbonementType.FULL);
        Abonement abonement09 = new Abonement(holder08, LocalDate.of(2025, 6, 10), AbonementType.ONETIME);
        Abonement abonement10 = new Abonement(holder09, LocalDate.of(2023, 12, 31), AbonementType.FULL);
        Abonement abonement11 = new Abonement(holder10, LocalDate.of(2023, 3, 15), AbonementType.DAYVISIT);

        Abonement[] allAbonements =  new Abonement[] {abonement01, abonement02, abonement03, abonement04, abonement05, abonement06, abonement07, abonement08, abonement09, abonement10, abonement11};


        Fitness fitness = new Fitness();

        Zone[] zones = Zone.values();
        //Zone desiredZone = Zone.GROUP_TRAINING; // для проверки
        for (int i = 0; i < allAbonements.length; i++) {
            Zone desiredZone = zones[(int) (Math.random() * 3)];
            fitness.addFitness(allAbonements[i], desiredZone);
        }

        fitness.printFitness();

        if (LocalTime.now().isAfter(LocalTime.of(22,00))) fitness.closeFitness();

    }
}
