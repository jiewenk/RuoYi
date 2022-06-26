package com.ruoyi.framework.web.domain.server;

import com.ruoyi.common.utils.Arith;
import com.ruoyi.framework.web.domain.Server;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import oshi.software.os.OSFileStore;

/**
 * 系统文件相关信息
 *
 * @author ruoyi
 */
@Getter
@Setter
@NoArgsConstructor
public class SysFile {
    /** 盘符路径 */
    private String dirName;

    /** 盘符类型 */
    private String sysTypeName;

    /** 文件类型 */
    private String typeName;

    /** 总大小 */
    private String total;

    /** 剩余大小 */
    private String free;

    /** 已经使用量 */
    private String used;

    /** 资源的使用率 */
    private double usage;

    public SysFile(@NotNull OSFileStore osFileStore) {
        this.dirName = osFileStore.getMount();
        this.sysTypeName = osFileStore.getType();
        this.typeName = osFileStore.getName();
        long total = osFileStore.getTotalSpace();
        long free = osFileStore.getUsableSpace();
        this.total = Server.convertFileSize(total);
        this.free = Server.convertFileSize(free);
        this.used = Server.convertFileSize(total - free);
        this.usage = Arith.mul(Arith.div(total - free, total, 4), 100);
    }
}