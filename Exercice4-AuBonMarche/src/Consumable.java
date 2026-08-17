import java.time.LocalDate;

public interface Consumable {
    boolean isRipe();
    boolean isExpired(LocalDate dateVerification);
    long daysRemainingBeforeExpiration(LocalDate dateVerification);
}
