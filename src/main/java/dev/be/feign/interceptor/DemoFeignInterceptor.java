package dev.be.feign.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {

        // get 요청일 경우
        if (template.method().equals(Request.HttpMethod.GET.name())) {
            System.out.println("[GET] [DemoFeignInterceptor] queries : " + template.queries());
            return;
        }

        // post
        String encodedRequestBody = StringUtils.toEncodedString(template.body(), StandardCharsets.UTF_8);
        System.out.println("[POST] [DemoFeignInterceptor] requestBody : " + encodedRequestBody);

        template.body(encodedRequestBody);
    }
}
