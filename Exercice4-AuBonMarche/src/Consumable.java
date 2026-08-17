import java.time.LocalDate;

public interface Consumable {
    /**
     * Returns true if the product is at its ideal stage of maturity for consumption.
     * @return
     */
    boolean isRipe();

    /**
     * Calculates and returns true if the verification date is later than the product's use-by date.
     * @param dateVerification
     * @return
     */
    boolean isExpired(LocalDate dateVerification);

    /**
     * Returns the number of days remaining until the use-by date.
     * @param dateVerification
     * @return
     */
    long daysRemainingBeforeExpiration(LocalDate dateVerification);
}
