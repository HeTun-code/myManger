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
@Table(name="t_news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meetingNewsId;
    private String meetingNewsName;
    private String meetingNewsIntroduce;
    private String meetingNewsSmallPic;
    private int type;
    private String meetingNewsDetail;

}
