package org.syh.RBAC.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author syh
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserRoleRelation对象", description="")
public class UserRoleRelation extends Model<UserRoleRelation> {

    private static final long serialVersionUID = 1L;

    @TableId("userID")
    private Integer userID;

    @TableField("roleID")
    private Integer roleID;

    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.userID;
    }

}
