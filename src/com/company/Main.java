package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\User\\OneDrive\\Desktop\\WarGame.txt");

        Swordsman swordsman = new Swordsman("Hndik", 10000, 10, 2);
        Archer archer = new Archer("Urish hndik", 10000, 10);

        System.out.print("Enter an option" +
                "\n1: SWORDSMAN  to attack ARCHER" +
                "\n2: ARCHER to attack SWORDSMAN" +
                "\nAny other option:" +
                "\nEXIT\n");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {

            case 1: {
                //swordsman->archer
                try (OutputStream outputStream = new FileOutputStream(file)) {

                    String attackInfo = "Player 1: SWORDSMAN " + swordsman.getName() + " - health: " + swordsman.getHealth() +
                            "\nPlayer 2: ARCHER " + archer.getName() + " - health: " + archer.getHealth() + "\n\n";
                    byte[] bytes = attackInfo.getBytes(StandardCharsets.UTF_8);
                    outputStream.write(bytes);

                    for (int i = archer.getHealth(); true; i--) {

                        swordsman.attack(archer, swordsman);
                        if (archer.getHealth() <= 0) {
                            String winnerSwordsman = "SWORDSMAN " + swordsman.getName() + " - health: " + swordsman.getHealth() +
                                    " ---- ARCHER " + archer.getName() + " - health: 0" +
                                    "\n\nSWORDSMAN WON!";
                            byte[] bytes1 = winnerSwordsman.getBytes(StandardCharsets.UTF_8);
                            outputStream.write(bytes1);
                            break;
                        }

                        String hitBySwordsman = "SWORDSMAN " + swordsman.getName() + " - health: " + swordsman.getHealth() +
                                " ---- ARCHER " + archer.getName() + " - health: " + archer.getHealth() + "\n";
                        byte[] bytes2 = hitBySwordsman.getBytes(StandardCharsets.UTF_8);
                        outputStream.write(bytes2);

                        archer.attack(swordsman, archer);
                        if (swordsman.getHealth() <= 0) {
                            String winnerArcher = "ARCHER " + archer.getName() + " - health: " + archer.getHealth() +
                                    " ---- SWORDSMAN " + swordsman.getName() + " - health: 0" +
                                    "\n\nARCHER WON!";
                            byte[] bytes3 = winnerArcher.getBytes(StandardCharsets.UTF_8);
                            outputStream.write(bytes3);
                            break;
                        }

                        String hitByArcher = "ARCHER " + archer.getName() + " - health: " + archer.getHealth() +
                                " ---- SWORDSMAN " + swordsman.getName() + " - health: " + swordsman.getHealth() + "\n";
                        byte[] bytes4 = hitByArcher.getBytes(StandardCharsets.UTF_8);
                        outputStream.write(bytes4);
                    }
                    break;

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            case 2: {
                //archer->swordsman
                try (OutputStream outputStream = new FileOutputStream(file)) {

                    String attackInfo = "Player 1: ARCHER " + archer.getName() + " - health: " + archer.getHealth() +
                            "\nPlayer 2: SWORDSMAN " + swordsman.getName() + " - health: " + swordsman.getHealth() + "\n\n";
                    byte[] bytes = attackInfo.getBytes(StandardCharsets.UTF_8);
                    outputStream.write(bytes);

                    for (int i = swordsman.getHealth(); true; i--) {

                        archer.attack(swordsman, archer);
                        if (swordsman.getHealth() <= 0) {
                            String winnerArcher = "ARCHER " + archer.getName() + " - health: " + archer.getHealth() +
                                    " ---- SWORDSMAN " + swordsman.getName() + " - health: 0" +
                                    "\n\nARCHER WON!";
                            byte[] bytes1 = winnerArcher.getBytes(StandardCharsets.UTF_8);
                            outputStream.write(bytes1);
                            break;
                        }

                        String hitByArcher = "ARCHER " + archer.getName() + " - health: " + archer.getHealth() +
                                " ---- SWORDSMAN " + swordsman.getName() + " - health: " + swordsman.getHealth() + "\n";
                        byte[] bytes2 = hitByArcher.getBytes(StandardCharsets.UTF_8);
                        outputStream.write(bytes2);

                        swordsman.attack(archer, swordsman);
                        if (archer.getHealth() <= 0) {
                            String winnerSwordsman = "SWORDSMAN " + swordsman.getName() + " - health: " + swordsman.getHealth() +
                                    " ---- ARCHER " + archer.getName() + " - health: 0" +
                                    "\n\nSWORDSMAN WON!";
                            byte[] bytes3 = winnerSwordsman.getBytes(StandardCharsets.UTF_8);
                            outputStream.write(bytes3);
                            break;
                        }

                        String hitBySwordsman = "SWORDSMAN " + swordsman.getName() + " - health: " + swordsman.getHealth() +
                                " ---- ARCHER " + archer.getName() + " - health: " + archer.getHealth() + "\n";
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            default: {
            }
        }
    }
}