import java.io.Serializable;

/**
 * Created by wangbin on 2015/1/25.
 */
public class One implements Serializable{

    @JsonType
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
