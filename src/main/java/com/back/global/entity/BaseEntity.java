package com.back.global.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Getter;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    public abstract int getId();

    public abstract LocalDateTime getCreateDate();

    public abstract LocalDateTime getModifyDate();

    @Transient
    private final List<Object> domainEvents = new ArrayList<>();

    // 💡 하위 엔티티들이 이벤트를 만들어 던질(쌓을) 때 사용할 메서드
    protected void raiseEvent(Object event) {
        this.domainEvents.add(event);
    }

    @DomainEvents
    public Collection<Object> domainEvents() {
        return domainEvents;
    }

    @AfterDomainEventPublication
    public void clearDomainEvents() {
        this.domainEvents.clear();
    }
}
