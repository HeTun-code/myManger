package com.zzy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author 麋鹿君
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="t_resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meetingResourceId;
    private String meetingResourceDetail;


    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "meetingNoticeId")
    private Notice meetingNotice;
}
