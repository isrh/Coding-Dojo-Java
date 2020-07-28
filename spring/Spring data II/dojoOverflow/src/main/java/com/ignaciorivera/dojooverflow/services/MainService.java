package com.ignaciorivera.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ignaciorivera.dojooverflow.models.Answer;
import com.ignaciorivera.dojooverflow.models.Question;
import com.ignaciorivera.dojooverflow.models.Tag;
import com.ignaciorivera.dojooverflow.repositories.AnswerRepository;
import com.ignaciorivera.dojooverflow.repositories.QuestionRepository;
import com.ignaciorivera.dojooverflow.repositories.TagRepository;



@Service
public class MainService {
	private final  QuestionRepository questionRepository;
	private final  AnswerRepository answerRepository;
	private final  TagRepository tagRepository;
	
	public MainService(QuestionRepository questionRepository,AnswerRepository answerRepository,TagRepository tagRepository) {
		this.questionRepository=questionRepository;
		this.answerRepository=answerRepository;
		this.tagRepository=tagRepository;
	}

	//Devolver todos las preguntas , respuestas , tags
	public List<Question> allQuestions() {
		return questionRepository.findAll();
		
	}
	
	public List<Answer> allAnswers() {
		return answerRepository.findAll();
		
	}
	
	public List<Tag> allTags() {
		return tagRepository.findAll();
		
	}
	
	//CREAR PREGUNTAS - RESPUESTAS -TAGS
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }
    

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }
    

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }
    
    //BUSCAR POR ID: PREGUNTAS - RESPUESTAS -TAGS
    public  Answer findAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if(optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        } else {
            return null;
        }
    }
    
    public  Tag findTag(Long id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if(optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }
    
    public  Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }
}

