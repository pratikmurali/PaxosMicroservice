package com.pratik.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaxosController {
	
	@Autowired
	private PaxosHashService cryptoHash;

	//@Autowired
	//private RepositoryService repositoryService;
	
	Logger logger = LoggerFactory.getLogger(PaxosController.class);

	/**
	 * Accept a json request with a String, generate a crypto hash (sha-256)
	 * Check if it's present in the repository, if not save a new row. 
	 * return the generated sha-256 hash.
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/messages", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<MessageResponse> convert(@RequestBody MessageRequest request) {
		logger.info("Inside convert API");
		String hex = cryptoHash.hash(request.getMessage());
		// repositoryService.saveMessageIfNotPresent(hex);
		MessageResponse res = new MessageResponse();
		res.setDigest(hex);
		return new ResponseEntity<MessageResponse>(res, HttpStatus.OK);

	}

	/**
	 * Return the cryptohash from the repository if present, else
	 * throw a 404.
	 * @param hex
	 * @return
//	 */
//	@RequestMapping(value = "/messages/{hash}", method = RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//	public Messages retrieve(@PathVariable String hex) {
//		logger.debug("Inside retrieve API");
//		return repository.findById(hex).orElseThrow(() -> new ResourceNotFoundException(hex));
//	}

}
