package com.greatlearning.week8.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User.username")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Items.itemName")
    private List<Items> itemsList;

    public Cart(User user, List<Items> itemsList1){
        this.user = user;
        this.itemsList = itemsList1;

    }

    public Cart() {

    }
}

