package org.syh.RBAC.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@ApiModel(value="Role对象", description="")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    @TableId("roleID")
    private Integer roleID;

            @ApiModelProperty(value = "角色名（用于展示）")
    private String roleName;

            @ApiModelProperty(value = "角色标识（用于JWT）")
    private String roleIdentifier;

            @ApiModelProperty(value = "备注")
    private String comment;

    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.roleID;
    }

}
