package org.nix.book.model.base;

import org.hibernate.annotations.GenericGenerator;
import org.nix.book.CloneTools;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
@MappedSuperclass
public class BaseModel {

    private int id;

    private Date createDate = new Date();

    @Id
    @Column(name = "id", unique = true, length = 32, nullable = false)
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    public int getId() {
        return id;
    }

    @Column(name = "createTime", length = 19, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            return CloneTools.deepClone(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
