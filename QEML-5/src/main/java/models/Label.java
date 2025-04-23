package models;

import lombok.Data;

import java.util.Set;

@Data
public class Label {
    private   Long id;
    private String label;
    private Set<Operation> operation;

}