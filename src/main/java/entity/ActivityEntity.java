package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Starry on 2017/12/11.
 */
@Entity
@Table(name = "activity", schema = "studentonline", catalog = "")
public class ActivityEntity {
    private long id;
    private String activityName;
    private String activityPlace;
    private Timestamp activityTime;
    private String activityContent;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ActivityName", nullable = true, length = 255)
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Basic
    @Column(name = "ActivityPlace", nullable = true, length = 255)
    public String getActivityPlace() {
        return activityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace;
    }

    @Basic
    @Column(name = "ActivityTime", nullable = true)
    public Timestamp getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Timestamp activityTime) {
        this.activityTime = activityTime;
    }

    @Basic
    @Column(name = "ActivityContent", nullable = true, length = -1)
    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityEntity that = (ActivityEntity) o;

        if (id != that.id) return false;
        if (activityName != null ? !activityName.equals(that.activityName) : that.activityName != null) return false;
        if (activityPlace != null ? !activityPlace.equals(that.activityPlace) : that.activityPlace != null)
            return false;
        if (activityTime != null ? !activityTime.equals(that.activityTime) : that.activityTime != null) return false;
        if (activityContent != null ? !activityContent.equals(that.activityContent) : that.activityContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (activityName != null ? activityName.hashCode() : 0);
        result = 31 * result + (activityPlace != null ? activityPlace.hashCode() : 0);
        result = 31 * result + (activityTime != null ? activityTime.hashCode() : 0);
        result = 31 * result + (activityContent != null ? activityContent.hashCode() : 0);
        return result;
    }
}
