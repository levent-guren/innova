package tr.com.innova.service;

import org.springframework.stereotype.Service;

import tr.com.innova.bean.Personel;

@Service
public class LoginService {

	public boolean login(Personel personel) {
		if ("".equals(personel.getUsername()) || "".equals(personel.getPassword())) {
			return false;
		}
		String reverseUsername = new StringBuilder(personel.getUsername()).reverse().toString();
		if (personel.getPassword().equals(reverseUsername)) {
			return true;
		}
		return false;
	}
}
