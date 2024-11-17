package com.ijse.cmjdfinal.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDateTime;
    private Double totalPrice;

    @PrePersist
    protected void onCreate() {
        if (orderDateTime == null) {
            this.orderDateTime = LocalDateTime.now();
        }
    }

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderedItemDetails> orderedItemDetails = new ArrayList<>();
}
