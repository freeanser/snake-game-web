package com.example.snakegame.controller;

import com.example.snakegame.model.Score;
import com.example.snakegame.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

  @Autowired
  private ScoreRepository scoreRepository;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("scores", scoreRepository.findAll());
    return "index";
  }

  @PostMapping("/score")
  public String saveScore(@RequestParam String player, @RequestParam int score) {
    Score newScore = new Score();
    newScore.setPlayer(player);
    newScore.setScore(score);
    scoreRepository.save(newScore);
    return "redirect:/";
  }
}
