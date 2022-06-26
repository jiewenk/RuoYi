package com.ruoyi.web.controller.monitor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.framework.web.domain.Server;

/**
 * 服务器监控
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/monitor/server")
public class ServerController extends BaseController {
    @GetMapping
    @RequiresPermissions("monitor:server:view")
    public String server(ModelMap modelMap) throws Exception {
        Server server = new Server();
        server.copyTo();
        modelMap.put("server", server);
        return "monitor/server/server";
    }
}