package mailbox;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Mobile_table")
public class Mobile {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer user;
    private Integer receiver;
    private String text;

    @PostPersist
    public void onPostPersist(){
        Sent sent = new Sent();
        BeanUtils.copyProperties(this, sent);
        sent.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }




}
