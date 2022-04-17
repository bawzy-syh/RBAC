package org.syh.RBAC.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@ApiModel(value="RsaKey对象", description="")
public class RsaKey extends Model<RsaKey> {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long keyId;

    private String privateKey;

    private String publicKey;

    private LocalDateTime deprecateTime;

    private LocalDateTime abandonTime;

    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.keyId;
    }

}
