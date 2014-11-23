package me.binf.entity;

import me.binf.annotation.NoConvert;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by wangbin on 14-11-16.
 */
@Entity
@Table(name = "post")
public class Post {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "image_id")
    private Integer imageId;

    private String content;

    private Integer sort;

    private Boolean stick;

    @Transient
    private List<Category> categorys;

    @ManyToOne
    @JoinColumn(name = "create_by")
    private Member createBy;

    @ManyToOne
    @JoinColumn(name = "update_by")
    private Member updateBy;

    @NoConvert
    private Integer visits;

    private Integer stars;


    @Column(name = "comment_status")
    private Boolean commentStatus;

    @Column(name = "comment_count")
    private Integer commentCount;


    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "announce_date")
    private Date announceDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getStick() {
        return stick;
    }

    public void setStick(Boolean stick) {
        this.stick = stick;
    }

    public Member getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Member createBy) {
        this.createBy = createBy;
    }

    public Member getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Member updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Boolean getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Boolean commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(Date announceDate) {
        this.announceDate = announceDate;
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }
}
