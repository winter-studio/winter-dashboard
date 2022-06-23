package org.winterframework.dashboard.web.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Schema(description = "分页查询参数")
public class PageParam implements Serializable {
    @Schema(description = "当前页数")
    private int current = 1;
    @Schema(description = "页大小")
    private int size = 10;

    public Page<?> toPage() {
        return new Page<>(current, size);
    }
}
