package com.matthew_sandoval.t3mesh.game;

import java.util.UUID;

public class Player {
    private final String playerId;
    private final char symbol;
    private final String name;
    private final boolean isLocal;
    private int wins;
    private int losses;
    private int draws;

    public Player(String name, char symbol) {
        this.playerId = UUID.randomUUID().toString();
        this.symbol = symbol;
        this.name = name;
        this.isLocal = true;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }

    public Player(String name, char symbol, String playerId, boolean isLocal) {
        this.playerId = playerId;
        this.symbol = symbol;
        this.name = name;
        this.isLocal = isLocal;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public void incrementWins() {
        this.wins++;
    }

    public void incrementLosses() {
        this.losses++;
    }

    public void incrementDraws() {
        this.draws++;
    }

    public void resetStats() {
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }

    public String getStats() {
        return String.format("Wins: %d, Losses: %d, Draws: %d", this.wins, this.losses, this.draws);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return playerId.equals(player.playerId);
    }

    @Override
    public int hashCode() {
        return playerId.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Player{name='%s', symbol=%c, isLocal=%b}", name, symbol, isLocal);
    }
}