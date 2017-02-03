package za.co.entelect.bootcamp.flash.domain;

import za.co.entelect.bootcamp.flash.domain.interfaces.EntityInterface;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author kevin.gouws - Created on 2017/02/01.
 */
@Entity
public class Vouchers implements EntityInterface<Integer> {
    private int voucherId;
    private BigDecimal amount;
    private String code;
    private Timestamp dateIssued;
    private boolean valid;

    @Id
    @Column(name = "VoucherID", nullable = false)
    public Integer getID() {
        return this.voucherId;
    }

    public void setID(Integer entityKey) {
        this.voucherId = entityKey;
    }

    @Basic
    @Column(name = "Amount", nullable = false, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "Code", nullable = false, length = 50)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "DateIssued", nullable = false)
    public Timestamp getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Timestamp dateIssued) {
        this.dateIssued = dateIssued;
    }

    @Basic
    @Column(name = "Valid", nullable = false)
    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vouchers vouchers = (Vouchers) o;

        if (voucherId != vouchers.voucherId) return false;
        if (valid != vouchers.valid) return false;
        if (amount != null ? !amount.equals(vouchers.amount) : vouchers.amount != null) return false;
        if (code != null ? !code.equals(vouchers.code) : vouchers.code != null) return false;
        if (dateIssued != null ? !dateIssued.equals(vouchers.dateIssued) : vouchers.dateIssued != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = voucherId;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (dateIssued != null ? dateIssued.hashCode() : 0);
        result = 31 * result + (valid ? 1 : 0);
        return result;
    }
}
