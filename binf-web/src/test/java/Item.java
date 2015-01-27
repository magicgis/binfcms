import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wangbin on 2015/1/25.
 */
public class Item {



    @JsonType
    private Integer id;

    private Date purchaseDate;

    private One one;

    private ArrayList list = new ArrayList();

    public Item(int id){
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }


    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public One getOne() {
        return one;
    }

    public void setOne(One one) {
        this.one = one;
    }
}
