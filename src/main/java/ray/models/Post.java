package ray.models;

import javafx.geometry.Pos;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zr on 2016/11/14.
 */
@Document(collection = "post")
public class Post {
    public static final String STATUS_ACTIVE = "active";
    public static final String STATUS_INACTIVE = "inactive";
    @Id
    private String postId;
    @NotNull
    private String title;
    @NotNull @Indexed(unique = true) private String index;
    @NotNull private String content;
    @NotNull private Date createDate = new Date();
    @NotNull private Date updateDate;
    private String status = Post.STATUS_INACTIVE;
    private Set<String> tags = new HashSet<>();
    public Post(){

    }

    public Post(String postId, String title, String index, String content, Date createDate, String status, Set<String> tags, Date updateDate) {
        this.postId = postId;
        this.title = title;
        this.index = index;
        this.content = content;
        this.createDate = createDate;
        this.status = status;
        this.tags = tags;
        this.updateDate = updateDate;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
