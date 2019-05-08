package com.prosmv.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import com.prosmv.config.context.SpringContext;
import com.prosmv.domain.AuthenticationToken;
import com.prosmv.repositories.AuthenticationTokenRepository;
import com.prosmv.security.UserPrincipal;
import com.prosmv.service.message.MessageService;

public class TokenAuthenticationFilter extends GenericFilterBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

	private AuthenticationTokenRepository authenticationTokenRepository;

	private MessageService messageService = (MessageService) SpringContext.getBean(MessageService.class);

	public TokenAuthenticationFilter(AuthenticationTokenRepository authenticationTokenRepository) {
		this.authenticationTokenRepository = authenticationTokenRepository;
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest httpRequest = (HttpServletRequest) request;

		// extract token from header
		final String accessToken = httpRequest.getHeader("Authorization");
		LOGGER.info("accessToken: " + accessToken);
		if (null != accessToken && !StringUtils.isEmpty(accessToken)) {
			LOGGER.info("authenticationTokenRepository: " + authenticationTokenRepository);
			AuthenticationToken auth = authenticationTokenRepository.findByToken(accessToken);
			// get and check whether token is valid ( from DB or file wherever you are
			// storing the token)

			// Populate SecurityContextHolder by fetching relevant information using token
			LOGGER.info("auth_User: " + auth);
			if (auth != null) {
				LOGGER.info("authUser: " + auth.getUser());
				UserPrincipal userPrincipal = new UserPrincipal(auth.getUser());
				final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						auth.getUser(), null, userPrincipal.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
				chain.doFilter(request, response);
			} else {
				LOGGER.info("token is expired");
				final HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.setHeader("message", "token is expired");
				httpResponse.sendError(401, "token is expired");
			}
		}
	}
}
