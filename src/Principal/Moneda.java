package Principal;

public record Moneda(String time_last_update_utc, String base_code,
                     String target_code, String conversion_rate,
                     String conversion_result) {
}