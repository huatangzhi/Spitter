package com.hp.entity;

/**
 * Created by hp on 2016/12/10.
 */
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spittle {

    private final Long id;
    private final String message;
    private final Timestamp createtime;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, Timestamp createtime) {
        this(null, message, createtime, null, null);
    }

    public Spittle(Long id, String message, Timestamp createtime, Double latitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.createtime = createtime;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "createtime");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "createtime");
    }

    @Override
    public String toString() {
        return "Spittle{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", createtime=" + createtime +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

