package com.irostub.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //pre : 전 필터
        //post : 후 필터
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //어떠한 조건에 의해 필터를 사용할지 안할지
        //true : 필터를 사용함
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("************************** printing logs : ");

        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        log.info("************************** "+ request.getRequestURL());

        return null;
    }
}
