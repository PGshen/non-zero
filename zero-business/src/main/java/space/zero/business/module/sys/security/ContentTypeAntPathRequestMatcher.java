package space.zero.business.module.sys.security;

import space.zero.common.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by PG_shen
 * Date : 3/8/18
 * Time : 4:44 PM
 * Content-type 过滤，进行rest api过滤
 */
public class ContentTypeAntPathRequestMatcher extends AntPathRequestMatcher {
    private String contentType;

    public ContentTypeAntPathRequestMatcher(String pattern, String httpMethod,String contentType) {
        super(pattern, httpMethod);
        this.contentType=contentType;
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        if(StringUtils.isBlank(request.getContentType())){
            return false;
        }
        return super.matches(request)&& request.getContentType().contains(contentType);
    }
}
