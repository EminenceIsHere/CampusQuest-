package com.example.CampusQuest.service;

import com.example.CampusQuest.controller.DoubtsController;
import com.example.CampusQuest.entity.Doubts;

import com.example.CampusQuest.repository.DoubtsRepository;
import java.util.Collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DoubtsService {



    @Builder
    @AllArgsConstructor
    @Data
    public static class Reply{
        private ObjectId id;
        private String repliedBy;
        private String message;

    }
    private DoubtsRepository doubtsRepository;

    @Autowired
    public DoubtsService(DoubtsRepository doubtsRepository) {
        this.doubtsRepository = doubtsRepository;
    }

    public List<Doubts> getAllDoubts(){
        try{
            List<Doubts> doubtsList = doubtsRepository.findAll();
            return doubtsList;
        }
        catch(Exception e){
            log.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    public boolean deleteDoubtsById(ObjectId id,String name) {
        if(doubtsRepository.findById(id).get().getUserName().equals(name)){
            try {
                log.info("deleting doubt {}",id);
                doubtsRepository.deleteById(id);
                return true;
            }catch (Exception e){
                log.error(e.getMessage());
                return false;
            }
        }
        log.error("doubt not deleted",id);
return false;
    }

    public boolean addDoubts(@RequestBody Doubts doubts) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        try {
            doubtsRepository.save(Doubts.builder()
                    .userName(userName)
                    .doubtTitle(doubts.getDoubtTitle())
                    .doubtDescription(doubts.getDoubtDescription())
                    .doubtDate(new Date())
                    .doubtStatus(false)
                    .build());
            log.info("Doubts posted....");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public DoubtsService.Reply addReply(Reply reply) {
        try {
            Optional<Doubts> doubts = doubtsRepository.findById(reply.id);
            if (doubts.isPresent()) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                   String userName = authentication.getName();
                    reply.setRepliedBy(userName);
                    doubts.get().getReplies().add(reply);
                    doubtsRepository.save(doubts.get());
                    return reply;
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
    public List<DoubtsService.Reply> getReply(ObjectId id){
        try {
            return doubtsRepository.findById(id).get().getReplies();
        }catch(Exception e){
            log.info(e.getMessage());
            return Collections.emptyList();
        }
    }
    public List<Doubts> getDoubtsByName(String username) {

        try {
           return doubtsRepository.findByUserName(username);
        }catch (Exception e){
            return Collections.emptyList();
        }

    }
}
