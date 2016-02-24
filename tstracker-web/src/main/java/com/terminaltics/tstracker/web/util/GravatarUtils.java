package com.terminaltics.tstracker.web.util;

import de.bripkens.gravatar.DefaultImage;
import de.bripkens.gravatar.Gravatar;

public class GravatarUtils {

	public static String gravatarImageURL(String email) {
		Gravatar gravatar = new Gravatar();
		gravatar.setSize(18);
		gravatar.setHttps(true);
		gravatar.setStandardDefaultImage(DefaultImage.MYSTERY_MAN);
		String gravatarImageUrl = gravatar.getUrl(email);		
		
		return gravatarImageUrl;
	}
	
}
