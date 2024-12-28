package com.zzyako.task3att.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "task3att")
@Accessors(chain = true)
public class SwimmerEntity {

    @Id
    @Column(nullable = false, unique = true, name = "swimmer_id")
    private UUID swimmer_id;

    @Column(nullable = false, name = "swimmer")
    private String swimmerName;

    @Column(nullable = true, name = "time")
    private String time;

    public void setSwimmer(String swimmerName) {
        this.swimmerName = swimmerName;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSwimmer_id(UUID uuid) {
        this.swimmer_id = swimmer_id;
    }

    public UUID getSwimmer_id() {
        return swimmer_id;
    }
}


