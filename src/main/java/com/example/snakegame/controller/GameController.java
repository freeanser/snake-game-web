package com.example.snakegame.controller;

import com.example.snakegame.model.Score;
import com.example.snakegame.repository.ScoreRepository;

import javax.swing.JFrame;

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

  @GetMapping("/start-game")
  public String startGame() {
    // Create a new instance of JFrame
    JFrame jFrame = new JFrame();

    // Set the bounds (x, y, width, height) of the JFrame
    jFrame.setBounds(10, 10, 900, 720);

    // Make the JFrame non-resizable
    jFrame.setResizable(false);

    // Set the default close operation of the JFrame to exit on close
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add a new instance of GamePanel to the JFrame
    jFrame.add(new GamePanel());

    // Make the JFrame visible
    jFrame.setVisible(true);

    return "Game started!";
  }

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
