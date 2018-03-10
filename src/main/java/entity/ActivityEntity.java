package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Starry on 2018/3/9.
 */
@Entity
@Table(name = "activity", schema = "studentonline", catalog = "")
public class ActivityEntity {
    private long id;
    private String activityName;
    private String activityPlace;
    private String activityContent;
    private Timestamp activityStartTime;
    private Timestamp activityEndTime;
    private Long associationId;
    private long managerId;
    private String signInWay;
    private String target;
    private Integer college;

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
    @Column(name = "ActivityContent", nullable = true, length = -1)
    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    @Basic
    @Column(name = "ActivityStartTime", nullable = true)
    public Timestamp getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Timestamp activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    @Basic
    @Column(name = "ActivityEndTime", nullable = true)
    public Timestamp getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Timestamp activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    @Basic
    @Column(name = "AssociationId", nullable = true)
    public Long getAssociationId() {
        return associationId;
    }

    public void setAssociationId(Long associationId) {
        this.associationId = associationId;
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
    @Column(name = "SignInWay", nullable = true, length = 255)
    public String getSignInWay() {
        return signInWay;
    }

    public void setSignInWay(String signInWay) {
        this.signInWay = signInWay;
    }

    @Basic
    @Column(name = "Target", nullable = true, length = 255)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Basic
    @Column(name = "College", nullable = true)
    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityEntity that = (ActivityEntity) o;

        if (id != that.id) return false;
        if (managerId != that.managerId) return false;
        if (activityName != null ? !activityName.equals(that.activityName) : that.activityName != null) return false;
        if (activityPlace != null ? !activityPlace.equals(that.activityPlace) : that.activityPlace != null)
            return false;
        if (activityContent != null ? !activityContent.equals(that.activityContent) : that.activityContent != null)
            return false;
        if (activityStartTime != null ? !activityStartTime.equals(that.activityStartTime) : that.activityStartTime != null)
            return false;
        if (activityEndTime != null ? !activityEndTime.equals(that.activityEndTime) : that.activityEndTime != null)
            return false;
        if (associationId != null ? !associationId.equals(that.associationId) : that.associationId != null)
            return false;
        if (signInWay != null ? !signInWay.equals(that.signInWay) : that.signInWay != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;
        if (college != null ? !college.equals(that.college) : that.college != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (activityName != null ? activityName.hashCode() : 0);
        result = 31 * result + (activityPlace != null ? activityPlace.hashCode() : 0);
        result = 31 * result + (activityContent != null ? activityContent.hashCode() : 0);
        result = 31 * result + (activityStartTime != null ? activityStartTime.hashCode() : 0);
        result = 31 * result + (activityEndTime != null ? activityEndTime.hashCode() : 0);
        result = 31 * result + (associationId != null ? associationId.hashCode() : 0);
        result = 31 * result + (int) (managerId ^ (managerId >>> 32));
        result = 31 * result + (signInWay != null ? signInWay.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (college != null ? college.hashCode() : 0);
        return result;
    }
}
