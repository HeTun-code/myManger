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
@Table(name = "t_agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int agendaId;
    private String agendaDetail;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "meetingNoticeId")
    private Notice notice;
}
