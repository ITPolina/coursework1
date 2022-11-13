
import java.time.LocalTime;
import java.util.Arrays;
public enum AbonementType {
    ONETIME(LocalTime.of(8,00),LocalTime.of(22,00), new Zone[] {Zone.POOL, Zone.GYM}),
    DAYVISIT(LocalTime.of(8,00),LocalTime.of(16,00), new Zone[] {Zone.GYM, Zone.GROUP_TRAINING}),
    FULL (LocalTime.of(8,00),LocalTime.of(22,00), new Zone[] {Zone.GYM, Zone.POOL, Zone.GROUP_TRAINING});
    private final LocalTime timeStart;
    private final LocalTime timeEnd;
    private final Zone [] zones;


    AbonementType(LocalTime timeStart,LocalTime timeEnd, Zone[] zones ) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.zones = zones;
    }

    public boolean isZoneValid (Zone zone) {
        for (Zone zone1 : zones) {
            if (zone.equals(zone1)) return true;
        }
        return false;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public Zone[] getZones() {
        return zones;
    }

    @Override
    public String toString() {
        return "AbonementType{" +
                "timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", zones=" + Arrays.toString(zones) +
                '}';
    }
}
