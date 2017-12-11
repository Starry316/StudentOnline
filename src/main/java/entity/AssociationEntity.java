package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Starry on 2017/12/11.
 */
@Entity
@Table(name = "association", schema = "studentonline", catalog = "")
public class AssociationEntity {
    private long id;
    private String associationName;
    private long managerId;
    private String introduction;
    private Timestamp foundedTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AssociationName", nullable = false, length = 255)
    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }

    @Basic
    @Column(name = "ManagerId", nullable = false)
    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "Introduction", nullable = true, length = -1)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "FoundedTime", nullable = true)
    public Timestamp getFoundedTime() {
        return foundedTime;
    }

    public void setFoundedTime(Timestamp foundedTime) {
        this.foundedTime = foundedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssociationEntity that = (AssociationEntity) o;

        if (id != that.id) return false;
        if (managerId != that.managerId) return false;
        if (associationName != null ? !associationName.equals(that.associationName) : that.associationName != null)
            return false;
        if (introduction != null ? !introduction.equals(that.introduction) : that.introduction != null) return false;
        if (foundedTime != null ? !foundedTime.equals(that.foundedTime) : that.foundedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (associationName != null ? associationName.hashCode() : 0);
        result = 31 * result + (int) (managerId ^ (managerId >>> 32));
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (foundedTime != null ? foundedTime.hashCode() : 0);
        return result;
    }
}
