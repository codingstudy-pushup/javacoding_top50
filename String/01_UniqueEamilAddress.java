package string;

import java.util.*;

public class UniqueEamilAddress {

	public static void main(String[] args) {
		UniqueEamilAddress a = new UniqueEamilAddress();
		String[] emails = {
				"test.email+james@coding.com", 
				"test.e.mail+toto.jane@cod.ing.com",
				"testemail+tom@cod.ing.com" };
		System.out.println(a.solve_1(emails));
		System.out.println(a.solve_split(emails));

	}
	//1.Basic
	public int solve_1(String[] emails) {
		// 1
		Set<String> set = new HashSet<>();

		// 2
		for (String email : emails) {
			String localName = makeLocalName(email);// testemail
			String domainName = makeDomainName(email);// @
			System.out.println("domainName" + domainName);
			set.add(localName + "@" + domainName);
		}
		return set.size();
	}
	
	private String makeLocalName(String email) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < email.length(); i++) {
			// 1
			if (email.charAt(i) == '.') {
				continue;
			}
			if (email.charAt(i) == '+') {
				break;
			}
			if (email.charAt(i) == '@') {
				break;
			}
			// 2
			String str = String.valueOf(email.charAt(i));
			sb.append(str);
		}
		return sb.toString();
	}

	private String makeDomainName(String email) {

		return email.substring(email.indexOf('@') + 1);
	}

	
	
	//2 substring 
	public int solve_substring(String[] emails) {

		int result = 0;
		Set<String> set = new HashSet<>();
//		for (String email : emails) {
//			String tmpLocal = makeLocalName(email);
//			String tmpDomain = makeDomainName(email);
//			set.add(tmpLocal + tmpDomain);
//		}
		for (int i = 0; i < emails.length; i++) {
			String localName = "";
			String domainName = "";
			localName = emails[i].substring(0, emails[i].indexOf("+")).replace(".", "");
			domainName = emails[i].substring(emails[i].indexOf("@"));
			set.add(localName + domainName);
		}
		result = set.size();
		return result;

	}
// 3 split
	public int solve_split(String[] emails) {
		Set<String> set = new HashSet<>(); 
		for (String email : emails) {
			String[] parts = email.split("@"); 
			String[] localName = parts[0].split("\\+"); 
			set.add(localName[0].replace(".", "") + "@" + parts[1]); 														// domain.
		}
		return set.size();
	}
}
