package com.matthew_sandoval.t3mesh.game;

import java.util.UUID;

public class Game {
    private final String gameId;
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private enum GameState { WAITING, IN_PROGRESS, FINISHED };
    private GameState gameState;
    private Player winner;
    private int turnCount = 0;

    public Game(Player player1, Player player2) {
        this.gameId = UUID.randomUUID().toString();
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.gameState = GameState.WAITING;
        this.winner = null;
    }

    public String getGameId() {
        return gameId;
    }

    public boolean makeMove(int row, int col, Player player) {
        return this.board.makeMove(row, col, player.getSymbol());
    }

    public void switchTurn() {
        if (this.currentPlayer.equals(this.player1)) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isGameOver() {
        return gameState == GameState.FINISHED;
    }

    public void startGame() {
        this.gameState = GameState.IN_PROGRESS;
        this.board.reset();
        this.currentPlayer = player1;
        this.winner = null;
        this.turnCount = 0;
    }

    public boolean isDraw() {
        return board.isFull() && winner == null;
    }

    public void resetGame() {
        this.board.reset();
        this.gameState = GameState.WAITING;
        this.currentPlayer = player1;
        this.winner = null;
        this.turnCount = 0;
    }

    public Board getBoard() {
        return board;
    }
}