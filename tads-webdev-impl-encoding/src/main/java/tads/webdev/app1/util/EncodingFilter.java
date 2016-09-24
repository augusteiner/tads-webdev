
package tads.webdev.app1.util;

import java.io.IOException;

import javax.servlet.*;

/**
 * taken from
 * {@link https://dertompson.com/2007/01/29/encoding-filter-for-java-web-applications/}
 */
public class EncodingFilter implements Filter {

    private String encoding = "utf-8";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
        throws IOException, ServletException {

        request.setCharacterEncoding(encoding);

        filterChain.doFilter(request, response);

    }

    @Override
    public void init(FilterConfig filterConfig)
        throws ServletException {

        String encodingParam = filterConfig.getInitParameter("encoding");

        if (encodingParam != null) {

            encoding = encodingParam;

        }

    }

    @Override
    public void destroy() {

        // nothing todo

    }

}
