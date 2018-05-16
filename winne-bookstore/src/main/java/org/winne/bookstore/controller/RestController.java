package org.winne.bookstore.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.winne.base.RestResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/rest")
public class RestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Map<String, Long> WAIT = new HashMap<>();

    @RequestMapping(value = "wait", method = RequestMethod.GET)
    @ResponseBody
    public Object wait(HttpServletRequest request, HttpServletResponse response, @RequestParam String name, @RequestParam long second) {
        logger.info("wait:" + name + ":" + second);
        if (StringUtils.isEmpty(name)) {
            return "";
        }
        if (second < 0) {
            second = 0;
        }
        second = second * 1000;
        try {
            Thread.sleep(second);
            logger.info("wait end:" + name + ":" + second);
        } catch (InterruptedException e) {
            logger.warn("wait error:" + name + ":" + second);
        }
        WAIT.put(name, second);
        logger.info("WAIT:" + WAIT);

        return name;
    }

    @RequestMapping(value = "exception", method = RequestMethod.GET)
    @ResponseBody
    public RestResponse<Object> exception(HttpServletRequest request, HttpServletResponse response) throws Exception {
        throw new Exception("error");
    }
}
