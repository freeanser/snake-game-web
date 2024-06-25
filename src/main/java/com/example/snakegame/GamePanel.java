package com.example.snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
  // Snake data structure
  int length;
  int[] snakeX = new int[600];
  int[] snakeY = new int[500];
  String direction;
  int foodX;
  int foodY;
  int score;
  Random random = new Random();

  boolean isFalse = false;
  boolean isStart = false;
  Timer timer = new Timer(100, this);

  // Constructor
  public GamePanel() {
    init();
    this.setFocusable(true);
    this.addKeyListener(this);
  }

  public void init() {
    length = 3;
    snakeX[0] = 100;
    snakeY[0] = 100;
    snakeX[1] = 75;
    snakeY[1] = 100;
    snakeX[2] = 50;
    snakeY[2] = 100;
    direction = "R";
    foodX = 25 + 25 * random.nextInt(34);
    foodY = 75 + 25 * random.nextInt(24);
    score = 0;
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setBackground(Color.white);
    Data.header.paintIcon(this, g, 25, 11); // Draw the header
    g.fillRect(25, 75, 850, 600); // Default game interface

    g.setColor(new Color(51, 25, 0)); // Dark brown color
    g.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
    g.drawString("Length:" + length, 750, 35);
    g.drawString("Score:" + score, 750, 50);

    // Food
    Data.food.paintIcon(this, g, foodX, foodY);

    if (direction.equals("R")) {
      Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
    } else if (direction.equals("L")) {
      Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
    } else if (direction.equals("U")) {
      Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
    } else if (direction.equals("D")) {
      Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
    }

    for (int i = 1; i < length; i++) {
      Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
    }

    if (!isStart) {
      g.setColor(Color.white);
      g.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
      g.drawString("Press space to start the game", 300, 300);
    }

    if (isFalse) {
      g.setColor(Color.red);
      g.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
      g.drawString("Failure, press space to restart", 300, 300);
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_SPACE) {
      if (isFalse) {
        isFalse = false;
        init();
      } else {
        isStart = !isStart;
      }
      repaint();
    }
    if (keyCode == KeyEvent.VK_UP && !direction.equals("D")) {
      direction = "U";
      repaint();
    }
    if (keyCode == KeyEvent.VK_LEFT && !direction.equals("R")) {
      direction = "L";
      repaint();
    }
    if (keyCode == KeyEvent.VK_DOWN && !direction.equals("U")) {
      direction = "D";
      repaint();
    }
    if (keyCode == KeyEvent.VK_RIGHT && !direction.equals("L")) {
      direction = "R";
      repaint();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (isStart && !isFalse) {
      for (int i = length - 1; i > 0; i--) {
        snakeX[i] = snakeX[i - 1];
        snakeY[i] = snakeY[i - 1];
      }
      if (direction.equals("R")) {
        snakeX[0] += 25;
        if (snakeX[0] > 850) {
          snakeX[0] = 25;
        }
      } else if (direction.equals("L")) {
        snakeX[0] -= 25;
        if (snakeX[0] < 25) {
          snakeX[0] = 850;
        }
      } else if (direction.equals("U")) {
        snakeY[0] -= 25;
        if (snakeY[0] < 75) {
          snakeY[0] = 650;
        }
      } else if (direction.equals("D")) {
        snakeY[0] += 25;
        if (snakeY[0] > 650) {
          snakeY[0] = 75;
        }
      }
      if (snakeX[0] == foodX && snakeY[0] == foodY) {
        length++;
        score += 10;
        foodX = 25 + 25 * random.nextInt(34);
        foodY = 75 + 25 * random.nextInt(24);
      }
      for (int i = 1; i < length; i++) {
        if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
          isFalse = true;
        }
      }
      repaint();
    }
    timer.start();
  }
}
