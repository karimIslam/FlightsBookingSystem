package com.BrightSkies.karim.FlightsBookingSystem.Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserFlightsCompositeKey implements Serializable {
    @Column(name = "uID")
    int uid;

    @Column(name = "fID")
    int fid;

    public UserFlightsCompositeKey() {

    }

    public UserFlightsCompositeKey(int uID, int fID) {
        this.uid = uID;
        this.fid = fID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        UserFlightsCompositeKey that = (UserFlightsCompositeKey) o;
        return Objects.equals(uid, that.uid) &&
                Objects.equals(fid, that.fid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, fid);
    }
}
