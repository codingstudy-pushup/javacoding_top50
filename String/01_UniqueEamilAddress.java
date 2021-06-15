package string;

import java.util.*;

public class UniqueEamilAddress {

	public static void main(String[] args) {
		UniqueEamilAddress a = new UniqueEamilAddress();
		String[] emails = {
				"test.email+james@coding.com", 
				"test.e.mail+toto.jane@cod.ing.com",
				"testemail+tom@cod.ing.com" };
		System.out.println(a.numUniqueEmails(emails));
		System.out.println(a.numUniqueEmails2(emails));

	}
	//1
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
			String tmpLocal = "";
			String tmpDomain = "";
			tmpLocal = emails[i].substring(0, emails[i].indexOf("+")).replace(".", "");
			tmpDomain = emails[i].substring(emails[i].indexOf("@"));
			set.add(tmpLocal + tmpDomain);
		}

		result = set.size();

		return result;

	}
// 3 replace
	public int solve_replace(String[] emails) {
		Set<String> set = new HashSet<>(); 
		for (String email : emails) {
			String[] parts = email.split("@"); 
			String[] local = parts[0].split("\\+"); 
			set.add(local[0].replace(".", "") + "@" + parts[1]); 														// domain.
		}
		return set.size();
	}
}
