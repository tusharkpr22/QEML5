package models;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class Operation {
    private Long id;
    private String date;
    private String description;
    private BigDecimal amount;
    private BankAccount bankAccount; // Using Object here, but this should be replaced with the actual class type if known.
    private Set<Label> label;
}

