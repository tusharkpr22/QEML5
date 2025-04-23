package models;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class BankAccount {
    private Long id;
    private BigDecimal balance;
    private String name;
    private User user;
    private Set<Operation> operations ;
}
