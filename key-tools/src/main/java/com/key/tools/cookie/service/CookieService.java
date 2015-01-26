package com.key.tools.cookie.service;

public interface CookieService
{
	public String generateCookie(Long userId);

	public String addCookie(Long userId, String cookie);

	public int verifyCookie(Long userId, String cookie);

	public int removeCookie(Long userId, String cookie);
}
