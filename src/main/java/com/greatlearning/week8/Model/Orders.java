package com.greatlearning.week8.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Items.itemName")
    private List<Items> itemsList;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User.username")
    private User user;

    private LocalDate dateOfPurchase;

    private Double orderValue;

}
