package weixin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weixin.util.SignUtil;
import weixin.vo.Auth;

@RestController
@RequestMapping("/base")
public class BaseController {
    @RequestMapping("/weixinAuth")
    public String queryLasted(Auth auth) {
        if (SignUtil.checkSignature(auth.getSignature(), auth.getTimestamp(), auth.getNonce())) {
            return auth.getEchostr();
        }
        return null;
    }

}
