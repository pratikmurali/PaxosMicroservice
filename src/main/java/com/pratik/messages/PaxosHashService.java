package com.pratik.messages;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

@Service
public class PaxosHashService {
	
	public String hash(String message) {

		return Hashing.sha256().hashString(message, StandardCharsets.UTF_8).toString();

	}

}
