
package org.bitducks.gamenav.ejb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

	public static String sha256(String password) {

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes());

			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				hexString.append(String.format("%02x", Byte.valueOf(hash[i])));
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			// .
		}

		return password;
	}
}
