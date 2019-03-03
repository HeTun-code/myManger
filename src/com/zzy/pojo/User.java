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
@Table(name="t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userLoginName;
    private String userName;
    private String telNum;
    private String password;
    private String photo;
    private String userIntroduce;
    private int rememberMe;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "missionId")
    private Mission mission;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "deptId")
    private Dept dept;
}
