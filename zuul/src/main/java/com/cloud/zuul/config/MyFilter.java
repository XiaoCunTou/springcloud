package com.cloud.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class MyFilter extends ZuulFilter {

    /**
     * filterType：返回一个字符串代表过滤器的类型
     * pre：路由之前  这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、
     *               在集群中选择请求的微服务、记录调试信息等
     * routing：路由之时    这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，
     *                      并使用 Apache HttpClient 或 Netfilx Ribbon 请求微服务
     * post： 路由之后       这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的 HTTP Header、
     *                      收集统计信息和指标、将响应从微服务发送给客户端等
     * error：发送错误调用     在其他阶段发生错误时执行该过滤器。
     *
     * 除了默认的过滤器类型，Zuul 还允许我们创建自定义的过滤器类型。例如，
     * 我们可以定制一种 STATIC 类型的过滤器，直接在 Zuul 中生成响应，而不将请求转发到后端的微服务
     * @return
     */

    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序 数字越大，优先级越低。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     *  判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。
     *  实际运用中我们可以利用该函数来指定过滤器的有效范围。
     *
     * @return
     */
    private int count = 0;
    @Override
    public boolean shouldFilter() {
        count++;
        if(count%2==0){
            count = 0;
            return false;
        }
        return true;
    }

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String token = request.getParameter("token");
        if(token == null || token.isEmpty()) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token is empty");
            return null;
        }
        return null;
    }
}
