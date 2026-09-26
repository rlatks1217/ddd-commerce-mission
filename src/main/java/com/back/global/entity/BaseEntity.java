package com.back.global.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    public abstract int getId();

    public abstract LocalDateTime getCreateDate();

    public abstract LocalDateTime getModifyDate();
}
