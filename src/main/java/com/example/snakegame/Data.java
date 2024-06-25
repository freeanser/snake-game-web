package com.example.snakegame;

import javax.swing.*;
import java.net.URL;

public class Data {
  // URL for header image
  public static URL headerURL = Data.class.getResource("/statics/header.png");
  // ImageIcon for header image
  public static ImageIcon header = new ImageIcon(headerURL);

  // URL for up arrow image
  public static URL upURL = Data.class.getResource("/statics/up.png");
  // URL for down arrow image
  public static URL downURL = Data.class.getResource("/statics/down.png");
  // URL for left arrow image
  public static URL leftURL = Data.class.getResource("/statics/left.png");
  // URL for right arrow image
  public static URL rightURL = Data.class.getResource("/statics/right.png");
  // ImageIcon for up arrow image
  public static ImageIcon up = new ImageIcon(upURL);
  // ImageIcon for down arrow image
  public static ImageIcon down = new ImageIcon(downURL);
  // ImageIcon for left arrow image
  public static ImageIcon left = new ImageIcon(leftURL);
  // ImageIcon for right arrow image
  public static ImageIcon right = new ImageIcon(rightURL);

  // URL for body image
  public static URL bodyURL = Data.class.getResource("/statics/body.png");
  // ImageIcon for body image
  public static ImageIcon body = new ImageIcon(bodyURL);

  // URL for food image
  public static URL foodURL = Data.class.getResource("/statics/food.png");
  // ImageIcon for food image
  public static ImageIcon food = new ImageIcon(foodURL);
}
