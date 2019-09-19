package xin.oreki.orekiuser.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author oreki
 */
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String remark;
}
