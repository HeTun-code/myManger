package com.zzy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


/**
 * @author 麋鹿君
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="t_notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meetingNoticeId;
    private String meetingName;
    private String meetingAddress;
    private String meetingTime;
    private String meetingIntroduce;

    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_notice",
            joinColumns = @JoinColumn(name = "meetingNoticeId"),
            inverseJoinColumns = {@JoinColumn(name = "userId")}
    )
    private Set<User> users;
}
