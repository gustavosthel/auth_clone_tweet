package com.gustavosthel.springsecurity.controller;

import com.gustavosthel.springsecurity.controller.dto.CreateTweetDTO;
import com.gustavosthel.springsecurity.entities.Tweet;
import com.gustavosthel.springsecurity.repository.TweetRepository;
import com.gustavosthel.springsecurity.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TweetController {

    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    public TweetController(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/tweets")
    public ResponseEntity<Void> createTweet(@RequestBody CreateTweetDTO dto, JwtAuthenticationToken token) {
        var user = userRepository.findById(UUID.fromString(token.getName()));
        var tweet = new Tweet();
        tweet.setUser(user.get());
        tweet.setContent(dto.contet());

        tweetRepository.save(tweet);

        return ResponseEntity.ok().build();
    }
}
